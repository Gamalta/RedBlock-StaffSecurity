package fr.gamalta.redblock.staffsecurity.utils;

import org.bukkit.entity.Player;

public class User {

	Player player;
	long joinedTime = 0L;
	String email = "";
	String token = "";

	public User(Player player, long joinedTime, String email, String token) {

		this.player = player;
		this.joinedTime = joinedTime;
		this.token = token;
		this.email = email;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public long getJoinedTime() {
		return joinedTime;
	}

	public void setJoinedTime(long joinedTime) {
		this.joinedTime = joinedTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}