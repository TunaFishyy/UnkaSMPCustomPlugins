package io.github.tunafishyy.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SMP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender cmd) {
            consoleRun(cmd);
            return true;
        } else if (sender instanceof Player p) {
            p.sendMessage("KOMANDA U IZRADNJI");
            return true;
        }

        return false;
    }

    private void consoleRun(ConsoleCommandSender console) {
        console.sendMessage(ChatColor.GOLD + "UnkaSMP Meni:\n   -Trenutno nema komandi.\n   -Postoji" +
                " mogucnost da prilikom unistavanja grass/dirt bloka se baci jedan dobar loot :).");
    }
}
