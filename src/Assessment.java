public class Assessment {
    private final AssessmentTypeEnum type;
    private final int weight;

    // Constructor
    public Assessment(AssessmentTypeEnum type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    /**
     * Retrieves the type of this assessment.
     *
     * @return the AssessmentTypeEnum representing the assessment type
     */
    public AssessmentTypeEnum getType() {
        return type;
    }

    /**
     * Retrieves the weight of this assessment.
     *
     * @return the weight of the assessment as an integer percentage
     */
    public int getWeight() {
        return weight;
    }
}
