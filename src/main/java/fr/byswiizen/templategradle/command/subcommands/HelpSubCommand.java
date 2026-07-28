package fr.byswiizen.templategradle.command.subcommands;

import fr.byswiizen.templategradle.TemplateGradle;
import fr.byswiizen.templategradle.util.ColorUtil;
import org.bukkit.command.CommandSender;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;


@Command("templategradle")
public class HelpSubCommand {

	public TemplateGradle plugin;
    public HelpSubCommand(TemplateGradle instance) {
        this.plugin = instance;
    }


    @Subcommand("help")
    public void help(CommandSender sender) {
		for (String line : TemplateGradle.messagesfile.getStringList("command.help")) {
            sender.sendMessage(ColorUtil.translate(TemplateGradle.messagesfile.getString("command.prefix") + " " + line));
        }
	}
}