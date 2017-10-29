package net.nevinsky.rts.gui.net.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapDto {
    private Size size;

    @Getter
    @Setter
    public static class Size {
        private float x;
        private float y;
    }
}
