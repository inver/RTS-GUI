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
public class Mariner extends Actor {

    private final Texture texture;

    public Mariner(float size) {
        Pixmap pixmap = new Pixmap((int) size, (int) size, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.GREEN);
        pixmap.fillCircle((int) size / 2, (int) size / 2, (int) size / 2);
        texture = new Texture(pixmap);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(1, 1, 1, parentAlpha);
        batch.draw(texture, getX(), getY());
    }
}
