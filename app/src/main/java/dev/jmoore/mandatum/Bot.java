package dev.jmoore.mandatum;

import dev.jmoore.mandatum.command.CommandManager;
import dev.jmoore.mandatum.command.Module.InfoModule;
import dev.jmoore.mandatum.command.modules.info.PingCommand;
import dev.jmoore.mandatum.handlers.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.security.auth.login.LoginException;

public class Bot {
    private final String token;
    private final Snowflake owner;
    private JDA jda;
    private CommandManager commandManager;
    private long gatewayPing = 0;

    //region Constructors/builder

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
     */
    public Bot build() throws LoginException {
        this.jda = JDABuilder
                .createLight(this.token)
                .setActivity(Activity.listening("aaaaaaaaaaaa"))
                .addEventListeners(this.buildEventListener())
                .build();

        this.commandManager = buildCommandManager();

        return this;
    }

    /**
     * @return A new EventListener
     */
    private EventListener buildEventListener() {
        return new EventListener()
                .register(new DisconnectHandler(this), DisconnectEvent.class)
                .register(new ExceptionHandler(this), ExceptionEvent.class)
                .register(new GatewayPingHandler(this), GatewayPingEvent.class)
                .register(new RawGatewayHandler(this), RawGatewayEvent.class)
                .register(new ReadyHandler(this), ReadyEvent.class)
                .register(new ReconnectedHandler(this), ReconnectedEvent.class)
                .register(new ResumedHandler(this), ResumedEvent.class)
                .register(new ShutdownHandler(this), ShutdownEvent.class)
                .register(new StatusChangeHandler(this), StatusChangeEvent.class)

                .register(new MessageReceivedHandler(this), GuildMessageReceivedEvent.class);
    }

    private CommandManager buildCommandManager() {
        return new CommandManager(this)
                .addCommand(new PingCommand("ping", new InfoModule(), this));
    }

    //endregion

    //region General functions

    /**
     * Sends a direct message to the Bot's owner
     */
    public void sendToOwner() {

    }

    //endregion

    //region Getters (for things that have no Setter)

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

    public CommandManager getCommandManager() {
        return this.commandManager;
    }

    //endregion

    //region Getters/Setters

    public long getGatewayPing() {
        return this.gatewayPing;
    }

    public void setGatewayPing(long gatewayPing) {
        this.gatewayPing = gatewayPing;
    }

    //endregion
}
