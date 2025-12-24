package fr.byswiizen.templategradle.listener;

import fr.byswiizen.templategradle.TemplateGradle;
import fr.byswiizen.templategradle.util.ColorUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {

    public TemplateGradle plugin;
    public JoinListener(TemplateGradle instance) {
        this.plugin = instance;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
		if (TemplateGradle.configfile.getBoolean("join.enabled")) {
			event.setJoinMessage(ColorUtil.translate(TemplateGradle.messagesfile.getString("join")));
		}
    }
}