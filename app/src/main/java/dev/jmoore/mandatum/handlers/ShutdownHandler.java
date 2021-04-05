package dev.jmoore.mandatum.handlers;

import dev.jmoore.mandatum.Bot;
import dev.jmoore.mandatum.utils.Logger;
import net.dv8tion.jda.api.events.ShutdownEvent;

public class ShutdownHandler extends Handler<ShutdownEvent> {
    public ShutdownHandler(Bot bot) {
        super(bot);
    }

    @Override
    protected void onHandle(ShutdownEvent event) {
        Logger.info("Mandatum shut down at %s with code [%s]", event.getTimeShutdown(), event.getCode());
    }
}
