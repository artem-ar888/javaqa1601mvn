public class SamePlayersException extends RuntimeException {
    public SamePlayersException(String playerName) {
        super("Player " + playerName + " cannot play with himself");
    }
}
