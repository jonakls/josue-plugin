package top.jonakls.jplugin.util;

import org.bukkit.ChatColor;

public final class TextUtil {

    private TextUtil() {
        throw new UnsupportedOperationException("No puede instanciar esta clase");
    }

    public static String parseLegacy(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }


}
