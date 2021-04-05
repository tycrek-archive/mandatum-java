package dev.jmoore.mandatum.command;

import dev.jmoore.mandatum.Bot;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    private final Bot bot;
    private final String name;
    private final Module module;

    private List<String> aliases = new ArrayList<>();
    private boolean hidden = false;
    private boolean allowPrivate = true;
    private boolean allowGuild = true;

    public Command(String name, Module module, Bot bot) {
        this.name = name;
        this.module = module;
        this.bot = bot;
    }

    public abstract void execute(Message event);

    //region Getters with no Setters

    public Bot getBot() {
        return this.bot;
    }

    public String getName() {
        return this.name;
    }

    public Module getModule() {
        return this.module;
    }

    //endregion

    //region Getters/Setters

    public List<String> getAliases() {
        return this.aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isAllowPrivate() {
        return this.allowPrivate;
    }

    public void setAllowPrivate(boolean allowPrivate) {
        this.allowPrivate = allowPrivate;
    }

    public boolean isAllowGuild() {
        return this.allowGuild;
    }

    public void setAllowGuild(boolean allowGuild) {
        this.allowGuild = allowGuild;
    }

    //endregion
}
