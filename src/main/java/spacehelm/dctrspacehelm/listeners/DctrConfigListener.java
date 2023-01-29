package spacehelm.dctrspacehelm.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DctrConfigListener extends JavaPlugin implements Listener {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        config.addDefault("editionNumber", true);
        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(this, this);
    }
}
