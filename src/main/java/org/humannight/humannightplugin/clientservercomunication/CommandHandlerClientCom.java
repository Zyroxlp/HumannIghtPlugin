package org.humannight.humannightplugin.clientservercomunication;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.humannight.humannightplugin.playersystem.MYSQL;

import java.sql.SQLException;
import java.util.Objects;

public class CommandHandlerClientCom implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            try {
                if (Objects.equals(args[0], String.valueOf(MYSQL.getAuthCode(player)))) {

                    switch (args[1]) { //hier werden die Daten gehandlet die vom Client kommen

                        case "joinsystem":

                            break;

                        default:
                            player.sendMessage(ChatColor.GREEN + "Daten erfolgreich empfangen!");
                            break;
                    }
                return true;
                }else player.sendMessage("&4 Falscher Key");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
