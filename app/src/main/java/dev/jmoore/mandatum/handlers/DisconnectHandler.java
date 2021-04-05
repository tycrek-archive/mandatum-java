package dev.jmoore.mandatum.handlers;

import dev.jmoore.mandatum.Bot;
import dev.jmoore.mandatum.utils.Logger;
import net.dv8tion.jda.api.events.DisconnectEvent;

public class DisconnectHandler extends Handler<DisconnectEvent> {
    public DisconnectHandler(Bot bot) {
        super(bot);
    }

    @Override
    protected void onHandle(DisconnectEvent event) {
        Logger.warn("Disconnected!");
    }
}
