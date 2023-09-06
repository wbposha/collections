package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void firstPlayerWin() {
        Player anna = new Player(1, "Anna", 500);
        Player sonya = new Player (2, "Sonya", 1000);
        Game game = new Game();

        game.register(anna);
        game.register(sonya);
        int actual = game.round("Anna", "Sonya");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Player anna = new Player(1, "Sonya", 5000);
        Player sonya = new Player (2, "Anna", 1000);
        Game game = new Game();

        game.register(anna);
        game.register(sonya);
        int actual = game.round("Sonya", "Anna");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equallyWin() {
        Player anna = new Player(1, "Sonya", 5000);
        Player sonya = new Player (2, "Anna", 5000);
        Game game = new Game();

        game.register(anna);
        game.register(sonya);
        int actual = game.round("Sonya", "Anna");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotExist() {
        Player anna = new Player(1, "Sonya", 5000);
        Player sonya = new Player (2, "Anna", 5000);
        Game game = new Game();

        game.register(anna);
        game.register(sonya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sonja", "Anna")
        );
    }

    @Test
    public void secondPlayerNotExist() {
        Player anna = new Player(1, "Sonya", 5000);
        Player sonya = new Player (2, "Anna", 5000);
        Game game = new Game();

        game.register(anna);
        game.register(sonya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sonya", "Annnna")
        );
    }

}