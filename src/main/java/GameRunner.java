import com.game.GameConsole;
import com.game.GameInterface;
import com.game.GamePredicates;
import com.game.Player;

import java.util.function.Function;


public class GameRunner {
    private static final GameInterface game = new GameInterface();
    private static final Function<GameInterface, String> gameStart = GameInterface::startGame;

    public static void run(){
        GameConsole.consoleOut("Welcome to TicTacToe :)");
        GameConsole.consoleOut(" 1|2|3\n 4|5|6\n 7|8|9");
        String player1Name = GameConsole.consoleIn("[ X ] Player1 Name: ");
        String player2Name = GameConsole.consoleIn("[ 0 ] Player2 Name: ");
        Player player1 = new Player(player1Name, "X");
        Player player2 = new Player(player2Name, "0");
        game.addPlayer(player1);
        game.addPlayer(player2);
        while (true) {
            GameConsole.consoleOut("TIC TAC TOE");
            String result = gameStart.apply(game);
            if(GamePredicates.restart.negate().test(result))
                break;
            GameConsole.consoleOut("Restarting Game");

        }
    }

    public static void main(String[] args) { GameRunner.run(); }
}
