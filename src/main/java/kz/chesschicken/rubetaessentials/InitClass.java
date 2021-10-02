package kz.chesschicken.rubetaessentials;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.packet.play.ChatMessage0x3Packet;


public class InitClass implements ModInitializer {
	public static long ping;
	@Override
	public void onInitialize() {

	}

	public static void handlePing(ChatMessage0x3Packet packet253ping) {
		InitClass.ping = System.currentTimeMillis() - ((Packet253Ping)packet253ping).clientTime;
		((Packet253Ping)packet253ping).clientTime = System.currentTimeMillis();
		((Minecraft) FabricLoader.getInstance().getGameInstance()).getNetworkHandler().sendPacket(packet253ping);
	}
}
