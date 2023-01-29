package spacehelm.dctrspacehelm.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import spacehelm.dctrspacehelm.listeners.ItemsGUI;


public class ItemsGUICMD implements CommandExecutor {
  @Override
  public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
           ItemsGUI gc = new ItemsGUI();
           player.openInventory(ItemsGUI.inv);
   return true;
  }
}
