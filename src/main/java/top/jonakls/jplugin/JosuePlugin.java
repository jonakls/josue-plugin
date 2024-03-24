package top.jonakls.jplugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import top.jonakls.jplugin.command.CounterCommand;
import top.jonakls.jplugin.listener.PlayerCounterListener;
import top.jonakls.jplugin.listener.PlayerMessagesListener;

@SuppressWarnings("unused")
public class JosuePlugin extends JavaPlugin {

    private final ComponentLogger logger = this.getComponentLogger();

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();

        this.logger.info(Component.text("Test", TextColor.color(0x5876FF)));

        this.registerListeners(
                new PlayerMessagesListener(this),
                new PlayerCounterListener(this)
        );

        this.registerCommands(
                new CounterCommand(this)
        );
    }

    @Override
    public void onDisable() {

    }

    private void registerListeners(Listener... listeners) {
        final PluginManager pluginManager = this.getServer().getPluginManager();

        for (final Listener listener : listeners) {
            pluginManager.registerEvents(listener, this);
        }
    }

    private void registerCommands(Command... commands) {
        final CommandMap commandMap = this.getServer().getCommandMap();

        for (final Command command : commands) {
            commandMap.register(command.getName(), command);
        }
    }
}
