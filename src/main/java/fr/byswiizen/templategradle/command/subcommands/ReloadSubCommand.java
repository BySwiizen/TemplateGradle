package fr.byswiizen.templategradle.command.subcommands;

import fr.byswiizen.templategradle.TemplateGradle;
import fr.byswiizen.templategradle.util.ColorUtil;
import org.bukkit.command.CommandSender;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;


@Command("templategradle")
public class ReloadSubCommand {

	public TemplateGradle plugin;
    public ReloadSubCommand(TemplateGradle instance) {
        this.plugin = instance;
    }


    @Subcommand("reload")
    @CommandPermission("templategradle.reload")
    public void reload(CommandSender sender) {
        try {
            TemplateGradle.configfile.reload();
            TemplateGradle.messagesfile.reload();
            sender.sendMessage(ColorUtil.translate(TemplateGradle.messagesfile.getString("command.prefix") + " " + ColorUtil.translate(TemplateGradle.messagesfile.getString("command.reload-success"))));
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}