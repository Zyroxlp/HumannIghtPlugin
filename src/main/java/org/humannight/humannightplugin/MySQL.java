package org.humannight.humannightplugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private Connection con;

    private String host;

    private int port;
    private String database;

    private String user;
    private String pw;

    public MySQL(String host, int port, String database, String user, String pw) {
        this.host= host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.pw = pw;

        connect();
    }

    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + host +":"+ port +"/" + database + "?autoReconnect=true", user, pw);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Mysql disconnected!");
        }

    }

    public void disconnect() {
        try {
            if(this.hasConnection()) {
                this.con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean hasConnection(){
        if(this.con !=null) {
            return true;
        }
        return false;
    }

    public Connection getConection() {
        return this.con;
    }
}
