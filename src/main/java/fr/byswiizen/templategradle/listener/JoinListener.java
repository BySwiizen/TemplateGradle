package fr.byswiizen.templategradle.listener;

import fr.byswiizen.templategradle.TemplateGradle;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
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
			String message = TemplateGradle.messagesfile.getString("join");
			String legacy = LegacyComponentSerializer.legacySection().serialize(MiniMessage.miniMessage().deserialize(message));
			event.setJoinMessage(legacy);
		}
    }
}