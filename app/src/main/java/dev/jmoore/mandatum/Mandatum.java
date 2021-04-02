package dev.jmoore.mandatum;

import dev.jmoore.mandatum.handlers.MessageReceivedHandler;
import dev.jmoore.mandatum.handlers.ReadyHandler;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.security.auth.login.LoginException;

public class Mandatum {
    public static Dotenv DOTENV;
    public static JDA jda;

    public static void main(String[] args) {
        // Load environment variables (including bot token)
        DOTENV = Dotenv.load();

        // Start the bot
        try {
            startBot();
        } catch (LoginException ex) {
            ex.printStackTrace();
        }
    }

    private static void startBot() throws LoginException {
        EventListener listener = new EventListener()
                .register(ReadyEvent.class, new ReadyHandler())
                .register(GuildMessageReceivedEvent.class, new MessageReceivedHandler());

        jda = JDABuilder
                .createDefault(DOTENV.get("TOKEN"))
                .setActivity(Activity.listening("aaaaaaaaaaaa"))
                .addEventListeners(listener)
                .build();
    }
}
