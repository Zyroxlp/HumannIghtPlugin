package org.humannight.humannightplugin.playersystem;


import org.bukkit.entity.Player;
import org.humannight.humannightplugin.HumannightPlugin;

import java.sql.*;
import java.time.Instant;
import java.util.Random;

public class MYSQL {

    public static boolean checkfirstjoin(Player player) throws SQLException {
        PreparedStatement st = HumannightPlugin.mysqlplayer.getConection().prepareStatement("SELECT `id` FROM `player` WHERE `uuid` =?");
        st.setString(1, String.valueOf(player.getUniqueId()));
        ResultSet rs = st.executeQuery();
        rs.last();
        int row = rs.getRow();
        if(row == 1 ){
            return true;
        }
        return false;
    }

    public static  void createMysql(Player player) throws SQLException {
        PreparedStatement st = HumannightPlugin.mysqlplayer.getConection().prepareStatement("INSERT into `player` VALUES (?,?,?,?,?)");
        st.setInt(1,latestid()+1);
        st.setString(2, String.valueOf(player.getUniqueId()));
        st.setInt(3,1);
        st.setString(4,generateUniqueAuthCode());
        st.setTimestamp(5, Timestamp.from(Instant.now()));
        st.execute();
    }

    public static int latestid() throws  SQLException {
        PreparedStatement st = HumannightPlugin.mysqlplayer.getConection().prepareStatement("SELECT `ID` FROM `player` ORDER BY `ID` DESC LIMIT 1");
        ResultSet result = st.executeQuery();
        result.next();
        int id = result.getInt("ID");
        return id;
    }

    private static String generateUniqueAuthCode() throws SQLException {
        String authCode;
        do {
            authCode = generateAuthCode();
        } while (isCodeInDatabase(authCode));
        return authCode;
    }

    private static String generateAuthCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // 6-stellige Zahl
        return String.valueOf(code);
    }

    private static boolean isCodeInDatabase(String code) throws SQLException {
        String query = "SELECT COUNT(*) FROM player WHERE authkey = ?";
        try (PreparedStatement stmt = HumannightPlugin.mysqlplayer.getConection().prepareStatement(query)) {
            stmt.setString(1, code);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public static Integer getAuthCode(Player player) throws SQLException {
        PreparedStatement st = HumannightPlugin.mysqlplayer.getConection().prepareStatement("SELECT `authkey` FROM `player` WHERE `uuid` = ?");
        st.setString(1, String.valueOf(player.getUniqueId()));
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getInt(1);
    }



}
