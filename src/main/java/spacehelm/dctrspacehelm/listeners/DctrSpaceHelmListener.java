package spacehelm.dctrspacehelm.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import spacehelm.dctrspacehelm.commands.DctrSpaceHelmCMD;


public class DctrSpaceHelmListener implements Listener {
  public int i;

  @EventHandler
  public void OnRightClick(PlayerInteractEvent e){
    Player p = e.getPlayer();

    if(e.getAction().equals(Action.RIGHT_CLICK_AIR)){
      if(p.getInventory().getItemInMainHand().equals("Dctr's Space Helmet") || p.getInventory().getItemInMainHand().equals(
        DctrSpaceHelmCMD.spacehelm)){
        p.getEquipment().setHelmet(DctrSpaceHelmCMD.spacehelm);
        p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);

      }
    }
  }

  @EventHandler
  public void onSpaceHelmClick(InventoryClickEvent e1){

    if(e1.getRawSlot() == 5 && e1.getCurrentItem().getType() == (Material.RED_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.BLACK_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.BLUE_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.CYAN_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.GREEN_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.LIGHT_BLUE_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.LIME_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.LIGHT_GRAY_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.MAGENTA_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.ORANGE_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.YELLOW_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.PINK_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.PURPLE_STAINED_GLASS) || e1.getCurrentItem().getType() == (Material.GRAY_STAINED_GLASS)){
      e1.setCurrentItem(DctrSpaceHelmCMD.spacehelm);
      Bukkit.getServer().getScheduler().cancelTask(i);
    }
  }
  }


