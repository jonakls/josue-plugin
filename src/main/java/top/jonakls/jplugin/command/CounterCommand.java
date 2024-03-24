package top.jonakls.jplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import top.jonakls.jplugin.JosuePlugin;

public class CounterCommand extends Command {

    private final JosuePlugin plugin;

    public CounterCommand(@NotNull final JosuePlugin plugin) {
        super("counter");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendPlainMessage("No eres un jugador, no puedes ejecutar esto.");
            return false;
        }

        if (strings.length > 0) {
            player.sendPlainMessage("El comando no debe tener argumentos.");
            return false;
        }

        int counter = this.plugin.getConfig().getInt("counter-player");

        player.sendPlainMessage("Las veces ingresadas al servidor son: " + counter);
        return true;
    }
}
