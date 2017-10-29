package net.nevinsky.rts.gui.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Alexey Nevinsky
 * @since 29-10-2017
 */
public class GameScreenInputHandler extends InputAdapter {

    private final Camera camera;

    private int lastX;
    private int lastY;

    private float cameraPosX;
    private float cameraPosY;

    private float zoom = 1;

    public GameScreenInputHandler(Camera camera) {
        this.camera = camera;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("GameScreenInputHandler", "touchX: " + screenX + ", touchY: " + screenY);

        lastX = screenX;
        lastY = screenY;

        cameraPosX = camera.position.x;
        cameraPosY = camera.position.y;
        Gdx.app.log("CameraPosition", "x: " + cameraPosX + ", y: " + cameraPosY);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Gdx.app.log("GameScreenInputHandler", "touchDraggedX: " + screenX + ", touchDraggedY: " + screenY);
        Vector2 newPos = new Vector2(cameraPosX - (screenX - lastX) * zoom, cameraPosY + (screenY - lastY) * zoom);
        camera.position.set(newPos, camera.position.z);

        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        OrthographicCamera c = (OrthographicCamera) camera;
        c.zoom = c.zoom + amount;
        zoom = c.zoom;
        return true;
    }
}
