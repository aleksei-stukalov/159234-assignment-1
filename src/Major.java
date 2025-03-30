import java.util.ArrayList;

public class Major {
    private final String code;
    private final String name;
    private final ArrayList<Paper> papers;

    // Constructor
    public Major(String code, String name) {
        this.code = code;
        this.name = name;
        papers = new ArrayList<>();
    }

    /**
     * Adds a Paper to the list of papers associated with this major.
     *
     * @param paper the Paper object to be added
     */
    public void addPaper(Paper paper) {
        papers.add(paper);
    }

    /**
     * Retrieves the unique code of this major.
     *
     * @return the code of the major
     */
    public String getCode() {
        return code;
    }

    /**
     * Retrieves the name of this major.
     *
     * @return the name of the major
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves all papers associated with this major.
     *
     * @return an ArrayList of Paper objects linked to this major
     */
    public ArrayList<Paper> getAllPapers() {
        return papers;
    }
}
