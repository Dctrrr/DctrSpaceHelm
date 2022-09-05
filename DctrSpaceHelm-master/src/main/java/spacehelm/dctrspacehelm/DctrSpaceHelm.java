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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DctrSpaceHelm extends JavaPlugin {
    
    private static DctrSpaceHelm plugin;

    FileConfiguration config = getConfig();
    int editionNumber;
    
    public static JavaPlugin getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        
        config.addDefault("editionNumber", 1);
        config.options().copyDefaults(true);
        this.saveConfig();
        editionNumber = config.getInt("editionNumber");

        getCommand("spacehelm").setExecutor(new DctrSpaceHelmCMD());
        getServer().getPluginManager().registerEvents(new DctrSpaceHelmListener(), this);

        List<Material> colors = new ArrayList<>();
        colors.add(Material.RED_STAINED_GLASS);
        colors.add(Material.BLACK_STAINED_GLASS);
        colors.add(Material.BLUE_STAINED_GLASS);
        colors.add(Material.BROWN_STAINED_GLASS);
        colors.add(Material.CYAN_STAINED_GLASS);
        colors.add(Material.GREEN_STAINED_GLASS);
        colors.add(Material.LIGHT_BLUE_STAINED_GLASS);
        colors.add(Material.LIME_STAINED_GLASS);
        colors.add(Material.LIGHT_GRAY_STAINED_GLASS);
        colors.add(Material.MAGENTA_STAINED_GLASS);
        colors.add(Material.ORANGE_STAINED_GLASS);
        colors.add(Material.YELLOW_STAINED_GLASS);
        colors.add(Material.PINK_STAINED_GLASS);
        colors.add(Material.PURPLE_STAINED_GLASS);
        colors.add(Material.GRAY_STAINED_GLASS);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {

                    ItemStack item = player.getInventory().getHelmet();

                    if(item == null) {return;}
                    if(item.getItemMeta() == null) {return;}
                    if(item.getItemMeta().getDisplayName() == null) {return;}
                    ItemMeta meta = item.getItemMeta();
                    String ItemName = item.getItemMeta().getDisplayName();
                    if (ItemName.equals(ChatColor.RED + "Dctr's Space Helmet")) {
                        Random r = new Random();
                        int color = r.nextInt(colors.size());
                        Material material = colors.get(color);
                        item.setType(material);
                        item.setItemMeta(meta);
                    }
                }
            }
        }.runTaskTimer(this, 20, 20);
    }
    
    @Override
    public void onDisable() {
        config.set("editionNumber", editionNumber);
        saveConfig();
    }
}
