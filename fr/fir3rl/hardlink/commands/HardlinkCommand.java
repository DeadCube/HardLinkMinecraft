package fr.fir3rl.hardlink.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

import fr.fir3rl.hardlink.Hardlink;
import fr.fir3rl.hardlink.events.HardLinkRequestEvent;

public class HardlinkCommand implements CommandExecutor {

	private Hardlink link;
	public HardlinkCommand(Hardlink hardlink) {
		this.link = hardlink;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

		if (sender.hasPermission(new Permission("hardlink.admin")) && cmd.getName().equalsIgnoreCase("hardlink")) {
			
			if(args.length < 3) {
				sender.sendMessage("§4Format : /hardlink secretkey key value");
				return false;
			}
			if(args[0].equals(link.getConfig().getString("SecretKey"))) {
				
				String key = args[1];
				String val = "";
				args[0] = "";
				args[1] = "";
				for(int x = 2;x != args.length;x++) {
					val+=args[x]+" ";
				}
				link.getServer().getPluginManager().callEvent(new HardLinkRequestEvent(key, val));
				
			} else {
				sender.sendMessage("§4Erreur de clé secrète...");
			}
			
		} else {
			sender.sendMessage("§4Vous n'avez pas les droits requis ...");
		}
		return false;
	}

}
