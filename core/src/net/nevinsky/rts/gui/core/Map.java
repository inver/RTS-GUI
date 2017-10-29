package net.nevinsky.rts.gui.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Map implements GraphicObject {

    private static final String TEXTURE_PATH = "core/assets/map_sand.jpg";
//    private final Texture sandTexture;
//    private final Sprite mapSprite;

    public Map() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();


//        sandTexture = new Texture(Gdx.files.internal(TEXTURE_PATH));
//        mapSprite = new Sprite(sandTexture);
//        mapSprite.setPosition(w / 2 - mapSprite.getWidth() / 2, h / 2 - mapSprite.getHeight() / 2);
    }

    @Override
    public void render(Batch batch) {
//        batch.draw(mapSprite, mapSprite.getX(), mapSprite.getY());
    }

    @Override
    public void translate(float x, float y) {
//        mapSprite.translate(x, y);
    }
}
