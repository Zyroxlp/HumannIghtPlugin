package org.humannight.humannightplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.humannight.humannightplugin.clientservercomunication.MessageSender;

public class PlayerRespawnEvent implements Listener {

    @EventHandler
    public void Event(org.bukkit.event.player.PlayerRespawnEvent event){
        Player player = event.getPlayer();
        MessageSender.sendHiddenMessage(player,"Moin");
    }
}
