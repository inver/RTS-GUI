package net.nevinsky.rts.gui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import net.nevinsky.rts.gui.RtsGame;
import net.nevinsky.rts.gui.net.dto.Command;

import static net.nevinsky.rts.gui.screens.ScreenId.WAITING;

/**
 * @author Alexey Nevinsky
 * @since 29-10-2017
 */
public class WaitingScreen implements Screen, RtsScreen {

    private static final String WAITING_FOR_START = "Waiting for start";

    private final RtsGame game;

    private final Stage stage;

    private int count = 0;
    private Label waitingLabel;

    public WaitingScreen(RtsGame game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());

        waitingLabel = new Label(WAITING_FOR_START, new Label.LabelStyle(game.getFont(), Color.WHITE));
        waitingLabel.setPosition(10, Gdx.graphics.getHeight() / 2);
        stage.addActor(waitingLabel);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);


        waitingLabel.setText(getText());

        stage.act(delta);
        stage.draw();
    }

    private String getText() {
        if (count < 120) {
            count++;
        } else {
            count = 0;
        }

        int dots = (count / 30) % 4;
        StringBuilder res = new StringBuilder(WAITING_FOR_START);
        for (int i = 0; i < dots; i++) {
            res.append(".");
        }
        return res.toString();
    }

    @Override
    public void updateState(Command command) {

    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        game.dispose();
    }

    @Override
    public ScreenId getId() {
        return WAITING;
    }
}
