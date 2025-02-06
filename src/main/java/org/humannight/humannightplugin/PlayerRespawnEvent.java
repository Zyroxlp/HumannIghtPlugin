package org.humannight.humannightplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;
import java.sql.SQLException;

public class PlayerRespawnEvent implements Listener {

    @EventHandler
    public void Event(org.bukkit.event.player.PlayerRespawnEvent event) throws SQLException, IOException {
        Player player = event.getPlayer();
        HumannightPlugin.sendMessageToClient("OH " + player.getDisplayName() + " ist wiederauferstanden UwU");
    }


}
