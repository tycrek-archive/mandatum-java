package dev.jmoore.mandatum.handlers;

import dev.jmoore.mandatum.Bot;
import net.dv8tion.jda.api.events.ExceptionEvent;

public class ExceptionHandler extends Handler<ExceptionEvent> {
    public ExceptionHandler(Bot bot) {
        super(bot);
    }

    @Override
    protected void onHandle(ExceptionEvent event) {
    }
}
