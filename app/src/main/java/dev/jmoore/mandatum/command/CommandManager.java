package dev.jmoore.mandatum.command;

import dev.jmoore.mandatum.Bot;

import java.util.*;
import java.util.stream.Collectors;

public class CommandManager {
    private final Bot bot;
    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final Map<String, String> aliases = new LinkedHashMap<>();

    /**
     * Creates a new {@link CommandManager}
     * @param bot The {@link Bot} using this {@link CommandManager}
     */
    public CommandManager(Bot bot) {
        this.bot = bot;
    }

    //region Setup stuff (add commands)

    /**
     * Adds a {@link Command}
     * @param command The {@link Command} to add
     * @return This {@link CommandManager} for chaining
     */
    public CommandManager addCommand(Command command) {
        this.commands.putIfAbsent(command.getName(), command);
        command.getAliases().forEach((alias) -> aliases.put(alias, command.getName()));
        return this;
    }

    /**
     * Adds multiple {@link Command}'s
     * @param commands The {@link Command}'s to add
     * @return This {@link CommandManager} for chaining
     */
    public CommandManager addCommands(Command... commands) {
        Arrays.asList(commands).forEach(this::addCommand);
        return this;
    }

    //endregion

    //region Getters with no Setters

    /**
     * Get the {@link Command} for the provided name
     * @param name A String that may resolve to a {@link Command} either directly or by alias
     * @return The {@link Command} (will return null if it does not exist)
     */
    public Command getCommand(String name) {
        return commands.getOrDefault(aliases.getOrDefault(name, name), null);
    }

    /**
     * Gets all {@link Command}s for a specific {@link Module} (including Hidden commands)
     * @param module The {@link Module} to get {@link Command}s for
     * @return A list of {@link Command}s in the specified {@link Module}
     */
    public List<Command> getCommandsByModule(Module module) {
        return commands.values().stream().filter((command) -> command.getModule() == module).collect(Collectors.toList());
    }

    /**
     * Gets all {@link Command}s <strong>excluding</strong> those that are Hidden
     * @return A list of all {@link Command}s <strong>excluding</strong> those that are Hidden
     */
    public List<Command> getCommands() {
        return this.getCommands(false);
    }

    /**
     * Gets all {@link Command}s
     * @param includeHidden Whether or not to include Hidden {@link Command}s in the list
     * @return A list of all {@link Command}s (may or may not include those that are Hidden)
     */
    public List<Command> getCommands(boolean includeHidden) {
        return new ArrayList<>(includeHidden
                ? this.commands.values()
                : this.commands.values().stream().filter((command) -> !command.isHidden()).collect(Collectors.toList()));
    }

    //endregion
}
