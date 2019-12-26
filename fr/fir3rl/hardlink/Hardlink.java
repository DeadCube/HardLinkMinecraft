package fr.fir3rl.hardlink;

import org.bukkit.plugin.java.JavaPlugin;

import fr.fir3rl.hardlink.commands.HardlinkCommand;

public class Hardlink extends JavaPlugin {

	@Override
	public void onEnable() {
		saveDefaultConfig();
		getCommand("hardlink").setExecutor(new HardlinkCommand(this));
	}

}
