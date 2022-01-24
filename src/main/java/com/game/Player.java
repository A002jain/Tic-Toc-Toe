package com.game;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private static final ArrayList<String> playerNames = new ArrayList<>();
    private String playerName;
    private final String playerSymbol;

    public Player(String playerName, String playerSymbol){
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
        if(playerNames.size() == 1)
            updateIfPlayerExist();
        playerNames.add(this.playerName);
    }

    private void updateIfPlayerExist(){
        String pName = playerNames.get(0);
        if(this.playerName.equals(pName))
            this.playerName = this.playerName + "1";
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getSymbol(){
        return playerSymbol;
    }

    public String playerInput(){
        return GameConsole.consoleIn("[ " + this.playerName + " ] enter place(1-9): ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName) && Objects.equals(playerSymbol, player.playerSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, playerSymbol);
    }
}
