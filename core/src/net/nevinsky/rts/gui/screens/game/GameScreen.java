package net.nevinsky.rts.gui.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import net.nevinsky.rts.gui.net.dto.CommandGameState;
import net.nevinsky.rts.gui.net.dto.GameStateDto;
import net.nevinsky.rts.gui.screens.RtsScreen;
import net.nevinsky.rts.gui.screens.ScreenId;

/**
 * @author Alexey Nevinsky
 * @since 29-10-2017
 */
public class GameScreen implements Screen, RtsScreen<CommandGameState> {
    private float length;
    private float width;

    private Container map;

    private final GameWorld world;
    private final GameRenderer renderer;

    public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");

        world = new GameWorld();
        renderer = new GameRenderer(world);

        GameScreenInputHandler inputHandler = new GameScreenInputHandler(renderer.getCamera());
        Gdx.input.setInputProcessor(inputHandler);
    }

    @Override
    public void updateState(CommandGameState command) {
        GameStateDto state = command.getGame();

        world.updateState(state);
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
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

    }

    @Override
    public ScreenId getId() {
        return ScreenId.GAME_PROCESS;
    }

}
