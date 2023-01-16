package spacehelm.dctrspacehelm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.configuration.file.FileConfiguration;
import spacehelm.dctrspacehelm.commands.DctrSpaceHelmCMD;
import spacehelm.dctrspacehelm.listeners.DctrSpaceHelmListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DctrSpaceHelm extends JavaPlugin {

    FileConfiguration config = getConfig();
    public int editionNumber;

    @Override
    public void onEnable() {
        config.addDefault("editionNumber", 1);
        config.options().copyDefaults(true);
        this.saveConfig();
        editionNumber = config.getInt("editionNumber");

        getCommand("spacehelm").setExecutor(new DctrSpaceHelmCMD(this));
        getServer().getPluginManager().registerEvents(new DctrSpaceHelmListener(), this);
    }
    
    @Override
    public void onDisable() {
        config.set("editionNumber", editionNumber);
        saveConfig();
    }
}
