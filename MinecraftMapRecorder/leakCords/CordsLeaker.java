package me.lainad27.trollSmp.leakCords;

import org.bukkit.Bukkit;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;
import org.bukkit.map.MapView.Scale;

import me.lainad27.trollSmp.Main;
import me.lainad27.trollSmp.MapUpdater.MapUpdater;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.map.MapPalette;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.plugin.java.JavaPlugin;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.Level;
public class CordsLeaker implements CommandExecutor, Listener{
	int TaskId;
	
	
	private Main plugin;
	
	
	public CordsLeaker(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equals("leak") && sender.hasPermission("leak.use")) {
			World world = Bukkit.getWorlds().get(0);
			int lower = (int) (Math.random() * (20000000)) - 10000000;
			int upper = (int) (Math.random() * (20000000)) - 10000000;
			ItemStack itemStack = new ItemStack(Material.FILLED_MAP);
	        MapMeta mapMeta = (MapMeta) itemStack.getItemMeta();
	        MapView mapView = Bukkit.createMap(world); 
	        mapView.setCenterX(lower);
	        mapView.setCenterZ(upper);
	        mapView.setScale(Scale.CLOSEST);
	        mapView.setTrackingPosition(true);
	        mapMeta.setMapView(mapView);
	        itemStack.setItemMeta(mapMeta);
	        new MapUpdater(world).update(mapView); 
	        Bukkit.dispatchCommand(sender, "Maptoimage " + Integer.toString(mapView.getId()));
	        sender.sendMessage(world.getBlockAt(lower, 100, upper).getBiome().toString());
	        return true;
		}
		return false;
	}

}
