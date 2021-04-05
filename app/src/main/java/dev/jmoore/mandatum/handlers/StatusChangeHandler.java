package dev.jmoore.mandatum.handlers;

import dev.jmoore.mandatum.Bot;
import net.dv8tion.jda.api.events.StatusChangeEvent;

public class StatusChangeHandler extends Handler<StatusChangeEvent> {
    public StatusChangeHandler(Bot bot) {
        super(bot);
    }

    @Override
    protected void onHandle(StatusChangeEvent event) {
    }
}
