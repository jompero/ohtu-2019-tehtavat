package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            player1Score += 1;
        if (playerName == player2Name) {
            player2Score += 1;
        }   
    }

    public String getScore() {
        if (player1Score==player2Score) 
            return evenScore();
        else if (player1Score>=4 || player2Score>=4) 
            return testDifference();
        return defaultScore();
    }

    private String evenScore() {
        if (player1Score == 4) return "Deuce";
        else return String.format("%s-All", translateDefault(player1Score));
    }

    private String testDifference() {
        int difference = player1Score - player2Score;
        return Math.abs(difference) == 1 ? advantagePlayer(difference) : winPlayer(difference);
    }

    private String winPlayer(int difference) {
        return String.format("Win for %s", getSide(difference));
    }

    private String advantagePlayer(int difference) {
        return String.format("Advantage %s", getSide(difference));
    }

    private String getSide(int difference) {
        return difference > 0 ? player1Name : player2Name;
    }

    private String defaultScore() {
        return String.format("%s-%s", translateDefault(player1Score), translateDefault(player2Score));
    }

    private String translateDefault(int score) {
        switch(score)
        {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "";
        }
    }
}