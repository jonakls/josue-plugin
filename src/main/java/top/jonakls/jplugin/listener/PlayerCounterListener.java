package top.jonakls.jplugin.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import top.jonakls.jplugin.JosuePlugin;

public class PlayerCounterListener implements Listener {

    private final JosuePlugin plugin;

    public PlayerCounterListener(final JosuePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        final FileConfiguration configuration = this.plugin.getConfig();
        int counter = configuration.getInt("counter-player");
        counter++;
        configuration.set("counter-player", counter);
        this.plugin.saveConfig();
    }
}
