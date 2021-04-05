package dev.jmoore.mandatum.handlers;

import dev.jmoore.mandatum.Bot;
import dev.jmoore.mandatum.utils.Logger;
import net.dv8tion.jda.api.events.ResumedEvent;

public class ResumedHandler extends Handler<ResumedEvent> {
    public ResumedHandler(Bot bot) {
        super(bot);
    }

    @Override
    protected void onHandle(ResumedEvent event) {
        Logger.debug("Resumed!");
    }
}
