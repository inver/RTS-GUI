package net.nevinsky.rts.gui.net;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;
import com.github.czyzby.websocket.AbstractWebSocketListener;
import com.github.czyzby.websocket.WebSocket;
import com.github.czyzby.websocket.data.WebSocketException;
import net.nevinsky.rts.gui.net.dto.CommandBase;

public class RtsWsListener extends AbstractWebSocketListener {

    private Json json = new Json();

    public RtsWsListener() {
        json.setIgnoreUnknownFields(true);
    }

    @Override
    protected boolean onMessage(WebSocket webSocket, Object packet) throws WebSocketException {
        CommandBase c = json.fromJson(CommandBase.class, ((JsonValue) packet).toJson(JsonWriter.OutputType.json));



        System.out.println(packet);

        return FULLY_HANDLED;
    }
}
