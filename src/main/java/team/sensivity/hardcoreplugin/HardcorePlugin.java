package team.sensivity.hardcoreplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import team.sensivity.hardcoreplugin.listeners.JoinListener;
import team.sensivity.hardcoreplugin.listeners.PlayerDeath;

public final class HardcorePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        listenerReg();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void listenerReg(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new PlayerDeath(), this);
    }
}
