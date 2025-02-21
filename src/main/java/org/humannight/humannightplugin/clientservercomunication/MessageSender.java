package org.humannight.humannightplugin.clientservercomunication;

import org.bukkit.entity.Player;

public class MessageSender {

    public static void sendHiddenMessage(Player player, String message) {
        player.sendMessage("[ServerMsg] " +message);  // Nachricht wird an die Mod gesendet, aber bleibt für den Spieler unsichtbar
    }
}
