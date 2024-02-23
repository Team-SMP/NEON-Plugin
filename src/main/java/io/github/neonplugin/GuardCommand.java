package io.github.neonplugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuardCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 1 && args[0].equals("warp")) {
                player.teleport(new Location(Bukkit.getWorld("world"), 9825, 73, 9951));
                final Component component = MiniMessage.miniMessage().deserialize("You have been warped to <b><gradient:#7a33ff:#0128ab>TECH NEXUS</gradient></b>!");
                player.sendMessage(component);
                return true;
            }
            if (args.length > 0 && args[0].equals("lockdown")) {
                if (args[1].equals("toggle")) {
                    final Component component = MiniMessage.miniMessage().deserialize("Lockdown at <b><gradient:#7a33ff:#0128ab>TECH NEXUS</gradient></b> has been <b><red>toggled</red></b>!");
                    player.sendMessage(component);
                    return true;
                }
                if (args[1].equals("silence")) {
                    final Component component = MiniMessage.miniMessage().deserialize("Lockdown at <b><gradient:#7a33ff:#0128ab>TECH NEXUS</gradient> <yellow>silenced</yellow></b>!");
                    player.sendMessage(component);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
