package org.humannight.humannightplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.humannight.humannightplugin.clientservercomunication.CommandHandlerClientCom;

public final class HumannightPlugin extends JavaPlugin {

    public static MySQL mysqlchar;
    public static MySQL mysqlbank;

    private static HumannightPlugin instance;

    public static HumannightPlugin getPlugin(){
        return instance;
    }

    @Override
    public void onEnable() {
        PluginManager pluginmanager = Bukkit.getPluginManager();
        pluginmanager.registerEvents(new PlayerRespawnEvent(),this);

        instance = this;
        this.getCommand("senddatafromclient").setExecutor(new CommandHandlerClientCom());

    }

    @Override
    public void onDisable() {
    }

    public  static void loadMySql()  {
        String host = "localhost";
        String user = "root";
        int port = 3306;
        String pw = "r1BJ(b5`gK4<";
        mysqlchar = new MySQL(host,port, "chars",user,pw);
        mysqlbank = new MySQL(host,port, "Bank",user,pw);
    }



}
