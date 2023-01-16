package spacehelm.dctrspacehelm.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import spacehelm.dctrspacehelm.DctrSpaceHelm;
import java.time.LocalDateTime;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DctrSpaceHelmCMD implements CommandExecutor {
    private LocalDateTime time = LocalDateTime.now ();
    public static ItemStack spacehelm;

    DctrSpaceHelm plugin;
    public static Inventory inv;

    public DctrSpaceHelmCMD (DctrSpaceHelm plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {



        if (args.length >= 1) {
            String playerName = args[0];
            Player targetPlayer = Bukkit.getPlayer (playerName);
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 1) {
                String playerName = args[0];
                player = Bukkit.getPlayer (playerName);
            }


            assert player != null;
            if (player.hasPermission ("skyblock.spacehelm")) {
                ItemStack item = new ItemStack (Material.RED_STAINED_GLASS, 1);
                ItemMeta meta = item.getItemMeta ();
                meta.setUnbreakable (true);
                meta.setDisplayName (ChatColor.RED + "Dctr's Space Helmet");
                player.getInventory().addItem(spacehelm);

                String formattedMonth = time.getMonth ().toString ().toLowerCase ();
                if (formattedMonth.length () > 0)
                    formattedMonth =
                      formattedMonth.substring (0, 1).toUpperCase () + formattedMonth.substring (1);
                ArrayList <String> lore = new ArrayList <String> ();
                lore.add (ChatColor.GRAY + "" + ChatColor.ITALIC + "A rare space helmet forged ");
                lore.add (ChatColor.GRAY + "" + ChatColor.ITALIC + "from shards of moon glass.");
                lore.add ("");
                lore.add (ChatColor.RESET + "" + ChatColor.GRAY + "To: " +
                  PlaceholderAPI.setPlaceholders (player, " %vault_rankprefix% ") +
                  player.getDisplayName ());
                lore.add (ChatColor.RESET + "" + ChatColor.GRAY + "From: " +
                  PlaceholderAPI.setPlaceholders (player, " %vault_rankprefix% ") +
                  ((Player) sender).getDisplayName ());
                lore.add ("");
                lore.add (ChatColor.DARK_GRAY + "Edition: #" + (plugin.editionNumber));
                lore.add (ChatColor.DARK_GRAY + "Year: " + formattedMonth + " " + time.getYear ());
                lore.add ("");
                lore.add (
                  ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.BOLD + "SPECIAL HELMET");

                meta.setLore (lore);
                item.setItemMeta (meta);
                spacehelm = item;
            }
            player.sendMessage (ChatColor.RED + ((Player) sender).getName () +
              " §egave you a§e §cDctr's Space Helmet§c " + ChatColor.GOLD + "#" + (plugin.editionNumber) + ChatColor.GOLD + "!");
            plugin.editionNumber += 1;
        }
        return true;
    }

    @EventHandler
    public void OnRightClick(PlayerInteractEvent e){
        List<Material> materials = Arrays.asList(Material.RED_STAINED_GLASS, Material.GREEN_STAINED_GLASS, Material.BLUE_STAINED_GLASS, Material.CYAN_STAINED_GLASS, Material.LIGHT_BLUE_STAINED_GLASS, Material.ORANGE_STAINED_GLASS);
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(p.getInventory().getItemInMainHand().equals("Dctr's Space Helmet") || p.getInventory().getItemInMainHand().equals(spacehelm)){
                p.getEquipment().setHelmet(spacehelm);
                p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);

            }
        }
    }
}