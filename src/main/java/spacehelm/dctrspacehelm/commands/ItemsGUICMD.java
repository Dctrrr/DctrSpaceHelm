package spacehelm.dctrspacehelm.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import spacehelm.dctrspacehelm.listeners.ItemsGUI;


public class ItemsGUICMD implements CommandExecutor {
  @Override
  public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
    sender.sendMessage ("Unable to load gui...");
   return true;
  }
}