package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();

    Player player1 = new Player(15, "Kano", 80);
    Player player2 = new Player(16, "Raiden", 30);
    Player player3 = new Player(17, "Reptile", 30);
    Player player4 = new Player(23, "Scorpion", 100);
    Player player5 = new Player(67, "Shang Tsung", 60);
    Player player6 = new Player(11, "Sonya Blade", 0);
    Player player7 = new Player(31, "Sub-Zero", -5);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player7);
    }

    @Test
    public void shouldWinFirstPlayer() {

        int expected = 1;
        int actual = game.round("Kano", "Reptile");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {

        int expected = 2;
        int actual = game.round("Kano", "Scorpion");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayDrawn() {

        int expected = 0;
        int actual = game.round("Raiden", "Reptile");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinFirstPlayerAgainstNegativeStrength() {

        int expected = 1;
        int actual = game.round("Kano", "Sub-Zero");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTrowExceptionWhenPlayer1Unregistered() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Sonya Blade", "Kano");
        });
    }

    @Test
    public void shouldThrowExceptionWhenPlayer2Unregistered() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Raiden", "Shang Tsung");
        });
    }

    @Test
    public void shouldThrowExceptionWhenBothPlayersUnregistered() {


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Sonya Blade", "Shang Tsung");
        });
    }

}