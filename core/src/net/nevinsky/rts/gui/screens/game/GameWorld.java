package net.nevinsky.rts.gui.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import lombok.Getter;
import net.nevinsky.rts.gui.net.dto.GameStateDto;
import net.nevinsky.rts.gui.net.dto.UnitDto;
import net.nevinsky.rts.gui.screens.game.actors.Map;
import net.nevinsky.rts.gui.screens.game.actors.Mariner;

import java.util.ArrayList;
import java.util.List;

import static net.nevinsky.rts.gui.screens.game.Constants.toPixels;

/**
 * @author Alexey Nevinsky
 * @since 29-10-2017
 */
public class GameWorld {

    private static final String TAG = GameWorld.class.getSimpleName();

    @Getter
    private List<Actor> actors = new ArrayList<Actor>();

    private Map map;

    public GameWorld() {
//        map = new Map(500f, 300f);
//        actors.add(map);

//        mariner = new Mariner(10);
//        actors.add(mariner);
    }

    public void updateState(GameStateDto dto) {
        if (map == null) {
            initMap(dto);
        }

        if (dto.getUnits() != null) {
            Mariner m;
            for (UnitDto unitDto : dto.getUnits()) {
                m = new Mariner(unitDto);
                m.setX(toPixels(unitDto.getPosition().getX()));
                m.setY(toPixels(unitDto.getPosition().getY()));
                actors.add(m);
            }
        }
    }

    private void initMap(GameStateDto dto) {
        map = new Map(toPixels(dto.getMap().getSize().getX()), toPixels(dto.getMap().getSize().getY()));
        actors.add(map);
    }

    public void update(float delta) {
//        Gdx.app.log(TAG, "update");

//        mariner.setX(mariner.getX() + 1);
//        if (mariner.getX() > 137) {
//            mariner.setX(0);
//        }
    }
}
