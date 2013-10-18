package com.mcprohosting.plugins.mindcrack.kotl;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Participant {

	private String name;
	private int totalScore;
	private int updateScore;
	private int timeStreak;
	private int next;

	public Participant(Player player) {
		name = player.getName();
		totalScore = 0;
		updateScore = 0;
		timeStreak = 0;
		next = 1;
	}

	public void calculateStreakPoints() {
		if (timeStreak == next) {
			KotL.getPlugin().getLogger().info("Give player 15 points!");
			KotL.getLeaderboard().addPoint(Bukkit.getPlayer(name), 15);
			next = next + 1;
		}
	}

	public void setTotalScore(int score) {
		totalScore = score;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setUpdateScore(int score) {
		updateScore = score;
	}

	public int getUpdateScore() {
		return updateScore;
	}

	public void updateTimeStreak() {
		if (totalScore > 0) {
			timeStreak = totalScore / 60;
		}
	}
}
