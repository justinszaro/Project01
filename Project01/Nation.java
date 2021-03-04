package Project01;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import Project01.Tribe;
import Project01.People;

public class Nation
{
    private int nationLifePoints;
    public static int nationCount = 0;
    private String nationName;
    private ArrayList<Tribe> tribes = new ArrayList<>();
    private ArrayList<People> population = new ArrayList<>();
    private ArrayList<People> livingPopulation = new ArrayList<>();

    /**
     * Creates new 3 new tribes for every nation that is created
     * Puts 3 people within each tribe
     * @param name
     * @param lifePoints
     */
    public Nation(String name, int lifePoints)
    {
        nationCount++;
        nationName = name;
        nationLifePoints = lifePoints;
        for(int i = 0; i < 3; i++)
        {
            this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / 3));
        }
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }

    /**
     * Checks if nation is alive with lifepoints greater than 0
     * @return
     */
    public Boolean isNationAlive()
    {
        return (nationLifePoints > 0);
    }

    /**
     * Finds the people in each tribe in each nation that are still alive
     * @return
     */
    public ArrayList<People> getNationPopulation()
    {
        nationLifePoints = 0;
        livingPopulation.clear();
        for(int tribe = 0; tribe < this.tribes.size(); tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                livingPopulation.addAll(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += tribes.get(tribe).getTribeLifePoints();
            }
        }
        return livingPopulation;
    }


    public String getNationName()
    {
        return nationName;
    }

    /**
     * Checks if Tribe is alive
     * Checks if people in tribe are alive
     * Prints the results if people are alive and if they are dead
     */
    public void printTribesStatus()
    {
        for(int tribe = 0; tribe < 1; tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                System.out.print(tribes.get(tribe).getTribeName() + " is alive and has ");
                System.out.println(tribes.get(tribe).getTribeSize() + " members.");
            }
            else
            {
                System.out.println(tribes.get(tribe).getTribeName() + " is dead.");
            }
        }
    }

    public String toString()
    {
        String result = "\0";
        result = nationName;
        for(int i = 0; i < tribes.size(); i++)
        {
            result = result + '\n' + tribes.get(i).toString();

        }
        result = result + '\n';
        return result;
    }
}
