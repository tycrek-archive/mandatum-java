package dev.jmoore.mandatum.handlers;

import dev.jmoore.mandatum.Mandatum;
import dev.jmoore.mandatum.utils.Logger;
import net.dv8tion.jda.api.events.ReadyEvent;

public class ReadyHandler extends Handler<ReadyEvent> {
    @Override
    public void onHandle(ReadyEvent event) {
        Logger.info("Bot online! Guilds: %s (Available: %s; Unavailable: %s)", event.getGuildTotalCount(), event.getGuildAvailableCount(), event.getGuildUnavailableCount());
        Logger.info("Owner was created at: %s", Mandatum.bot.getOwner().getTimeCreated());
    }
}
