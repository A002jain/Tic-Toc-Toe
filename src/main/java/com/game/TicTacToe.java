package com.game;

import java.util.ArrayList;

public class TicTacToe {
    private static final ArrayList<String> gameValues = new ArrayList<>();
    private static final String PATTERN = " %s | %s | %s";

    public TicTacToe() {
        for(int i =0 ;i<9 ;i++)
            gameValues.add(null);
    }

    public String gameOutPlot() {
        for (int i = 0; i < 9; i++) {
                if (gameValues.get(i) == null)
                    gameValues.add(i," ");
        }
        return toString();
    }

    public boolean addValue(int x,Player player) {
        if(gameValues.get(x).equals(" ")) {
            gameValues.set(x, player.getSymbol());
            return true;
        }
        return false;
    }

    private String getPattern(int x ,int y ,int z){
        return gameValues.get(x)+ gameValues.get(y) + gameValues.get(z);
    }

    public String gameResult() {
        for (int i = 0; i < 8; i++) {
            String tmp = "";
            switch (i) {
                case 0:
                    tmp = getPattern(0, 4, 8);
                    break;
                case 1:
                    tmp = getPattern(2, 4, 6);
                    break;
                case 2:
                    tmp = getPattern(0, 1, 2);
                    break;
                case 3:
                    tmp = getPattern(3, 4, 5);
                    break;
                case 4:
                    tmp = getPattern(6, 7, 8);
                    break;
                case 5:
                    tmp = getPattern(0, 3, 6);
                    break;
                case 6:
                    tmp = getPattern(1, 4, 7);
                    break;
                case 7:
                    tmp = getPattern(2, 5, 8);
                    break;
            }
            if (tmp.equals("XXX")) {
                return "X";
            }
            if (tmp.equals("000")) {
                return "0";
            }
        }
        return null;
    }

    public void resetGame(){
        for(int i =0 ;i<9 ;i++)
            gameValues.set(i,null);
    }

    @Override
    public String toString() {
        return String.format(PATTERN, gameValues.get(0), gameValues.get(1), gameValues.get(2)) +
                String.format("%n"+PATTERN, gameValues.get(3), gameValues.get(4), gameValues.get(5)) +
                String.format("%n"+PATTERN, gameValues.get(6), gameValues.get(7), gameValues.get(8));
    }
}
