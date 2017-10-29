package net.nevinsky.rts.gui.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * @author Alexey Nevinsky
 * @since 29-10-2017
 */
public class GameRenderer {

    private static final String TAG = GameRenderer.class.getSimpleName();

    private final GameWorld world;
    private final Stage stage;

    public GameRenderer(GameWorld world) {
        this.world = world;

        stage = new Stage(new ScreenViewport());
    }

    public Camera getCamera() {
        return stage.getCamera();
    }

    public void render() {
//        Gdx.app.log(TAG, "render");

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);


        for (Actor actor : world.getActors()) {
            stage.addActor(actor);
        }
        stage.act();
        stage.draw();
    }
}
