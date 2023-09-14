import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void playerTwoWinTest() {
        Player zhenya = new Player(1, "Женя", 130);
        Player danil = new Player(2, "Данил", 140);
        Game game = new Game();

        game.register(zhenya);
        game.register(danil);
        int actual = game.round("Данил", "Женя");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerOneWinTest() {
        Player zhenya = new Player(1, "Женя", 155);
        Player danil = new Player(2, "Данил", 140);
        Game game = new Game();

        game.register(zhenya);
        game.register(danil);
        int actual = game.round("Данил", "Женя");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void BothWinsTest() {
        Player zhenya = new Player(1, "Женя", 140);
        Player danil = new Player(2, "Данил", 140);
        Game game = new Game();

        game.register(zhenya);
        game.register(danil);
        int actual = game.round("Данил", "Женя");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void FirstNotExistTest() {
        Player zhenya = new Player(1, "Женя", 140);
        Player danil = new Player(2, "Данил", 140);
        Game game = new Game();

        game.register(zhenya);
        game.register(danil);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Даша", "Женя"));
    }

    @Test
    public void SecondNotExistTest() {
        Player zhenya = new Player(1, "Женя", 140);
        Player danil = new Player(2, "Данил", 150);
        Game game = new Game();

        game.register(zhenya);
        game.register(danil);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Женя", "Даша"));
    }

    @Test
    public void BothNotExistTest() {
        Player zhenya = new Player(1, "Женя", 140);
        Player danil = new Player(2, "Данил", 140);
        Game game = new Game();

        game.register(zhenya);
        game.register(danil);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Маша", "Даша"));
    }
}
