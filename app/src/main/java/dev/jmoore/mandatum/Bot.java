package dev.jmoore.mandatum;

import dev.jmoore.mandatum.handlers.DisconnectHandler;
import dev.jmoore.mandatum.handlers.MessageReceivedHandler;
import dev.jmoore.mandatum.handlers.ReadyHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.security.auth.login.LoginException;

public class Bot {
    private final JDA jda;

    public Bot(String token) throws LoginException {
        EventListener listener = new EventListener()
                .register(ReadyEvent.class, new ReadyHandler())
                .register(GuildMessageReceivedEvent.class, new MessageReceivedHandler())
                .register(DisconnectEvent.class, new DisconnectHandler());

        this.jda = JDABuilder
                .createLight(token)
                .setActivity(Activity.listening("aaaaaaaaaaaa"))
                .addEventListeners(listener)
                .build();
    }

    public JDA getJda() {
        return this.jda;
    }
}
