package Project01;

/**
 * This class sets the description for an instantiated Person in the People class based on its type.
 * The class also includes the getter for a Person's description.
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 2.0
 * @since 2021-03-04
 */
public enum PeopleType
{
    warrior ("Solder"),
    wizard("Tricky"),
    cleric  ("Healer");


    private String description;

    /**
     *Sets the description of the Person to its type.
     * @param types The type of Person.
     */
    PeopleType (String types)
    {
        description = types;
    }

    /**
     * Returns the Players established description.
     * @return description
     */
    public String getDescription()
    {
        return description;
    }
}
