package net.nevinsky.rts.gui.screens.game.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import net.nevinsky.rts.gui.net.dto.UnitDto;

import static net.nevinsky.rts.gui.screens.game.Constants.toPixels;

/**
 * @author Alexey Nevinsky
 * @since 29-10-2017
 */
public class Mariner extends Actor {

    private final Texture texture;

    public Mariner(UnitDto unitDto) {
        int range = toPixels(unitDto.getAttackRange());

        Pixmap pixmap = new Pixmap(range + 1, range + 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.GREEN);
        pixmap.fillCircle(range / 2, range / 2, toPixels(unitDto.getSize() / 2));
        pixmap.setColor(Color.RED);
        pixmap.drawCircle(range / 2, range / 2, range / 2);
        pixmap.drawCircle(range / 2, range / 2, range / 2 + 1);
        texture = new Texture(pixmap);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(1, 1, 1, parentAlpha);
        batch.draw(texture, getX(), getY());
    }
}
