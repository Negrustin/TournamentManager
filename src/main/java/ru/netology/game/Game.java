package ru.netology.game;

import ru.netology.domain.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playersList = new ArrayList<>();

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void register(Player player) {
        playersList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null){
            throw new NotRegisteredException("Player " + playerName1 + " is not registered");
        }
        if (findByName(playerName2) == null){
            throw new NotRegisteredException("Player " + playerName1 + " is not registered");
        }
        if(findByName(playerName1).getStrength() > findByName(playerName2).getStrength()){
            return 1;
        }else if(findByName(playerName1).getStrength() < findByName(playerName2).getStrength()){
            return 2;
        }else {
            return 0;
        }
    }

    public Player findByName(String name) {
        for (Player player : playersList) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }
}
