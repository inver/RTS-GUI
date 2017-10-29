package net.nevinsky.rts.gui.screens;

import net.nevinsky.rts.gui.net.dto.Command;

/**
 * @author Alexey Nevinsky
 * @since 29-10-2017
 */
public interface RtsScreen<C extends Command> {
    ScreenId getId();

    void updateState(C command);
}
