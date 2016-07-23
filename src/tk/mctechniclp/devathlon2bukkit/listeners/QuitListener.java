package tk.mctechniclp.devathlon2bukkit.listeners;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import tk.mctechniclp.devathlon2bukkit.Main;

public class QuitListener implements Listener  {
	
	
	@EventHandler
	public void onKick(PlayerQuitEvent ev) {
		if(Bukkit.getOnlinePlayers().size() <= 1) {
			ByteArrayOutputStream b = new ByteArrayOutputStream();
	        DataOutputStream out = new DataOutputStream(b);
	        try {
	            out.writeUTF("shutdown");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        ev.getPlayer().sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());
			Bukkit.shutdown();
		}
		
	}
	
}
