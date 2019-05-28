package xo;

import org.slf4j.Logger;
import xo.model.Field;
import xo.model.Figure;
import xo.model.Game;
import xo.model.Player;
import xo.model.exceptions.InvalidBoardSizeException;
import xo.view.ConsoleView;

import java.util.Scanner;



public class XOCLI {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(XOCLI.class);

    public static void main(final String[] args) {
        final int FIELD_SIZE = 3;
        final String name1 = playerNameInput(1);
        final String name2 = playerNameInput(2);

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);
        Field field = null;
        try {
            field = new Field(FIELD_SIZE);
        } catch (InvalidBoardSizeException e) {
            e.printStackTrace();
        }
        final Game gameXO = new Game(players, field, "XO");
        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }

    private static String playerNameInput(final int count) {
        Scanner sc = new Scanner(System.in);
        log.info("Enter Player {}  name: ", count);
        return sc.nextLine();
    }

}

