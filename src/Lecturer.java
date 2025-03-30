import java.util.ArrayList;

public class Lecturer {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final CampusEnum campus;
    private final ArrayList<Offering> offerings;

    // Constructor
    public Lecturer(
            int id,
            String firstName,
            String lastName,
            CampusEnum campus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.campus = campus;
        offerings = new ArrayList<>();
    }

    /**
     * Adds an Offering to the lecturer's list of offerings.
     *
     * @param offering the Offering object to be added
     */
    public void addOffering(Offering offering) {
        offerings.add(offering);
    }

    /**
     * Retrieves the unique identifier of this lecturer.
     *
     * @return the lecturer's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the full name of this lecturer.
     *
     * @return a String representing the lecturer's full name (first name and last name)
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Retrieves all offerings associated with this lecturer.
     *
     * @return an ArrayList of Offering objects assigned to this lecturer
     */
    public ArrayList<Offering> getAllOfferings() {
        return offerings;
    }

    /**
     * Retrieves the campus value of this lecturer as a String.
     *
     * @return the campus name (e.g., "Auckland" or "PN") as defined by the CampusEnum
     */
    public String getCampus() {
        return campus.getValue();
    }
}
