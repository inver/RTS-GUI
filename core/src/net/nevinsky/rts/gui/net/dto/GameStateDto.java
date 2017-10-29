package net.nevinsky.rts.gui.net.dto;

import java.util.List;

public class GameStateDto {
    private long id;
    private long tick;
    private MapDto map;
    private List<UnitDto> units;
    private List<PlayerDto> players;
}
