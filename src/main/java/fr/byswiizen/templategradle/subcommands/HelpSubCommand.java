package fr.byswiizen.templategradle.subcommands;

import fr.byswiizen.templategradle.TemplateGradle;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.DefaultFor;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.BukkitCommandActor;
import net.kyori.adventure.text.minimessage.MiniMessage;


@Command("templategradle")
public class HelpSubCommand {

	public TemplateGradle plugin;
    public HelpSubCommand(TemplateGradle instance) {
        this.plugin = instance;
    }


    @Subcommand("help")
    public void help(BukkitCommandActor sender) {
		for (String line : TemplateGradle.messagesfile.getStringList("command.help")) {
            sender.reply(MiniMessage.miniMessage().deserialize(TemplateGradle.messagesfile.getString("command.prefix") + " " + line));
        }
	}

    @DefaultFor("templategradle")
    public void defaultHelp(BukkitCommandActor sender) {
        help(sender);
    }
}