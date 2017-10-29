package net.nevinsky.rts.gui.net;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;
import com.github.czyzby.websocket.AbstractWebSocketListener;
import com.github.czyzby.websocket.WebSocket;
import com.github.czyzby.websocket.data.WebSocketException;
import net.nevinsky.rts.gui.RtsGame;
import net.nevinsky.rts.gui.net.dto.CommandBase;
import net.nevinsky.rts.gui.net.dto.CommandGameState;
import net.nevinsky.rts.gui.net.dto.CommandRegister;
import net.nevinsky.rts.gui.net.dto.Commands;
import net.nevinsky.rts.gui.screens.game.GameScreen;
import net.nevinsky.rts.gui.screens.ScreenId;
import net.nevinsky.rts.gui.screens.WaitingScreen;

public class RtsWsListener extends AbstractWebSocketListener {

    private Json json = new Json();

    private final RtsGame game;

    public RtsWsListener(RtsGame game) {
        this.game = game;
        game.setScreen(new WaitingScreen(game));
        json.setIgnoreUnknownFields(true);
    }

    @Override
    protected boolean onMessage(WebSocket webSocket, Object packet) throws WebSocketException {
        String commandStr = ((JsonValue) packet).toJson(JsonWriter.OutputType.json);
        CommandBase c = json.fromJson(CommandBase.class, commandStr);

        if (Commands.REGISTER.equals(c.getCode())) {
            receiveRegisterResult(json.fromJson(CommandRegister.class, commandStr));
        } else if (Commands.GAME_STATE.equals(c.getCode())) {
            receivedGameState(json.fromJson(CommandGameState.class, commandStr));
        }

        Gdx.app.log("INFO", "Received command: " + commandStr);

        return FULLY_HANDLED;
    }

    private void receivedGameState(final CommandGameState gameState) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                if (game.getScreenId() != ScreenId.GAME_PROCESS) {
                    game.setScreen(new GameScreen());
                }
                game.updateScreen(gameState);
            }
        });
    }

    private void receiveRegisterResult(CommandRegister register) {

    }
}
