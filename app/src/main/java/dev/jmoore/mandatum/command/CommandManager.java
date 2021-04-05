package dev.jmoore.mandatum.command;

import dev.jmoore.mandatum.Bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandManager {
    private final Bot bot;
    private Map<String, Command> commands;
    private Map<String, String> aliases;

    public CommandManager(Bot bot) {
        this.bot = bot;
    }

    //region Setup stuff (add commands)

    public CommandManager addCommand(Command command) {
        this.commands.putIfAbsent(command.getName(), command);
        command.getAliases().forEach((alias) -> aliases.put(alias, command.getName()));
        return this;
    }

    public CommandManager addCommands(Command... commands) {
        Arrays.asList(commands).forEach(this::addCommand);
        return this;
    }

    //endregion

    //region Getters with no Setters

    public Command getCommand(String name) {
        return commands.getOrDefault(aliases.getOrDefault(name, name), null);
    }

    public List<Command> getCommandsByModule(Module module) {
        return commands.values().stream().filter((command) -> command.getModule() == module).collect(Collectors.toList());
    }

    public List<Command> getCommands() {
        return this.getCommands(false);
    }

    public List<Command> getCommands(boolean includeHidden) {
        return new ArrayList<>(includeHidden
                ? this.commands.values()
                : this.commands.values().stream().filter((command) -> !command.isHidden()).collect(Collectors.toList()));
    }

    //endregion
}
