package fr.byswiizen.templategradle.command.subcommands;

import fr.byswiizen.templategradle.TemplateGradle;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;
import revxrsal.commands.bukkit.BukkitCommandActor;
import net.kyori.adventure.text.minimessage.MiniMessage;


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
            sender.reply(MiniMessage.miniMessage().deserialize(TemplateGradle.messagesfile.getString("command.prefix") + " " + TemplateGradle.messagesfile.getString("command.reload-success")));
        } catch (Exception error) {
            sender.reply(MiniMessage.miniMessage().deserialize("<red>Error loading files."));
            error.printStackTrace();
        }
    }
}