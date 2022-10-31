package spacehelm.dctrspacehelm.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import spacehelm.dctrspacehelm.DctrSpaceHelm;

import java.util.ArrayList;
import java.util.Arrays;

public class DctrSpaceHelmCMD implements CommandExecutor {
    
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
            if (player.hasPermission("adminitem.spacehelm")) {
                ItemStack itemStack = new ItemStack(Material.RED_STAINED_GLASS);

                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Dctr's Space Helmet");

                itemMeta.setLore(Arrays.asList(
                        ChatColor.GRAY + "" + ChatColor.ITALIC + "A rare space helmet forged",
                        ChatColor.GRAY + "" + ChatColor.ITALIC + "from shards of moon.",
                        " ",
                        ChatColor.DARK_GRAY + "To: " + ChatColor.GRAY + PlaceholderAPI.setPlaceholders(player, " [ %vault_rank% ] ") + player.getDisplayName(),
                        ChatColor.DARK_GRAY + "From: " + ChatColor.RED + PlaceholderAPI.setPlaceholders(player," [ %vault_rank% ] ") + ((Player)sender).getDisplayName(),
                        " ",
                        ChatColor.DARK_GRAY + "Edition: #" + (plugin.editionNumber),
                        ChatColor.DARK_GRAY + "Year: Coming Soon",
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
