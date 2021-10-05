package moe.caa.multilogin.core.command.executes.multilogin.subcommands;

import moe.caa.multilogin.core.command.*;
import moe.caa.multilogin.core.impl.ISender;
import moe.caa.multilogin.core.main.MultiCore;
import moe.caa.multilogin.core.util.FormatContent;

/**
 * 命令 '/multilogin reload' 处理程序
 */
public class ReloadCommand extends BaseCommandExecutor {
    public ReloadCommand(CommandHandler commandHandler, MultiCore core) {
        super(core, commandHandler, Permissions.COMMAND_MULTI_LOGIN_RELOAD);
    }

    @Override
    protected CommandResult execute(ISender sender, CommandArguments arguments) {
        if (arguments.getLength() == 0) {
            getCore().reload();
            sender.sendMessage(getCore().getLanguageHandler().getMessage("command_message_reloaded", FormatContent.empty()));
            return CommandResult.PASS;
        }
        return CommandResult.UNKNOWN_USAGE;
    }
}
