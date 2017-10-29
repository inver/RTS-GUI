package net.nevinsky.rts.gui;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.czyzby.websocket.WebSocket;
import com.github.czyzby.websocket.WebSockets;
import com.github.czyzby.websocket.serialization.impl.JsonSerializer;
import net.nevinsky.rts.gui.core.Game;
import net.nevinsky.rts.gui.net.RtsWsListener;
import net.nevinsky.rts.gui.net.dto.CommandRegister;

public class RtsApplication extends ApplicationAdapter {
    SpriteBatch batch;

    Game game;

    private WebSocket socket;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        // Note: you can also use WebSockets.newSocket() and WebSocket.toWebSocketUrl() methods.
        socket = WebSockets.newSocket("ws://127.0.0.1:5000/ws");
        // By default, JsonSerializer will be used to send objects. If you want to change it, use setSerializer method.
        // For example, uncomment the following code to use BASE64 encoding additionally to JSON serialization:
        // socket.setSerializer(new Base64Serializer(new JsonSerializer()));
        socket.addListener(new RtsWsListener());

        JsonSerializer serializer = new JsonSerializer();
        serializer.setPreserveClassName(false);
        socket.setSerializer(serializer);
        socket.connect();

        socket.send(new CommandRegister(true));

        batch = new SpriteBatch();
        game = new Game();

        Gdx.input.setInputProcessor(new RtsInputProcessor(game));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        batch.begin();
        game.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        WebSockets.closeGracefully(socket);
    }
}