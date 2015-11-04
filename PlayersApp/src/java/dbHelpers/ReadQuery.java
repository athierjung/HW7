
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Players;

public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery () {
    
    Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void doRead() {
        
        try {
            String query = "Select * from Players";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable () {
        
        String table = "";
        table += "<table>";
        table += "<th>";
            table += "PlayerID";
        table += "</th>";
        table += "<th>";
            table += "Player Name";
        table += "</th>";
        table += "<th>";
            table += "Team";
        table += "</th>";
        table += "<th>";
            table += "Position";
        table += "</th>";
        table += "<th>";
            table += "Age";
        table += "</th>";
        table += "<th>";
            table += "Delete";
        table += "</th>";
        
        try {
            while (this.results.next()){
                Players player = new Players();
                player.setPlayerID(this.results.getInt("PlayerID"));
                player.setPlayerName(this.results.getString("PlayerName"));
                player.setTeam(this.results.getString("Team"));
                player.setPositionName(this.results.getString("PositionName"));
                player.setAge(this.results.getInt("Age"));
                
                
                table += "<tr>";
                    
                        table += "<td>";
                            table += player.getPlayerID();
                        table += "</td>";
                    
                        table += "<td>";
                            table += player.getPlayerName();
                        table += "</td>";
                   
                        table += "<td>";
                            table += player.getTeam();
                        table += "</td>";
                    
                        table += "<td>";
                            table += player.getPositionName();
                        table += "</td>";
                    
                        table += "<td>";
                            table += player.getAge();
                        table += "</td>";
                    
                        table += "<td>";
                        table += "<a href=delete?PlayerID=" + player.getPlayerID() + "> Delete </a>";
                        table += "</td>";
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
        
                return table;
    }
}
