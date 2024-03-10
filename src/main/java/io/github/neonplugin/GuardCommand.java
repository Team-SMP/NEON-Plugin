package io.github.neonplugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.List;

public class GuardCommand implements CommandExecutor {
    private final File playerDataFile;
    private final FileConfiguration playerDataConfig;
    public GuardCommand() {
        playerDataFile = new File("plugins/NEON-Plugin/playerdata.yml");
        playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 1 && args[0].equals("warp")) {
                player.teleport(new Location(Bukkit.getWorld("world"), 9825, 73, 9951));
                final Component component = MiniMessage.miniMessage().deserialize("You have been warped to <b><gradient:#7a33ff:#0128ab>TECH NEXUS</gradient></b>!");
                player.sendMessage(component);
                return true;
            }
            if (args.length > 1 && args[0].equals("shift")) {
                if (args[1].equals("start")){
                    startShift(player);
                    return true;
                } else if (args[1].equals("end")) {
                    endShift(player);
                    return true;
                }
            }
        }
        return false;
    }
    private void startShift(Player player) {
        UUID playerId = player.getUniqueId();
        List<String> playerData = playerDataConfig.getStringList(playerId.toString());

        // Check if "onShift: false" exists and change it to true
        if (playerData.contains("onShift: false")) {
            playerData.remove("onShift: false");
            playerData.add("onShift: true");
            // Update other attributes as needed
            playerDataConfig.set(playerId.toString(), playerData);
            savePlayerData();
            final Component component = MiniMessage.miniMessage().deserialize("Your shift has been <green>started</green>.");
            player.sendMessage(component);
        } else {
            final Component component = MiniMessage.miniMessage().deserialize("<red>You are already on shift!");
            player.sendMessage(component);
        }
    }
    private void endShift(Player player) {
        UUID playerId = player.getUniqueId();
        List<String> playerData = playerDataConfig.getStringList(playerId.toString());

        // Check if "onShift: true" exists and change it to false
        if (playerData.contains("onShift: true")) {
            playerData.remove("onShift: true");
            playerData.add("onShift: false");
            // Update other attributes as needed
            playerDataConfig.set(playerId.toString(), playerData);
            savePlayerData();
            final Component component = MiniMessage.miniMessage().deserialize("Your shift has been <orange>ended</orange>.");
            player.sendMessage(component);
        } else {
            final Component component = MiniMessage.miniMessage().deserialize("<red>Your shift was never started!");
            player.sendMessage(component);
        }
    }

    private void savePlayerData() {
        try {
            playerDataConfig.save(playerDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
