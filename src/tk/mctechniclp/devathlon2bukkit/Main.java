package tk.mctechniclp.devathlon2bukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BukkitChannelListener());
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}
	
	
	@Override
	public void onDisable() {
		
	}
}
