import java.util.ArrayList;

public class School {
    private final String name;
    private final ArrayList<Major> majors;
    private final ArrayList<Paper> papers;
    private final ArrayList<Offering> offerings;
    private final ArrayList<Lecturer> lecturers;

    // Constructor
    public School(String name) {
        this.name = name;
        majors = new ArrayList<>();
        papers = new ArrayList<>();
        offerings = new ArrayList<>();
        lecturers = new ArrayList<>();
    }

    /**
     * Adds a new Major to the school.
     *
     * @param code The code of the major (e.g., "CS").
     * @param name The full name of the major.
     */
    public void addMajor(String code, String name) {
        majors.add(new Major(code, name));
    }

    /**
     * Adds a new Paper along with its assessments and associated majors.
     * Also creates three default offerings (Distance, Internal Auckland,
     * Internal PN) for the paper.
     *
     * @param code        The paper code.
     * @param name        The paper name.
     * @param majorCodes  A list of major codes that this paper belongs to.
     * @param assessments A list of Assessment objects for the paper.
     */
    public void addPaper(
            int code,
            String name,
            ArrayList<String> majorCodes,
            ArrayList<Assessment> assessments) {
        // We want each of Paper instance to have a reference to Major instance.
        // We also want each of Major instances to keep track of all the Paper
        // instances that it is referenced to.
        Paper paper = new Paper(code, name);

        // Adding assessments to Paper instance
        assessments.forEach(paper::addAssessment);

        // Adding majors to Paper instance
        majorCodes.forEach(majorCode -> {
            Major major = getMajorByCode(majorCode); // Getting the instance
            major.addPaper(paper); // Adding the reference to the paper on major
            paper.addMajor(major); // Adding it to the later argument
        });

        // Each paper always offered in three modes, so we can just create these
        // three modes right here, and add them to the pull of offerings in the
        // school. Later we would need to assign a Lecturer to each offering.
        offerings.add(new Offering(
                OfferingTypeEnum.DISTANCE,
                paper));
        offerings.add(new Offering(
                OfferingTypeEnum.INTERNAL_AUCKLAND,
                paper));
        offerings.add(new Offering(
                OfferingTypeEnum.INTERNAL_PN,
                paper));

        // Let's just wrap it up, shall we?
        papers.add(paper);
    }

    /**
     * Adds a new Lecturer to the school.
     * The lecturer is created using the provided id, first name, last name, and
     * campus, then added to the school's list of lecturers.
     *
     * @param id        the lecturer's unique identifier
     * @param firstName the lecturer's first name
     * @param lastName  the lecturer's last name
     * @param campus    the campus of the lecturer, represented as a CampusEnum value
     */
    public void addLecturer(
            int id,
            String firstName,
            String lastName,
            CampusEnum campus) {
        lecturers.add(new Lecturer(id, firstName, lastName, campus));
    }

    /**
     * Returns the name of the school.
     *
     * @return the school's name
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the list of all papers in the school.
     *
     * @return an ArrayList of Paper objects
     */
    public ArrayList<Paper> getAllPapers() {
        return papers;
    }

    /**
     * Retrieves the list of all offerings in the school.
     *
     * @return an ArrayList of Offering objects
     */
    public ArrayList<Offering> getAllOfferings() {
        return offerings;
    }

    /**
     * Retrieves the list of all lecturers in the school.
     *
     * @return an ArrayList of Lecturer objects
     */
    public ArrayList<Lecturer> getAllLecturers() {
        return lecturers;
    }

    /**
     * Finds and returns a Lecturer by their unique id.
     * This method iterates through the list of lecturers and returns the first
     * lecturer whose id matches the specified value.
     *
     * @param id the unique identifier of the lecturer
     * @return the Lecturer with the specified id, or null if no match is found
     */
    public Lecturer getLecturerById(int id) {
        for (Lecturer lecturer : lecturers)
            if (lecturer.getId() == id)
                return lecturer;

        return null;
    }

    /**
     * Finds and returns a Major by its code.
     * This method iterates through the list of majors and returns the first
     * major whose code matches the specified value.
     *
     * @param code the code of the major to search for (e.g., "CS")
     * @return the Major with the specified code, or null if no match is found
     */
    public Major getMajorByCode(String code) {
        for (Major major : majors)
            if (major.getCode().equals(code)) return major;

        return null;
    }
}
