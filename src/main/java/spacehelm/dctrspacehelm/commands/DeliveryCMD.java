package spacehelm.dctrspacehelm.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import spacehelm.dctrspacehelm.DctrSpaceHelm;

import java.time.LocalDateTime;
import java.util.Arrays;

public class DeliveryCMD implements CommandExecutor {
  DctrSpaceHelm plugin;
  public DeliveryCMD (DctrSpaceHelm plugin) {
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
      if (player.hasPermission ("skyblock.deliveryhelm")) {
        player.sendMessage(ChatColor.RED + "Unable to execute command!");
      }
    }
    return true;
  }
}






