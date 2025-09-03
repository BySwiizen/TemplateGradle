package fr.byswiizen.templategradle.command;

import fr.byswiizen.templategradle.TemplateGradle;
import fr.byswiizen.templategradle.command.subcommands.HelpSubCommand;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.DefaultFor;
import revxrsal.commands.bukkit.BukkitCommandActor;


@Command("templategradle")
public class MainCommand {

    public TemplateGradle plugin;
    public HelpSubCommand helpcommand;
    public MainCommand(TemplateGradle instance) {
        this.plugin = instance;
        this.helpcommand = new HelpSubCommand(instance);
    }


    @DefaultFor("templategradle")
    public void help(BukkitCommandActor sender) {
        helpcommand.help(sender);
    }
}