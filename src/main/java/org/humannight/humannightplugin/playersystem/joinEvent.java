package org.humannight.humannightplugin.playersystem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.humannight.humannightplugin.HumannightPlugin;
import org.humannight.humannightplugin.clientservercomunication.MessageSender;

import java.sql.SQLException;

import static org.humannight.humannightplugin.playersystem.MYSQL.*;

public class joinEvent implements Listener {
    @EventHandler
    public void onPlayerjoinEvent(PlayerJoinEvent event) throws SQLException {
        Player player = event.getPlayer();
        if (!checkfirstjoin(player)) {
            createMysql(player);
        }
        Helper.authkey.put(player,getAuthCode(player));
        Bukkit.getScheduler().runTaskLater(HumannightPlugin.getPlugin(), () -> {
            MessageSender.sendHiddenMessage(player, "joinsystem startgui"); //sends the info to player to opens startgui
        },60L);
    }
}
