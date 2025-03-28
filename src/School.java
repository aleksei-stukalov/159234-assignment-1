import java.util.ArrayList;

public class School {
    private String name;

    private ArrayList<Major> majors;
    private ArrayList<Paper> papers;
    private ArrayList<Offering> offerings;
    private ArrayList<Lecturer> lecturers;

    public School(
            String name,
            ArrayList<Major> majors,
            ArrayList<Paper> papers,
            ArrayList<Offering> offerings,
            ArrayList<Lecturer> lecturers) {
        this.name = name;
        this.majors = majors;
        this.papers = papers;
        this.offerings = offerings;
        this.lecturers = lecturers;
    }
}
