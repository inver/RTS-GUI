package net.nevinsky.rts.gui.net.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import static net.nevinsky.rts.gui.net.dto.Commands.GAME_STATE;

@Getter
@Setter
public class CommandGameState implements Serializable, Command {

    private String code;
    private GameStateDto game;

    public CommandGameState() {
        code = GAME_STATE;
    }
}
