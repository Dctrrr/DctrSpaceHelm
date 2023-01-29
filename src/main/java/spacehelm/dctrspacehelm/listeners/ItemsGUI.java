package spacehelm.dctrspacehelm.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import spacehelm.dctrspacehelm.commands.DctrSpaceHelmCMD;

import java.util.Arrays;

public class ItemsGUI implements Listener {
  private final Inventory inv;

  public ItemsGUI() {
    inv = Bukkit.createInventory(null, 9, "Admin Items Catalogue");
    initializeItems();
  }

  public void initializeItems() {
    inv.addItem(DctrSpaceHelmCMD.spacehelm);
  }
  protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
    final ItemStack itemStack = new ItemStack(material, 1);
    final ItemMeta meta = itemStack.getItemMeta();

    meta.setDisplayName(name);
    meta.setLore(Arrays.asList(lore));
    itemStack.setItemMeta(meta);
    return itemStack;
  }

  public void openInventory(final HumanEntity ent) {
    ent.openInventory(inv);
  }

  @EventHandler
  public void onInventoryClick(final InventoryClickEvent e) {
    if (!e.getInventory().equals(inv)) return;

    e.setCancelled(true);

    final ItemStack clickedItem = e.getCurrentItem();

    if (clickedItem == null || clickedItem.getType().isAir()) return;

    final Player p = (Player) e.getWhoClicked();
  }

  @EventHandler
  public void onInventoryClick(final InventoryDragEvent e) {
    if (e.getInventory().equals(inv)) {
      e.setCancelled(true);
    }
  }
}