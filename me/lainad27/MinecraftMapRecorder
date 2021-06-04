package me.lainad27.trollSmp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.lainad27.trollSmp.leakCords.CordsLeaker;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		getConfig().options().copyDefaults();
        saveDefaultConfig();
		CordsLeaker MainExec2 = new CordsLeaker(this);
		this.getCommand("leak").setExecutor(MainExec2);
				Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
		    @Override
		    public void run() {
		    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "leak");
		    }
		}, 600L, 200L); //0 Tick initial delay, 20 Tick (1 Second) between repeats

			}
}
