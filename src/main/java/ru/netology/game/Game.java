package ru.netology.game;

import ru.netology.domain.Player;
import ru.netology.exceptions.NotRegisteredException;
import java.util.HashMap;

public class Game {
HashMap<String,Player> playerHashMap = new HashMap<>();
    public HashMap<String,Player> getPlayersList() {
        return playerHashMap;
    }

    public void register(Player player) {
        playerHashMap.put(player.getName(),player);
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
        for (String playerName : playerHashMap.keySet()) {
            if (playerName == name) {
                return playerHashMap.get(name);
            }
        }
        return null;
    }
}
