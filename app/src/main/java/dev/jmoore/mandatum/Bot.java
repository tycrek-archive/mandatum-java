package dev.jmoore.mandatum;

import dev.jmoore.mandatum.handlers.DisconnectHandler;
import dev.jmoore.mandatum.handlers.ExceptionHandler;
import dev.jmoore.mandatum.handlers.MessageReceivedHandler;
import dev.jmoore.mandatum.handlers.ReadyHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.events.ExceptionEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.security.auth.login.LoginException;

public class Bot {
    private final String token;
    private final Snowflake owner;
    private JDA jda;

    /**
     * Creates a new {@link Bot}
     *
     * @param token   The Bot OAuth token used to authenticate with the Discord API
     * @param ownerId The Bot owner's Discord ID (automatically converted to {@link Snowflake})
     */
    public Bot(String token, String ownerId) {
        this.token = token;
        this.owner = new Snowflake(ownerId);
    }

    /**
     * Creates a new {@link Bot}
     *
     * @param token The Bot OAuth token used to authenticate with the Discord API
     * @param owner The Bot owner's Discord ID (as a {@link Snowflake})
     */
    public Bot(String token, Snowflake owner) {
        this.token = token;
        this.owner = owner;
    }

    /**
     * Builds the {@link EventListener} & {@link JDA}. This method will block.
     *
     * @return The {@link Bot} for chaining
     * @throws LoginException Thrown if authentication with the Discord API fails
     * @throws InterruptedException Thrown if <code>.build().awaitRead()</code> fails to block the thread
     */
    public Bot build() throws LoginException, InterruptedException {
        this.jda = JDABuilder
                .createLight(this.token)
                .setActivity(Activity.listening("aaaaaaaaaaaa"))
                .addEventListeners(this.buildEventListener())
                .build().awaitReady();

        return this;
    }

    /**
     * @return This Bot's {@link JDA}
     */
    public JDA getJda() {
        return this.jda;
    }

    /**
     * @return The bot owner's {@link Snowflake}
     */
    public Snowflake getOwner() {
        return this.owner;
    }

    /**
     * Sends a direct message to the Bot's owner
     */
    public void sendToOwner() {

    }

    /**
     * @return A new EventListener
     */
    private EventListener buildEventListener() {
        return new EventListener()
                .register(ReadyEvent.class, new ReadyHandler())
                .register(GuildMessageReceivedEvent.class, new MessageReceivedHandler())
                .register(DisconnectEvent.class, new DisconnectHandler())
                .register(ExceptionEvent.class, new ExceptionHandler());
    }
}
