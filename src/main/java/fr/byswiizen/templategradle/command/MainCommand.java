package fr.byswiizen.templategradle.command;

import fr.byswiizen.templategradle.TemplateGradle;
import fr.byswiizen.templategradle.command.subcommands.HelpSubCommand;
import org.bukkit.command.CommandSender;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.CommandPlaceholder;


@Command("templategradle")
public class MainCommand {

    public TemplateGradle plugin;
    public HelpSubCommand helpcommand;
    public MainCommand(TemplateGradle instance) {
        this.plugin = instance;
        this.helpcommand = new HelpSubCommand(instance);
    }


    @CommandPlaceholder
    public void help(CommandSender sender) {
        helpcommand.help(sender);
    }
}