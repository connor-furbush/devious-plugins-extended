package net.unethicalite.plugins.logout;

import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.ClientTick;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.game.Game;
import org.pf4j.Extension;

import javax.inject.Inject;

@Extension
@PluginDescriptor(name = "Bushhy Teleport", description = "DMM Auto Tele", enabledByDefault = false)
public class TelePlugin extends Plugin
{
	@Inject
	private Client client;

	@Subscribe
	private void onClientTick(ClientTick e)
	{
		Player local = Players.getLocal();
		Player pker = Players.getNearest(player -> player != local);
		var teleport = Inventory.getFirst("Royal seed pod");
		if (pker != null)
		{
			teleport.interact("Commune");
			log.error("Teleported from pker!");
		}
	}
}
