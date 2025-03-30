import java.util.ArrayList;

public class Paper {
    private final int code;
    private final String name;
    private final ArrayList<Major> majors;
    private final ArrayList<Assessment> assessments;

    // Constructor
    public Paper(int code, String name) {
        this.code = code;
        this.name = name;
        majors = new ArrayList<>();
        assessments = new ArrayList<>();
    }

    /**
     * Adds a Major to the list of majors associated with this paper.
     *
     * @param major the Major object to add
     */
    public void addMajor(Major major) {
        majors.add(major);
    }

    /**
     * Adds an Assessment to the list of assessments for this paper.
     *
     * @param assessment the Assessment object to add
     */
    public void addAssessment(Assessment assessment) {
        assessments.add(assessment);
    }

    /**
     * Retrieves the unique code of this paper.
     *
     * @return the paper code
     */
    public int getCode() {
        return code;
    }

    /**
     * Retrieves the name of this paper.
     *
     * @return the paper name
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the list of majors associated with this paper.
     *
     * @return an ArrayList of Major objects linked to this paper
     */
    public ArrayList<Major> getMajors() {
        return majors;
    }

    /**
     * Retrieves the Assessment associated with the specified assessment type.
     *
     * @param type the assessment type to search for (e.g., ASSIGNMENT, TEST,
     *             EXAM)
     * @return the Assessment with the matching type, or null if no such
     * assessment is found
     */
    public Assessment getAssessmentByType(AssessmentTypeEnum type) {
        for (Assessment assessment : assessments)
            if (assessment.getType() == type) return assessment;

        return null;
    }

    /**
     * Checks whether this paper contains an assessment of the specified type.
     *
     * @param assessmentType the assessment type to check for
     * @return true if an assessment of the specified type exists, false
     * otherwise
     */
    public boolean containsAssessmentType(AssessmentTypeEnum assessmentType) {
        for (Assessment assessment : assessments)
            if (assessment.getType().equals(assessmentType)) return true;

        return false;
    }
}
