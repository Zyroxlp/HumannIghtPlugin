package org.humannight.humannightplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.humannight.humannightplugin.clientservercomunication.CommandHandlerClientCom;
import org.humannight.humannightplugin.playersystem.joinEvent;

public final class HumannightPlugin extends JavaPlugin {

    public static MySQL mysqlplayer;

    private static HumannightPlugin instance;

    public static HumannightPlugin getPlugin(){
        return instance;
    }

    @Override
    public void onEnable() {
        PluginManager pluginmanager = Bukkit.getPluginManager();

        loadMySql();

        pluginmanager.registerEvents(new PlayerRespawnEvent(),this);
        pluginmanager.registerEvents(new joinEvent(),this);

        instance = this;
        this.getCommand("senddatafromclient").setExecutor(new CommandHandlerClientCom());

    }

    @Override
    public void onDisable() {
    }

    public  static void loadMySql()  {
        String host = "localhost";
        String user = "mc";
        int port = 3306;
        String pw = "oz]8-xFjL1TFU(Zb";
        mysqlplayer = new MySQL(host,port, "mc",user,pw);
    }



}
