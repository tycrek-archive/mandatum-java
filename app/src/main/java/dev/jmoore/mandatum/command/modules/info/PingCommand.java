package dev.jmoore.mandatum.command.modules.info;

import dev.jmoore.mandatum.Bot;
import dev.jmoore.mandatum.command.Command;
import dev.jmoore.mandatum.command.Module;
import net.dv8tion.jda.api.entities.Message;

public class PingCommand extends Command {
    public PingCommand(String name, Module module, Bot bot) {
        super(name, module, bot);
    }

    @Override
    public void execute(Message event) {
        event.reply(String.format("Pong: `%sms`", this.getBot().getGatewayPing())).queue();
    }
}
