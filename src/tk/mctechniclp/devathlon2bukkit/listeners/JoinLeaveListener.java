package tk.mctechniclp.devathlon2bukkit.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import tk.mctechniclp.devathlon2bukkit.Main;

public class JoinLeaveListener implements Listener {
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent ev) {
		if(Bukkit.getOnlinePlayers().size() <= 1 && !Main.getBungeeName().equals("lobby")) {
			Bukkit.shutdown();
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent ev) {
		Bukkit.getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				Main.sendNameRequest();
			}
			
		}, 10L);
	}
	
}
