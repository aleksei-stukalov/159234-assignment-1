public class Offering {
    private final OfferingTypeEnum type;
    private final Paper paper;
    private Lecturer lecturer;

    // Construction
    public Offering(OfferingTypeEnum type, Paper paper) {
        this.type = type;
        this.paper = paper;
    }

    /**
     * Assigns a Lecturer to this offering.
     *
     * @param lecturer the Lecturer who will deliver this offering
     */
    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    /**
     * Retrieves the offering type as an OfferingTypeEnum.
     *
     * @return the OfferingTypeEnum representing the type of this offering
     */
    public OfferingTypeEnum getTypeEnum() {
        return type;
    }

    /**
     * Retrieves the offering type as a formatted String.
     *
     * @return the String value of the offering type
     */
    public String getType() {
        return type.getValue();
    }

    /**
     * Retrieves the paper associated with this offering.
     *
     * @return the Paper object linked to this offering
     */
    public Paper getPaper() {
        return paper;
    }

    /**
     * Retrieves the lecturer assigned to this offering.
     *
     * @return the Lecturer assigned to this offering, or null if no lecturer
     * has been assigned
     */
    public Lecturer getLecturer() {
        return lecturer;
    }
}
