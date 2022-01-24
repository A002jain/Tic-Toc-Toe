package com.game;

import java.util.ArrayList;
import java.util.Objects;

public class GameInterface {

    private static final TicTacToe ticTacToe = new TicTacToe();
    private static final ArrayList<Player> playerList = new ArrayList<>();


    public void addPlayer(Player player){
        playerList.add(player);
    }

    private String inputProcessor(String str){
        String result = str;
        if(str.length() != 1)
            result = "error";
        if(GamePredicates.restart.test(str)) {
            ticTacToe.resetGame();
            TurnCounter.reset();
            result = "r";
        }
        else if(GamePredicates.exit.test(str))
            result = "e";
        return result;
    }

    private void clearConsole(){
        //Not Working
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cmd C:\\Users\\info\\Documents cls");
            } else {
                Runtime.getRuntime().exec("cmd C:\\Users\\info\\Documents clear");
            }
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public String startGame() {
        String result = null;
        int x ;
        GameConsole.consoleOut(ticTacToe.gameOutPlot());
        while (true) {
            for (Player player : playerList) {
                while (true) {
                    String inp = player.playerInput();
                    String getOptions = inputProcessor(inp);
//                    clearConsole();
                    if (GamePredicates.restart.test(getOptions) || GamePredicates.exit.test(getOptions)) {
                        return getOptions;
                    }

                    try {
                        x = Integer.parseInt(getOptions);
                    } catch (NumberFormatException e) {
                        continue;
                    }

                    if (GamePredicates.validRange.test(x)) {
                        if (!ticTacToe.addValue(x-1, player)) {
                            continue;
                        }
                        GameConsole.consoleOut(ticTacToe.gameOutPlot());
                        break;
                    }
                }
                TurnCounter.increment();

                if(TurnCounter.get() > 4){
                    result = ticTacToe.gameResult();
                    if(Objects.nonNull(result)){
                        if(player.getSymbol().equals(result))
                            GameConsole.consoleOut(player.getPlayerName()+ " ("+result+ ") Won Yeah :)");
                        return inputProcessor(GameConsole.consoleIn("e -> Exit r->restart"));
                    }
                }
                if(TurnCounter.get() == 9){
                    return inputProcessor(GameConsole.consoleIn("e -> Exit r->restart"));
                }
            }
        }
    }
}
