package fr.gamalta.redblock.staffsecurity;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.gamalta.lib.config.Configuration;
import fr.gamalta.redblock.staffsecurity.listeners.onPlayerJoinEvent;
import fr.gamalta.redblock.staffsecurity.utils.User;

public class StaffSecurity extends JavaPlugin implements Listener {

	public Configuration settingsCFG = new Configuration(this, "Staff Security", "Settings");
	public Configuration dataCFG = new Configuration(this, "Data", "StaffSecurity");
	public List<User> players = new ArrayList<>();

	@Override
	public void onEnable() {

		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new onPlayerJoinEvent(this), this);

	}

	@Override
	public void onDisable() {

	}
}
