package org.humannight.humannightplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static org.bukkit.Bukkit.getServer;

public final class HumannightPlugin extends JavaPlugin {




    @Override
    public void onEnable() {
        startServer();
        PluginManager pluginmanager = Bukkit.getPluginManager();
        pluginmanager.registerEvents(new PlayerRespawnEvent(),this);

    }

    @Override
    public void onDisable() {
    }

    public void startServer() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(8080)) { // Use the same port as the client
                System.out.println("Server started. Waiting for client connection...");

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    String message = in.readLine();
                    System.out.println("Received from client: " + message);

                    // Handle the message (e.g., execute a command or trigger an event)
                    getServer().getScheduler().runTask(this, () -> {
                        getServer().broadcastMessage("Mod says: " + message);
                    });

                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // Send a message to the client
    public static void sendMessageToClient(String message) {
        new Thread(() -> {
            try (Socket socket = new Socket("localhost", 8081); // Use the client's listening port
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                out.println(message); // Send the message to the client
                System.out.println("Sent to client: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
