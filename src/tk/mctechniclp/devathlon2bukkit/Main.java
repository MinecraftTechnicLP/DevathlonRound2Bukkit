package tk.mctechniclp.devathlon2bukkit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import tk.mctechniclp.devathlon2bukkit.listeners.JoinLeaveListener;

public class Main extends JavaPlugin {
	
	private static String bungeeName;
	private static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BukkitChannelListener());
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		Bukkit.getPluginManager().registerEvents(new JoinLeaveListener(), this);
	}
	
	
	public static void sendNameRequest() {
		if(bungeeName != null) return;
		
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("GetServer");
		
		Player p = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
		p.sendPluginMessage(instance, "BungeeCord", out.toByteArray());
	}


	@Override
	public void onDisable() {
		
	}
	
	public static String getBungeeName() {
		return bungeeName;
	}
	
	public static void setBungeeName(String name) {
		bungeeName = name;
	}
	
	public static Main getInstance() {
		return instance;
	}
}
