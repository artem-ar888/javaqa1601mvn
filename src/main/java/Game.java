import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> registeredPlayers = new ArrayList<>();

    public void register(Player player) {
        registeredPlayers.add(player);
    }

    public int round(String playerName1, String playerName2) {
        if (playerName1.equals(playerName2)) {
            throw new SamePlayersException(playerName1);
        }
        Player p1 = null;
        Player p2 = null;
        for (Player player : registeredPlayers) {
            if (player.getName().equals(playerName1)) {
                p1 = player;
            }
            if (player.getName().equals(playerName2)) {
                p2 = player;
            }
        }
        if (p1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (p2 == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (p1.getStrength() > p2.getStrength()) {
            return 1;
        } else if (p1.getStrength() < p2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
