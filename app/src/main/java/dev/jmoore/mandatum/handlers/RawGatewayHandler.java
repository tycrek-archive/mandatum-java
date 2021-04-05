package dev.jmoore.mandatum.handlers;

import dev.jmoore.mandatum.Bot;
import net.dv8tion.jda.api.events.RawGatewayEvent;

public class RawGatewayHandler extends Handler<RawGatewayEvent> {
    public RawGatewayHandler(Bot bot) {
        super(bot);
    }

    @Override
    protected void onHandle(RawGatewayEvent event) {
    }
}
