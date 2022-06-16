package io.github.tunafishyy.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Drops implements Listener {

    private final List<String> lore = new ArrayList<>();
    private final Random random = new Random();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        double r = random.nextDouble();
        Block block = e.getBlock();
        Player p = e.getPlayer();
        Location loc = block.getLocation();

        if (block.equals(Material.GRASS_BLOCK) || block.equals(Material.DIRT)) {
            //0.5%
            if (r <= 0.005) {
                Bukkit.broadcastMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "!" + ChatColor.GOLD + "]" + " "
                    + p.getDisplayName() + "" + ChatColor.BOLD + "" + ChatColor.GREEN + " je veliki supak s puno srece u zivotu i potom je dobio rijetki loot " + ChatColor.BLUE + "Malcolmov pisolinko" + ChatColor.GREEN + ".");

                loc.getWorld().dropItemNaturally(loc.add(0, 1, 0), sword());
            }
        }
        
        else if (block.equals(Material.SAND)) {
            //5%
            if (r <= 0.05) {
                Bukkit.broadcastMessage((ChatColor.GOLD + "[" + ChatColor.DARK_RED + "!" + ChatColor.GOLD + "]" + " "
                        + p.getDisplayName() + "" + ChatColor.BOLD + "" + ChatColor.GREEN + "Neimase srece..."));

                loc.getWorld().playSound(loc, Sound.BLOCK_ANVIL_FALL, SoundCategory.BLOCKS, 7, 7);
                loc.getWorld().spawnEntity(loc.add(0, 5, 0), EntityType.GHAST);
            }
        }
    }

    protected ItemStack sword() {
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
        item.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        item.addEnchantment(Enchantment.DURABILITY, Enchantment.DURABILITY.getMaxLevel());
        item.setItemMeta(meta());

        return item;
    }

    protected ItemMeta meta() {
        ItemMeta meta = sword().getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Malcolmov pisolinko.");
        lore.add("");
        lore.add("" + "" + ChatColor.ITALIC + "" + ChatColor.LIGHT_PURPLE + "" + "Keza nije krindz!");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        return meta;
    }
}
