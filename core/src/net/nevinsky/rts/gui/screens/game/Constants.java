package net.nevinsky.rts.gui.screens.game;

/**
 * @author Alexey Nevinsky
 * @since 29-10-2017
 */
public final class Constants {

    //1 float из сервера = 10 пикселям.
    public static final int FLOAT_TO_PIXELS = 10;

    public static int toPixels(Number number) {
        return number.intValue() * FLOAT_TO_PIXELS;
    }

    private Constants() {
    }
}
