package fr.gamalta.redblock.staffsecurity.listeners;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.gamalta.redblock.staffsecurity.StaffSecurity;
import fr.gamalta.redblock.staffsecurity.utils.User;
import fr.gamalta.redblock.staffsecurity.utils.Utils;

public class onPlayerJoinEvent implements Listener {

	StaffSecurity main;
	Utils utils;

	public onPlayerJoinEvent(StaffSecurity main) {
		this.main = main;
		utils = new Utils(main);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {

		Player player = event.getPlayer();

		if (player.hasPermission(main.settingsCFG.getString("Staff.Permission"))) {

			String uuid = player.getUniqueId().toString();
			String token = UUID.randomUUID().toString().substring(0, 5);
			User user = new User(player, System.currentTimeMillis(), main.dataCFG.getString("Staff." + uuid + ".Email"), token);

			if (main.dataCFG.contains("Staff." + uuid + ".Ip")) {

				String ip = main.dataCFG.getString("Staff." + uuid + ".Ip");
				String playerIp = player.getAddress().getAddress().toString();

				if (!ip.equals(playerIp)) {

					utils.sendEmail(user);
					utils.kickTask();
				}
			} else {

				// demander email
			}
		}
	}
}