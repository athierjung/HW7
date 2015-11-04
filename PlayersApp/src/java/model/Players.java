
package model;


public class Players {
   private int PlayerID;
   private String PlayerName;
   private String Team;
   private String PositionName;
   private int Age;

   public Players() {
        this.PlayerID = 0;
        this.PlayerName = "";
        this.Team = "";
        this.PositionName = "";
        this.Age = 0;
    }
   
   public Players(int PlayerID, String PlayerName, String Team, String PositionName, int Age) {
        this.PlayerID = PlayerID;
        this.PlayerName = PlayerName;
        this.Team = Team;
        this.PositionName = PositionName;
        this.Age = Age;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int PlayerID) {
        this.PlayerID = PlayerID;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String PlayerName) {
        this.PlayerName = PlayerName;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String Team) {
        this.Team = Team;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String PositionName) {
        this.PositionName = PositionName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    @Override
    public String toString() {
        return "Players{" + "PlayerID=" + PlayerID + ", PlayerName=" + PlayerName + ", Team=" + Team + ", PositionName=" + PositionName + ", Age=" + Age + '}';
    }
   
    
}
