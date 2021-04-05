package dev.jmoore.mandatum.handlers;

import dev.jmoore.mandatum.Bot;
import dev.jmoore.mandatum.utils.Logger;
import net.dv8tion.jda.api.events.ReconnectedEvent;

public class ReconnectedHandler extends Handler<ReconnectedEvent> {
    public ReconnectedHandler(Bot bot) {
        super(bot);
    }

    @Override
    protected void onHandle(ReconnectedEvent event) {
        Logger.debug("Reconnected!");
    }
}
