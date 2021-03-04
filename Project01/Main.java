package Project01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import Project01.Nation;
import Project01.Tribe;
import Project01.PlayGame;

/**
 * Description
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 2.0
 * @since 2021-03-04
 */
public class Main {

    /**
     * Gives gameLifePoints=2000.
     * Creates Nations that can be played in-game.
     * Goes through rounds with the amount of nations that are created.
     * Prints the winning nation after game (if any).
     * @param args An array of strings.
     */
    public static void main(String[] args)
    {
       int gameLifePoints = 2000;
       ArrayList<Nation> nations = new ArrayList<>() ; // nations create tribes create people
       PlayGame game = new PlayGame();
	   nations.add(new Nation("Max's Nation",(gameLifePoints /4)));
       nations.add(new Nation("Elizabeth's Nation",(gameLifePoints /4)));
       nations.add(new Nation("Justin's Nation", (gameLifePoints/4)));
       nations.add(new Nation("Tanishq's Nation", (gameLifePoints/4)));

        // could add and delete nations. return number of nations + 1 from add and number of nations -1 from remove.
	   for(int i = 0; i < 40; i++)
       {
           System.out.println("Round number: " + i);
           if (game.playOneRound(nations))
           {
               System.out.println("There is a winner!");
               break; // game over
           }
       }

	   System.out.println("The winning nation is " + game.getWinner() + ".");
    }
}
