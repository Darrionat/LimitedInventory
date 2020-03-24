package me.Arcator.LimitedInventory.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import me.Arcator.LimitedInventory.Main;

public class Timer {
	private Main plugin;

	public Timer(Main plugin) {
		this.plugin = plugin;
	}

	public void startTimer() {
		int time = plugin.getConfig().getInt("Timer Interval");
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					Utils.setFillItem(p.getInventory(), p, plugin);
					continue;
				}
			}
		}, 0L, time * 20);
	}

}
