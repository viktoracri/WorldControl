package dev.acri.worldcontrol.utils;

import org.bukkit.World;

public class OptionsStorage {
	
	private World world;
	
	private boolean pvpEnabled = true;
	private boolean buildEnabled = true;
	private boolean craftingEnabled = true;
	private boolean regenEnabled = true;
	private boolean freezeEnabled = false;
	private boolean chatEnabled = true;
	private boolean invincibilityEnabled = false;
	private boolean extremeDifficultyEnabled = false;
	private int borderSize = 100;
	
	public OptionsStorage(World world) {
		this.world = world;
	}
	
	public boolean isPvpEnabled() {
		return pvpEnabled;
	}
	
	public void setPvpEnabled(boolean pvpEnabled) {
		this.pvpEnabled = pvpEnabled;
	}

	public boolean isBuildEnabled() {
		return buildEnabled;
	}

	public void setBuildEnabled(boolean buildEnabled) {
		this.buildEnabled = buildEnabled;
	}

	public boolean isCraftingEnabled() {
		return craftingEnabled;
	}

	public void setCraftingEnabled(boolean craftingEnabled) {
		this.craftingEnabled = craftingEnabled;
	}

	public boolean isRegenEnabled() {
		return regenEnabled;
	}

	public void setRegenEnabled(boolean regenEnabled) {
		this.regenEnabled = regenEnabled;
	}

	public boolean isFreezeEnabled() {
		return freezeEnabled;
	}

	public void setFreezeEnabled(boolean freezeEnabled) {
		this.freezeEnabled = freezeEnabled;
	}

	public boolean isChatEnabled() {
		return chatEnabled;
	}

	public void setChatEnabled(boolean chatEnabled) {
		this.chatEnabled = chatEnabled;
	}

	public int getBorderSize() {
		return borderSize;
	}

	public void setBorderSize(int borderSize) {
		this.borderSize = borderSize;
	}

	public World getWorld() {
		return world;
	}

	public boolean isExtremeDifficultyEnabled() {
		return extremeDifficultyEnabled;
	}

	public void setExtremeDifficultyEnabled(boolean extremeDifficultyEnabled) {
		this.extremeDifficultyEnabled = extremeDifficultyEnabled;
	}

	public boolean isInvincibilityEnabled() {
		return invincibilityEnabled;
	}

	public void setInvincibilityEnabled(boolean invincibilityEnabled) {
		this.invincibilityEnabled = invincibilityEnabled;
	}

	

}
