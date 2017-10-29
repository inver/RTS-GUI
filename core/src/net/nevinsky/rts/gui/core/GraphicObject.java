package net.nevinsky.rts.gui.core;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface GraphicObject {
    void render(Batch batch);

    void translate(float x, float y);
}
