package org.humannight.humannightplugin.clientservercomunication;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandlerClientCom implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            switch (args[0]) { //hier werden die Daten gehandlet die vom Client kommen

                case "charckter":

                    break;



                default:
                    player.sendMessage(ChatColor.GREEN + "Daten erfolgreich empfangen!");
            }



            // Versteckte Nachricht an die Mod senden
            MessageSender.sendHiddenMessage(player, "Geheime Daten für die Mod");
            return true;
        }
        return false;
    }
}
