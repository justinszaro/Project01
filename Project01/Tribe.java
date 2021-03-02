package Project01;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import Project01.People;
import Project01.PeopleType;

public class Tribe
{
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();
/**
 * Tribe function is called in Nation passing 
 * @param nation - String of the Nation name 
 * @param tribe - String of Tribe's index (0-2)
 * @param lifePoints - Int of the lifepoints - should be 500 be default 
 * A loop is called three times and at each call, a different character (warrior,wizzard, cleric)
 * is added to the tribe's members ArrayList along with their lifepoints of 500/3
 * All memebers in the Arraylist are added to the living people list 
 */
    public Tribe(String nation, String tribe, int lifePoints)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        for(int i = 0; i < 3; i++) {
            if (i == 0) {
                members.add(new People(nationName, tribeName, PeopleType.warrior, (tribeLifePoints / 3)));
            }
            else if (i == 1) {
                members.add(new People(nationName, tribeName, PeopleType.wizzard, tribeLifePoints / 3));
            }
            else {
                members.add(new People(nationName, tribeName, PeopleType.cleric, tribeLifePoints / 3));
            }
        }
        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }
    /**
     * This checks the Tribe members that are alive. 
     * The list is cleared and restarted as well as the Tribe's life points 
     * By loop through, the size of the member list times, check to see if 
     * the memeber list as an alive member at the position of person. 
     * If that person is alive, add them to the livingMembers list and the tribe's 
     * lifepoints have that member's lifeponts added to it. 
     * @return the final list of living members 
     */
    public ArrayList<People> getLivingTribeMembers()
    {
        livingMembers.clear();
        tribeLifePoints = 0;
        for(int person = 0; person < members.size(); person++)
        {
            if(members.get(person).isPersonAlive())
            {
                livingMembers.add(members.get(person));
                tribeLifePoints += members.get(person).getLifePoints();
            }
        }
        return livingMembers;
    }
/**
 * Print all the memebrs in the member list
 */
    public void printMembers()
    {
        for(int i = 0; i < 2; i++)
        {
            System.out.println(members.get(i));
        }
    }
/**
 * 
 * @return the size of the living member list (how many living members there are)
 */
    public int getTribeSize()
    {
        return livingMembers.size();
    }
/**
 * 
 * @return if there is at least 1 tibelifepoint return true
 */
    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }
/**
 * 
 * @return the final number of the Tribe's life points 
 */
    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }
/**
 * 
 * @return the name of the tribe
 */
    public String getTribeName()
    {
        return tribeName;
    }

    public String toString()
    {
        String result = "\0";

        result = tribeName;
        for(int i = 0; i < members.size(); i++)
        {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

}
