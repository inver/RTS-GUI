package net.nevinsky.rts.gui.net.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameStateDto {
    private long id;
    private long tick;
    private MapDto map;
    private List<UnitDto> units;
    private List<PlayerDto> players;
}
