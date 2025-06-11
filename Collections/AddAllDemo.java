import java.util.ArrayList;
import java.util.Collections;;

public class AddAllDemo {
    public static void main(String[] args) {
        ArrayList<String> teamAPlayers = new ArrayList<>();
        ArrayList<String> teamBPlayers = new ArrayList<>();
        ArrayList<String> players = new ArrayList<>();
        Collections.addAll(teamAPlayers, "Nani", "Ronaldo", "Pepe");
        Collections.addAll(teamBPlayers, "Di Maria", "Messi", "Otamendi");
        
        players.addAll(teamAPlayers);
        players.addAll(teamBPlayers);
        System.out.println("POR: {\'" + String.join("\', \'", teamAPlayers) + "\'}");
        System.out.println("ARG: {\'" + String.join("\', \'", teamBPlayers) + "\'}");
        System.out.println("ALL: {\'" + String.join("\', \'", players) + "\'}");
    }
}