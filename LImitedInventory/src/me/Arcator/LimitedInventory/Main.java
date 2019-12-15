package me.Arcator.LimitedInventory;

import org.bukkit.plugin.java.JavaPlugin;

import me.Arcator.LimitedInventory.Listeners.InventoryClick;
import me.Arcator.LimitedInventory.Listeners.PlayerJoin;
import me.Arcator.LimitedInventory.Utils.Timer;

public class Main extends JavaPlugin {

	public void onEnable() {
		new PlayerJoin(this);
		new InventoryClick(this);
		Timer timer = new Timer(this);
		timer.startTimer();
		saveDefaultConfig();
	}

	public void onDisable() {

	}

}
