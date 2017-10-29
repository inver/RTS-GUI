package net.nevinsky.rts.gui.screens.game.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author Alexey Nevinsky
 * @since 29-10-2017
 */
public class Map extends Actor {

    private final Texture mapTexture;



    public Map(float width, float length) {
        Pixmap pixmap = new Pixmap((int) width, (int) length, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.GRAY);
        pixmap.fillRectangle(0, 0, (int) width, (int) length);
        mapTexture = new Texture(pixmap);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(1, 1, 1, parentAlpha);
        batch.draw(mapTexture, getX(), getY());
    }
}
