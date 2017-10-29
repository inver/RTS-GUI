package net.nevinsky.rts.gui.net.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitDto {
    private long id;
    private long playerId;
    private float health;
    private PositionDto position;
    private PositionDto destination;
    private long target;
    private float attackRange;
    private float attackPower;
    private float speed;
    private float size;
}
