package io.github.neonplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class NEONPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Enabling the NEON Plugin...");
        this.getCommand("tnguard").setExecutor(new GuardCommand()); // register guard command
        getLogger().info("Command '/tnguard' registered!");
        getLogger().info("Yay, the NEON Plugin is now enabled :)");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("The NEON Plugin is disabling. You really had to leave?");
    }
}
