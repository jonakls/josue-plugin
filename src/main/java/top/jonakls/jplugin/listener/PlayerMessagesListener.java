package top.jonakls.jplugin.listener;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import top.jonakls.jplugin.JosuePlugin;

import java.util.Locale;

import static top.jonakls.jplugin.util.TextUtil.parseLegacy;

public class PlayerMessagesListener implements Listener {

    private final JosuePlugin plugin;

    public PlayerMessagesListener(final JosuePlugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onJoinPlayer(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final FileConfiguration configuration = this.plugin.getConfig();

        if (!configuration.getBoolean("events.join.enabled")) {
            return;
        }

        String joinMessage = configuration.getString("events.join.message", "PATH IS NULL IN JOIN MESSAGE");
        event.setJoinMessage(parseLegacy(joinMessage.replace("%player%", player.getName())));

        if (!configuration.getBoolean("events.join.sound.enabled")) {
            return;
        }

        final String stringSound = configuration.getString("events.join.sound.sound", "ENTITY_EXPERIENCE_ORB_PICKUP");
        final Sound sound = Sound.valueOf(stringSound.toUpperCase(Locale.ROOT));

        for (final Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), sound, 1.0F, 1.0F);
        }
    }

    @EventHandler
    public void onQuitPlayer(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final FileConfiguration configuration = this.plugin.getConfig();

        if (!configuration.getBoolean("events.quit.enabled")) {
            return;
        }

        String quitMessage = configuration.getString("events.quit.message", "PATH IS NULL IN QUIT MESSAGE");
        event.setQuitMessage(parseLegacy(quitMessage.replace("%player%", player.getName())));

        if (!configuration.getBoolean("events.quit.sound.enabled")) {
            return;
        }

        final String stringSound = configuration.getString("events.quit.sound.sound", "ENTITY_EXPERIENCE_ORB_PICKUP");
        final Sound sound = Sound.valueOf(stringSound.toUpperCase(Locale.ROOT));

        for (final Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), sound, 1.0F, 1.0F);
        }
    }

}
