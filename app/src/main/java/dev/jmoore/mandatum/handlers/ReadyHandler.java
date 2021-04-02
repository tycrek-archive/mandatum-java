package dev.jmoore.mandatum.handlers;

import net.dv8tion.jda.api.events.ReadyEvent;

public class ReadyHandler extends Handler<ReadyEvent> {
    @Override
    public void onHandle(ReadyEvent event) {
        System.out.println("Bot online!");
    }
}
