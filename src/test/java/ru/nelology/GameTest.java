package ru.nelology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void shouldRoundPlayerSecondIsStrength(){
        Game game = new Game();
        Player bob = new Player(1, "Bob", 55);
        Player tom = new Player(2, "Tom", 77);

        game.register(bob);
        game.register(tom);

        int actual = game.round("Bob", "Tom");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void shouldRoundPlayerFirstIsStrength() {
        Game game = new Game();
        Player bob = new Player(1, "Bob", 60);
        Player tom = new Player(2, "Tom", 45);

        game.register(bob);
        game.register(tom);

        int actual = game.round("Bob", "Tom");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldRoundPlayersDrawStrength() {
        Game game = new Game();
        Player bob = new Player(1, "Bob", 80);
        Player tom = new Player(2, "Tom", 80);

        game.register(bob);
        game.register(tom);

        int actual = game.round("Bob", "Tom");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldRoundPlayerFirstException() {
        Game game = new Game();
        Player bob = new Player(1, "Bob", 25);
        Player tom = new Player(2, "Tom", 48);

        game.register(bob);
        game.register(tom);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("", "Tom"));
    }
    @Test
    public void shouldRoundPlayerSecondException() {
        Game game = new Game();
        Player bob = new Player(1, "Bob", 25);
        Player tom = new Player(2, "Tom", 48);

        game.register(bob);
        game.register(tom);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Bob", ""));
    }
    @Test
    public void shouldRoundNoTwoPlayersException() {
        Game game = new Game();
        Player bob = new Player(1, "Bob", 25);
        Player tom = new Player(2, "Tom", 48);

        game.register(bob);
        game.register(tom);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("", ""));
    }

}
