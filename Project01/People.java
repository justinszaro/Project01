package Project01;

import Project01.PeopleType;

public class People
{
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    private String myDescription;
    private int myLifePoints;


    /**
     * Instantiates a new person.
     * The constructor makes a new person and assigns their nation, tribe, PeopleType, and amount of lifepoints.
     * @param nation name of the nation
     * @param tribe name of the tribe
     * @param person type of created person
     * @param lifePoints total lifepoints of person
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
    }

    /**
     * Returns a persons PeopleType
     * @return me Returns PeopleType of person
     */
    public PeopleType getType()
    {
        return me;
    }

    /**
     * Returns a person's Tribe
     * @return myTribe Returns the Person's Tribe
     */
    public String getTribe()
    {
        return myTribe;
    }

    /**
     * Returns a persons Nation
     * @return myNation Returns Person's nation
     */
    public String getNation()
    {
        return myNation;
    }

    /**
     * Determines whether or not a person is alive
     * @return bool Returns true if lifeppints are greater than 0, if =< 0, returns false
     */
    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    /**
     * Returns the current lifepoints of the Person
     * @return  myLifePoints Returns lifepoints of Person.
     */
    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * Currently not Used.
     * @param otherPerson Other Person who is involved in the encounter
     */
    public void encounterStrategy(People otherPerson)
    {
        if(myNation != otherPerson.getNation())
        {
            // There will be an ugly confrontation
            // Groups attack groups. Group can be an individual or several individuals from any set of tribes
            // if a group has enough lifePoints it can capture its opponent and make it part of the group.
            // Captured opponents do not fight or heal very well. The healers can heal people from same nation
            // normally.
        }
        else
        {
            // there will be a peaceful confrontation
            // warriors - warrior ignore each other if different tribes increase life points
            // healer - healer ignore each other
            // healer - warrior - healer can heal warrior. Heals warrior from same tribe better
        }
    }


    /**
     * Reduces the Person's Lifepoints by the parameter points.
     * @param points Number of points a Persons LifePoints should be reduced by.
     */
    public void reduceLifePoints(int points)
    {
        myLifePoints = myLifePoints - points;
    }


    /**
     * Returns the variable values for the Person.
     * @return result Returns a summary of a Person's characteristics.
     */
    public String toString()
    {
        String result = new String( myNation + "\t" +  myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints);
        return result;
    }
}

