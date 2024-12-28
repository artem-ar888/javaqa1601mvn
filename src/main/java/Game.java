import java.util.HashMap;

public class Game {
    private HashMap<String, Player> registeredPlayers = new HashMap<>();

    public void register(Player player) {
        registeredPlayers.put(player.getName(), player);
    }

    private void checkRegistration(String playerName) {
        if (!registeredPlayers.containsKey(playerName)) {
            throw new NotRegisteredException(playerName);
        }
    }

    private void checkForSameness(String playerName1, String playerName2) {
        if (registeredPlayers.get(playerName1).equals(registeredPlayers.get(playerName2))) {
            throw new SamePlayersException(playerName1);
        }
    }

    private int playerStrength(String playerName) {
        Player p = registeredPlayers.get(playerName);
        return p.getStrength();
    }

    public int round(String playerName1, String playerName2) {
        checkRegistration(playerName1);
        checkRegistration(playerName2);
        checkForSameness(playerName1, playerName2);
        if (playerStrength(playerName1) > playerStrength(playerName2)) {
            return 1;
        } else if (playerStrength(playerName1) < playerStrength(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }
}
