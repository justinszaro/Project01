package Project01;

/**
 * Description
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 1.0
 * @since 2021-03-04
 */
public enum PeopleType
{
    warrior ("Solder"),
    wizzard  ("Tricky"),
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
