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

import java.util.Arrays;

public class ItemsGUI implements Listener {
  private final Inventory inv;

  public ItemsGUI() {
    inv = Bukkit.createInventory(null, 9, "Admin Items Catalogue");
    initializeItems();
  }

  public void initializeItems() {
    inv.addItem(createGuiItem(Material.RED_STAINED_GLASS, "§cDctr's Space Helmet§c", "§7§oA rare space helmet forged§7§o", "§7§ofrom shards of moon.§7§o"));
  }
  protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
    final ItemStack item = new ItemStack(material, 1);
    final ItemMeta meta = item.getItemMeta();

    meta.setDisplayName(name);
    meta.setLore(Arrays.asList(lore));
    item.setItemMeta(meta);
    return item;
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