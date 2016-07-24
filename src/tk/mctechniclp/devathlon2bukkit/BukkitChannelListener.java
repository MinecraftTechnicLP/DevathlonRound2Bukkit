package tk.mctechniclp.devathlon2bukkit;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

public class BukkitChannelListener implements PluginMessageListener {

	@Override
	public void onPluginMessageReceived(String channel, Player p, byte[] msg) {
		if (!channel.equals("BungeeCord")) return;
		
		ByteArrayDataInput in = ByteStreams.newDataInput(msg);
		String subchannel = in.readUTF();
		
		if (subchannel.equals("GetServer")) {
			Main.setBungeeName(in.readUTF());
		}
	}

}
