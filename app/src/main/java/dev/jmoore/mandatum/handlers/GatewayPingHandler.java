package dev.jmoore.mandatum.handlers;

import dev.jmoore.mandatum.Bot;
import net.dv8tion.jda.api.events.GatewayPingEvent;

public class GatewayPingHandler extends Handler<GatewayPingEvent> {
    public GatewayPingHandler(Bot bot) {
        super(bot);
    }

    @Override
    protected void onHandle(GatewayPingEvent event) {
        this.getBot().setGatewayPing(event.getNewPing());
    }
}
