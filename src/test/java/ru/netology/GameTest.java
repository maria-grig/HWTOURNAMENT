package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Kano", 80);
    Player player2 = new Player(1, "Raiden", 30);
    Player player3 = new Player(1, "Reptile", 30);
    Player player4 = new Player(1, "Scorpion", 100);
    Player player5 = new Player(1, "Shang Tsung", 60);
    Player player6 = new Player(1, "Sonya Blade", 0);
    Player player7 = new Player(1, "Sub-Zero", -5);



    @Test
    public void shouldTrowExceptionWhenPlayer1Unregistered() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player7);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Sonya Blade", "Kano");
        });
    }

    @Test
    public void shouldThrowExceptionWhenPlayer2Unregistered() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player7);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Raiden", "Shang Tsung");
        });
    }

    @Test
    public void shouldThrowExceptionWhenBothPlayersUnregistered() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player7);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Sonya Blade", "Shang Tsung");
        });
    }

    @Test
    public void shouldWinFirstPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player7);

        int expected = 1;
        int actual = game.round("Kano", "Reptile");
    }

    @Test
    public void shouldWinSecondPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player7);

        int expected = 2;
        int actual = game.round("Kano", "Scorpion");
    }

    @Test
    public void shouldPlayDrawn() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player7);

        int expected = 0;
        int actual = game.round("Raiden", "Reptile");
    }

    @Test
    public void shouldWinFirstPlayerAgainstNegativeStrength() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player7);

        int expected = 1;
        int actual = game.round("Kano", "Sub-Zero");
    }

}