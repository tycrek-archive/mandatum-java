package dev.jmoore.mandatum.handlers;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class MessageReceivedHandler extends Handler<GuildMessageReceivedEvent> {
    @Override
    protected void onHandle(GuildMessageReceivedEvent event) {
        System.out.printf("Message received from [%s] in [%s]: %s%n", event.getAuthor().getName(), event.getGuild().getName(), event.getMessage());
    }
}
