import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    Game players = new Game();
    Player player1 = new Player(1, "Vitya", 20);
    Player player2 = new Player(2, "Pasha", 40);
    Player player3 = new Player(3, "Zahar", 20);
    Player player4 = new Player(4, "Roma", 10);
    Player player5 = new Player(5, "Vova", 10);

    @BeforeEach
    public void setup() {
        players.register(player1);
        players.register(player2);
        players.register(player3);
    }

    @Test
    public void shouldWinFirstPlayer() {
        int expected = 1;
        int actual = players.round(player2.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        int expected = 2;
        int actual = players.round(player1.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() {
        int expected = 0;
        int actual = players.round(player1.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotBePlayedBecauseTheFirstPlayerIsNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round(player4.getName(), player1.getName());
        });
    }

    @Test
    public void shouldNotBePlayedBecauseTheSecondPlayerIsNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round(player2.getName(), player5.getName());
        });
    }

    @Test
    public void shouldNotBePlayedBecauseItIsWithYourself() {
        Assertions.assertThrows(SamePlayersException.class, () -> {
            players.round(player1.getName(), player1.getName());
        });
    }
}