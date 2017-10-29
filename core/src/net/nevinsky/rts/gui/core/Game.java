package net.nevinsky.rts.gui.core;

import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;
import java.util.List;

public class Game implements GraphicObject {
    private int width;
    private int length;

    private final GraphicObject map;

    private List<GraphicObject> renderObjects = new ArrayList<GraphicObject>();

    public Game() {
        map = new Map();
        renderObjects.add(map);
    }

    @Override
    public void render(Batch batch) {
        map.render(batch);
    }

    @Override
    public void translate(float x, float y) {
        for (GraphicObject obj : renderObjects) {
            obj.translate(x, y);
        }
    }


}
