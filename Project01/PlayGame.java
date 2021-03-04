package Project01;
import Project01.Nation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

/**
 * Description
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 2.0
 * @since 2021-03-04
 */
public class PlayGame
{

    ArrayList<Nation> allLivingNations = new ArrayList<>();
    ArrayList<Project01.People> worldLivingPopulation = new ArrayList<>();
    Random generator;

    public PlayGame()
    {
        Date seed = new Date();
        generator = new Random(seed.getTime());
    }

    /**
     * Adds all People of all types per nation and tribe to world ArrayList
     * @param nations
     */
    public void getWorldLivingPopulation(ArrayList<Nation> nations)
    {
        // add all living people to world list
        worldLivingPopulation.clear();
        for (Nation nation : nations) worldLivingPopulation.addAll(nation.getNationPopulation());
    }

    /**
     * Checks to see what nation(s) are still alive
     * @param nations
     */
    public void getAllLivingNations(ArrayList<Nation> nations)
    {
        getWorldLivingPopulation(nations);
        allLivingNations.clear();
        for (Nation nation : nations) {
            if (nation.isNationAlive()) {
                allLivingNations.add(nation);
            }
        }
    }

    /**
     * This is the turn where P1 attacks P2 in the turn
     * Rolls random amount of damage on P2
     * @param p1
     * @param p2
     */
    public void encounter(Project01.People p1, Project01.People p2)
    {
        // need to fix this to take strategies into account.
        if(p1.getNation() != p2.getNation())
        {
            p1.encounterStrategy(p2);
            System.out.print(p1 + " encounters " + p2);
            int p1Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            int p2Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            p1.reduceLifePoints(p1Damage);
            p2.reduceLifePoints(p2Damage);

            System.out.println("\t\tp1 damage is " + p1Damage + ". p2 damage is " + p2Damage + ".");
        }
    }


    /**
     * Goes through one round of the game
     * Returns all living nations
     * @param nations
     * @return
     */
    public Boolean playOneRound(ArrayList<Nation> nations)
    {
        getAllLivingNations(nations);
        int index = 0;
        while((allLivingNations.size() > 1) && (index < worldLivingPopulation.size()))
        {
            //encounter(worldLivingPopulation.get(pointers.get(index)), worldLivingPopulation.get(pointers.get(index+1)));
            //System.out.println((worldLivingPopulation.size()-1) + "\t" + limit + "\t" + index + "\t" + (index+1));
            int p1Index = generator.nextInt(worldLivingPopulation.size());
            int p2Index;
            do
                p2Index = generator.nextInt(worldLivingPopulation.size());
            while(p1Index == p2Index);
            encounter(worldLivingPopulation.get(p1Index), worldLivingPopulation.get(p2Index));
            getAllLivingNations(nations);
            if(allLivingNations.size() < 2)
                break;
            index = index + 1;
        }

        return (allLivingNations.size() < 2);


    }

    /**
     * Shows who won the game
     * If there is a game winner
     * @return
     */
    public String getWinner()
    {
        if (allLivingNations.size() == 0)
            return "No Winner!";
        else
            return allLivingNations.get(0).getNationName();
    }
}
