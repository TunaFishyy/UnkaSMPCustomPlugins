package io.github.tunafishyy;

import io.github.tunafishyy.Commands.SMP;
import io.github.tunafishyy.Listeners.Drops;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class UnkaSMP extends JavaPlugin {

    @Override
    public void onEnable() {
        registerUnka(this.getServer(), this.getServer().getConsoleSender());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerUnka(Server server, ConsoleCommandSender console) {
        server = this.getServer();
        console = server.getConsoleSender();

        try {
            registerBothEventsAndCommands();
            console.sendMessage(ChatColor.GREEN + "UnkaSMP Plugin uspjesno ucitan!");
        } catch (NullPointerException | NumberFormatException e) {
            console.sendMessage(ChatColor.RED + "UnkaSMP Plugin se nije uspjesno ucitao! Proslijedi, \n" + e);
        }
    }

    private void registerBothEventsAndCommands() {
        getServer().getPluginManager().registerEvents(new Drops(), this);
        getCommand("unkasmp").setExecutor(new SMP());
    }

}