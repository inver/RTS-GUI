package net.nevinsky.rts.gui.net.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

import static net.nevinsky.rts.gui.net.dto.Commands.REGISTER;

@Getter
@Setter
public class CommandRegister implements Serializable {

    private String code;
    private String type;
    private String name;

    private long playerId;

    public CommandRegister() {
        code = REGISTER;
    }

    public CommandRegister(boolean isGui) {
        code = REGISTER;
        if (isGui) {
//            type = "gui"; пока так, потом Дима поправит
            type = "strategy";
        } else {
            type = "strategy";
        }
        name = UUID.randomUUID().toString();
    }
}
