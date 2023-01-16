package spacehelm.dctrspacehelm.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DctrSpaceHelmListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.RED_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.BLUE_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.BLACK_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.BROWN_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.CYAN_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.GREEN_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.LIGHT_BLUE_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.LIGHT_GRAY_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.LIME_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.MAGENTA_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.ORANGE_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.YELLOW_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.PINK_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.PURPLE_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getBlock().getType() == Material.GRAY_STAINED_GLASS)
            event.setCancelled(true);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().getType() == Material.RED_STAINED_GLASS)
            event.setCancelled(true);
        if (event.getItemDrop().getItemStack().getType() == Material.BLUE_STAINED_GLASS)
            event.setCancelled(true);

    }

}

