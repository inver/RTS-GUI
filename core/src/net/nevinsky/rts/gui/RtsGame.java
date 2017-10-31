package net.nevinsky.rts.gui;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.github.czyzby.websocket.WebSocket;
import com.github.czyzby.websocket.WebSockets;
import com.github.czyzby.websocket.serialization.impl.JsonSerializer;
import lombok.Getter;
import net.nevinsky.rts.gui.core.GameObject;
import net.nevinsky.rts.gui.net.RtsWsListener;
import net.nevinsky.rts.gui.net.dto.Command;
import net.nevinsky.rts.gui.net.dto.CommandRegister;
import net.nevinsky.rts.gui.screens.RtsScreen;
import net.nevinsky.rts.gui.screens.ScreenId;

/**
 * @author Alexey Nevinsky
 * @since 29-10-2017
 */
public class RtsGame extends Game {

    private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

    @Getter
    private BitmapFont font, levels;
    @Getter
    private ScreenId screenId;

    private WebSocket socket;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        initFonts();
        initNet();

//        batch = new SpriteBatch();
//        game = new GameObject();

        Gdx.input.setInputProcessor(new RtsInputProcessor(new GameObject()));
    }

    @Override
    public void setScreen(Screen screen) {
        super.setScreen(screen);

        screenId = ((RtsScreen) screen).getId();
    }

    public void updateScreen(Command c) {
        ((RtsScreen) screen).updateState(c);
    }

    private void initFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.classpath("RussoOne-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.characters = FONT_CHARACTERS; // Наши символы

        param.size = Gdx.graphics.getHeight() / 18; // Размер шрифта. Я сделал его исходя из размеров экрана. Правда коряво, но вы сами можете поиграться, как вам угодно.
        font = generator.generateFont(param); // Генерируем шрифт
        font.setColor(Color.WHITE); // Цвет белый

        param.size = Gdx.graphics.getHeight() / 20;
        levels = generator.generateFont(param);
        levels.setColor(Color.WHITE);

        generator.dispose(); // Уничтожаем наш генератор за ненадобностью.
    }

    private void initNet() {
        socket = WebSockets.newSocket("ws://127.0.0.1:5000/ws");
        socket.addListener(new RtsWsListener(this));

        JsonSerializer serializer = new JsonSerializer();
        serializer.setPreserveClassName(false);
        socket.setSerializer(serializer);
        socket.connect();

        socket.send(new CommandRegister(true));
    }

    @Override
    public void dispose() {
        super.dispose();
        WebSockets.closeGracefully(socket);
    }
}
