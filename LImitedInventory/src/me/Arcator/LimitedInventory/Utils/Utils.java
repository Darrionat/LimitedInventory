package me.Arcator.LimitedInventory.Utils;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Utils {

	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);

	}

	public static void setFillItem(Inventory inv, Player p, JavaPlugin plugin) {
		FileConfiguration config = plugin.getConfig();
		List<String> worldList = config.getStringList("enabledWorlds");
		for (String worldName : worldList) {
			if (!p.getLocation().getWorld().getName().equals(worldName)) {
				continue;
			}
			Inventory playerInv = p.getInventory();
			ItemStack item = new ItemStack(Material.getMaterial(config.getString("FillItem.fillItemMaterial")), config.getInt("FillItem.qty"));
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(Utils.chat(config.getString("FillItem.name")));
			item.setItemMeta(meta);
			for (int slot = 9; slot <= 35; slot++) {
				if (playerInv.getItem(slot) != null) {
					if (config.getBoolean("deleteItemInSlots") == false) {
						continue;
					}
				}
				playerInv.setItem(slot, item);
			}
			break;
		}
	}

}