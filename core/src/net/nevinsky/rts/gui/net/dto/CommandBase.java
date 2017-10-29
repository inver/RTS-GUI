package net.nevinsky.rts.gui.net.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandBase implements Command {
    private String code;
}
