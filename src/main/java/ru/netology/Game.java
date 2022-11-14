package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {

    protected List<Player> players = new ArrayList<>();


    public void register(Player player) {   //регистрируем игрока, добавляя в список зарегистрированных
        players.add(player);
    }


    public int round(String playerName1, String playerName2) {

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (!players.contains(player1)) {
            throw new NotRegisteredException("Player with name: " + playerName1 + " is not registered");
        } else if (!players.contains(player2)) {
            throw new NotRegisteredException("Player with name: " + playerName2 + " is not registered");
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }

    public Player findByName(String name) {
        for (Player p : players) {
            if (p.getName() == name) {
                return p;
            }
        }
        return null;
    }
}
