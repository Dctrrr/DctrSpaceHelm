package spacehelm.dctrspacehelm.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import spacehelm.dctrspacehelm.DctrSpaceHelm;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DctrSpaceHelmCMD implements CommandExecutor {
    private LocalDateTime time = LocalDateTime.now();

    DctrSpaceHelm plugin;
    
    public DctrSpaceHelmCMD(DctrSpaceHelm plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length >= 1) {
            String playerName = args[0];
            Player targetPlayer = Bukkit.getPlayer(playerName);
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 1) {
                String playerName = args[0];
                player = Bukkit.getPlayer(playerName);
            }

            assert player != null;
            if (player.hasPermission("skyblock.spacehelm")) {
                ItemStack itemStack = new ItemStack(Material.RED_STAINED_GLASS);

                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Dctr's Space Helmet");

                String formattedMonth = time.getMonth().toString().toLowerCase();
                if (formattedMonth.length() > 0) formattedMonth = formattedMonth.substring(0, 1).toUpperCase() + formattedMonth.substring(1);
                itemMeta.setLore(Arrays.asList(
                        ChatColor.RESET + "" + ChatColor.GRAY + ChatColor.ITALIC + "A rare space helmet forged",
                        ChatColor.RESET + "" + ChatColor.GRAY + ChatColor.ITALIC + "from shards of moon.",
                        " ",
                        ChatColor.RESET + "" + ChatColor.GRAY + "To: " + PlaceholderAPI.setPlaceholders(player,  " %uperms_rank% ") + player.getDisplayName(),
                        ChatColor.RESET + "" + ChatColor.GRAY + "From: " + PlaceholderAPI.setPlaceholders(player, " %uperms_rank% ") + ((Player)sender).getDisplayName(),
                        " ",
                        ChatColor.RESET + "" + ChatColor.DARK_GRAY + "Edition: #" + (plugin.editionNumber),
                        "",
                        ChatColor.RESET + "" + ChatColor.DARK_GRAY  + "Year: " + formattedMonth + " " + time.getYear(),
                        " ",
                        ChatColor.RED + "" + ChatColor.BOLD + "SPECIAL"
                ));

                itemStack.setItemMeta(itemMeta);
                player.getInventory().setHelmet(new ItemStack(itemStack));
                itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                player.sendMessage(ChatColor.RED + ((Player)sender).getName() + " §egave you a§e §cDctr's Space Helmet§c " + ChatColor.GOLD + "#" + (plugin.editionNumber) + ChatColor.GOLD + "!");
                plugin.editionNumber += 1;
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have access to this command!"));
            }
        }
        return true;
    }
    }




