package kz.chesschicken.rubetaessentials;

import kz.chesschicken.rubetaessentials.utils.Packet253Ping;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.client.Minecraft;
import net.minecraft.packet.play.ChatMessage0x3Packet;


public class InitClass implements PreLaunchEntrypoint {
	public static ConfigClass CONFIG;
	public static long ping;

	@Override
	public void onPreLaunch() {
		CONFIG = new ConfigClass();
		CONFIG.start();
	}

	public static void handlePing(ChatMessage0x3Packet packet253ping) {
		if(!ConfigClass.EnumConfigBooleans.PING_SERVER_CLIENT.getValue())
			return;
		InitClass.ping = System.currentTimeMillis() - ((Packet253Ping)packet253ping).clientTime;
		((Packet253Ping)packet253ping).clientTime = System.currentTimeMillis();
		((Minecraft) FabricLoader.getInstance().getGameInstance()).getNetworkHandler().sendPacket(packet253ping);
	}
}
