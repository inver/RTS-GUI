package net.nevinsky.rts.gui.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.czyzby.websocket.CommonWebSockets;
import net.nevinsky.rts.gui.RtsApplication;

public class DesktopLauncher {
	public static void main (String[] arg) {
        CommonWebSockets.initiate();

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 600;
		config.width = 800;
		config.useGL30 = true;
		config.title = "RTS game";
		new LwjglApplication(new RtsApplication(), config);
	}
}
