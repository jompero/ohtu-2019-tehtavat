
package ohtu;

import java.util.Comparator;

public class Player implements Comparable {
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getTeam() {
        return team;
    }
    
    public void setGoals(int goals) {
        this.goals = goals;
    }
    
    public int getGoals() {
        return goals;
    }
    
    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    public int getAssists() {
        return assists;
    }
    
    public int getPoints() {
        return goals + assists;
    }

    @Override
    public String toString() {
        int nameColumnWidth = 25;
        String nameSpacing = "";
        for (int i = 0; i < nameColumnWidth - name.length(); i++) {
            nameSpacing += " ";
        }
        
        int teamColumnWidth = 10;
        String teamSpacing = "";
        for (int i = 0; i < teamColumnWidth - team.length(); i++) {
            teamSpacing += " ";
        }
        
        return String.format("%s %s %s %s %d + %d = %d", name, nameSpacing, team, teamSpacing, goals, assists, getPoints());
    }
    
    public static Comparator<Player> pointsComparator() {
        return Comparator.comparingInt(Player::getPoints).reversed();
    }

    @Override
    public int compareTo(Object o) {
        Player p = (Player) o;
        return this.name.compareTo(p.getName());
    }
      
}
