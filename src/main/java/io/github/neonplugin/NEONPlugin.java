package io.github.neonplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class NEONPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("tnguard").setExecutor(new CommandKit()); // register guard command
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
