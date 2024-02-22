package io.github.neonplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GuardCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender
            return true;
            if (args.length == 1 && args[0].equals("warp")) {
                player.teleport(new Location(Bukkit.getWorld("world"), 9825, 73, 9951));
                final Component component = MiniMessage.miniMessage().deserialize(
                        "You have been warped to <b><gradient:#7a33ff:#0128ab>TECH NEXUS</gradient></b>!"
                );
            }
        }
        return false;
    }
}
