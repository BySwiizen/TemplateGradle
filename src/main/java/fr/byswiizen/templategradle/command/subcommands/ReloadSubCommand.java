package fr.byswiizen.templategradle.command.subcommands;

import fr.byswiizen.templategradle.TemplateGradle;
import fr.byswiizen.templategradle.util.ColorUtil;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;
import revxrsal.commands.bukkit.BukkitCommandActor;


@Command("templategradle")
public class ReloadSubCommand {

	public TemplateGradle plugin;
    public ReloadSubCommand(TemplateGradle instance) {
        this.plugin = instance;
    }


    @Subcommand("reload")
    @CommandPermission("templategradle.reload")
    public void reload(BukkitCommandActor sender) {
        try {
            TemplateGradle.configfile.reload();
            TemplateGradle.messagesfile.reload();
            sender.reply(ColorUtil.translate(TemplateGradle.messagesfile.getString("command.prefix") + " " + ColorUtil.translate(TemplateGradle.messagesfile.getString("command.reload-success"))));
        } catch (Exception error) {
            sender.reply(ColorUtil.translate("&4Error loading files."));
            error.printStackTrace();
        }
    }
}