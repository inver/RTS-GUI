package net.nevinsky.rts.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import net.nevinsky.rts.gui.core.GameObject;

public class RtsInputProcessor implements InputProcessor {

    private final GameObject game;

    public RtsInputProcessor(GameObject game) {
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            game.translate(-10.0f, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            game.translate(10.0f, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            game.translate(0, -10.0f);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            game.translate(0, 10.0f);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
