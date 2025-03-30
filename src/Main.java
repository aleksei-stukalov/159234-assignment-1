// Aleksei Stukalov
// 25016435
// https://github.com/aleksei-stukalov/159234-assignment-1

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /**
     * Displays the general assignment information including student details
     * and major.
     */
    private static void displayInfo() {
        System.out.println("**************************************");
        System.out.println("Assignment 1, 159.234 Semester 1 2025");
        System.out.println("Submitted by: Aleksei Stukalov, ID: 25016435");
        System.out.println("My Major at Massey: Software Engineering");
        System.out.println("**************************************");
    }

    /**
     * Displays a formatted heading by printing the specified heading text
     * wrapped with dashes.
     *
     * @param heading the heading text to be displayed
     */
    private static void displayHeading(String heading) {
        System.out.printf(
                "\n%s %s %s%n",
                "-".repeat(20),
                heading,
                "-".repeat(20));
    }

    /**
     * Constructs a formatted string listing details for each paper in the
     * provided list.
     *
     * @param papers an ArrayList of Paper objects to be listed
     * @return a String containing the formatted details of each paper
     */
    private static String listPapersWithMajors(ArrayList<Paper> papers) {
        // IntelliJ said to use StringBuilder if I want to build Strings. done
        StringBuilder output = new StringBuilder();

        for (Paper paper : papers) {
            String paperCode = String.valueOf(paper.getCode());
            String paperName = paper.getName();
            String paperMajors = paper.getMajors()
                    .stream()
                    .map(Major::getCode)
                    .collect(Collectors.joining(", "));

            output.append(String.format(
                    "%s %s (%s)\n",
                    paperCode,
                    paperName,
                    paperMajors));
        }

        return output.toString();
    }

    /**
     * Constructs a formatted string listing basic details for each paper in the
     * provided list.
     *
     * @param papers an ArrayList of Paper objects to be listed
     * @return a String containing the formatted details of each paper
     */
    private static String listPapers(ArrayList<Paper> papers) {
        StringBuilder output = new StringBuilder();

        for (Paper paper : papers) {
            String paperCode = String.valueOf(paper.getCode());
            String paperName = paper.getName();

            output.append(String.format(
                    "Paper - %s %s\n",
                    paperCode,
                    paperName));
        }

        return output.toString();
    }

    /**
     * Constructs a formatted string listing basic details for each paper in the
     * provided list.
     *
     * @param offerings an ArrayList of Offering objects to be listed
     * @return a String containing the formatted details for each offering
     */
    private static String listOfferings(ArrayList<Offering> offerings) {
        StringBuilder output = new StringBuilder();

        // Let's do a cool thing and find a proper fixed width of the offering
        // type column. We can do it by going through all the available enum
        // values for offering type and finding the one with the most
        // characters, then adding empty spaces to the remaining ones.
        int width = 0;
        for (OfferingTypeEnum thing : OfferingTypeEnum.values())
            if (thing.getValue().length() > width)
                width = thing.getValue().length();

        for (Offering offering : offerings) {
            String paperCode = String.valueOf(offering.getPaper().getCode());
            String offeringType = offering.getType();
            String lecturerName = offering.getLecturer().getFullName();

            output.append(String.format(
                    "%s %s  %s\n",
                    paperCode,
                    offeringType + " ".repeat(width - offeringType.length()),
                    lecturerName));
        }

        return output.toString();
    }

    /**
     * Constructs a formatted string listing details for each lecturer's
     * offering.
     *
     * @param offerings an ArrayList of Offering objects to be listed
     * @return a String containing the formatted details of each lecturer
     * offering
     */
    private static String listLecturerOfferings(ArrayList<Offering> offerings) {
        StringBuilder output = new StringBuilder();
        for (Offering offering : offerings) {
            String paperCode = String.valueOf(offering.getPaper().getCode());
            String offeringType = offering.getType();
            String lecturerName = offering.getLecturer().getFullName();

            output.append(String.format(
                    "Paper Offering -  %s  %s  Lecturer: %s\n",
                    paperCode,
                    offeringType,
                    lecturerName));
        }

        return output.toString();
    }

    public static void main(String[] args) {
        // Let's insert some data
        School school = new School(
                "School of Mathematical and Computational Sciences");
        // Majors
        school.addMajor("CS", "Computer Science");
        school.addMajor("IT", "Information Technology");
        school.addMajor("IS", "Information Systems");
        school.addMajor("SE", "Software Engineering");
        school.addMajor("DS", "Data Science");
        // Papers
        school.addPaper(
                158100,
                "Information Technology Principles",
                new ArrayList<>(Arrays.asList("IT", "IS")),
                new ArrayList<>(Arrays.asList(
                        new Assessment(AssessmentTypeEnum.ASSIGNMENT, 70),
                        new Assessment(AssessmentTypeEnum.TEST, 30))));
        school.addPaper(
                158120,
                "Web-based IT Fundamentals",
                new ArrayList<>(Arrays.asList("IT", "IS")),
                new ArrayList<>(Arrays.asList(
                        new Assessment(AssessmentTypeEnum.ASSIGNMENT, 60),
                        new Assessment(AssessmentTypeEnum.TEST, 40))));
        school.addPaper(
                159101,
                "Applied Programming",
                new ArrayList<>(Arrays.asList(
                        "IT",
                        "IS",
                        "CS",
                        "DS",
                        "SE")),
                new ArrayList<>(Arrays.asList(
                        new Assessment(AssessmentTypeEnum.ASSIGNMENT, 50),
                        new Assessment(AssessmentTypeEnum.TEST, 50))));
        school.addPaper(
                159201,
                "Algorithms and Data Structures",
                new ArrayList<>(Arrays.asList("IS", "CS", "DS", "SE")),
                new ArrayList<>(Arrays.asList(
                        new Assessment(AssessmentTypeEnum.ASSIGNMENT, 40),
                        new Assessment(AssessmentTypeEnum.TEST, 20),
                        new Assessment(AssessmentTypeEnum.EXAM, 40))));
        school.addPaper(
                159234,
                "Object-Oriented Programming",
                new ArrayList<>(Arrays.asList("CS", "SE")),
                new ArrayList<>(Arrays.asList(
                        new Assessment(AssessmentTypeEnum.ASSIGNMENT, 50),
                        new Assessment(AssessmentTypeEnum.TEST, 10),
                        new Assessment(AssessmentTypeEnum.EXAM, 40))));
        school.addPaper(
                158337,
                "Database Development",
                new ArrayList<>(Arrays.asList("IT", "DS", "SE")),
                new ArrayList<>(Arrays.asList(
                        new Assessment(AssessmentTypeEnum.ASSIGNMENT, 60),
                        new Assessment(AssessmentTypeEnum.EXAM, 40))));
        school.addPaper(
                158345,
                "Professionalism in the Information Sciences",
                new ArrayList<>(Arrays.asList(
                        "IT",
                        "IS",
                        "CS",
                        "DS",
                        "SE")),
                new ArrayList<>(List.of(
                        new Assessment(AssessmentTypeEnum.ASSIGNMENT, 100))));
        // Lecturers
        school.addLecturer(1105236, "Amy", "Sheffield", CampusEnum.PN);
        school.addLecturer(1235894, "Victoria", "Jensen", CampusEnum.PN);
        school.addLecturer(7225669, "James", "Lee", CampusEnum.PN);
        school.addLecturer(1328991, "Colin", "Delmont", CampusEnum.PN);
        school.addLecturer(1562347, "Thomas", "Becker", CampusEnum.AUCKLAND);
        school.addLecturer(5664789, "Steven", "Hobbs", CampusEnum.AUCKLAND);
        school.addLecturer(3658947, "Andrew", "Jackson", CampusEnum.AUCKLAND);
        school.addLecturer(6332698, "Jonathon", "Wood", CampusEnum.AUCKLAND);
        school.addLecturer(25016435, "Aleksei", "Stukalov", CampusEnum.AUCKLAND);

        // Declaring it here, so dont have to over declare it.
        Random random = new Random();

        // Logic for assigning Lecturer to aech Offering
        school.getAllOfferings().forEach(offering -> {
            // Look, this one I am proud of. It's a pretty clean code, that
            // took me an hour or so to finish, it's almost a midnight, and I am
            // very tired, but let me walk you through on what's going on here.
            // The thought process is as follows - at the beginning of this
            // function we want to pull all the lecturers from the school that
            // still able to take papers (maximum each lecturer can teach is 4).
            ArrayList<Lecturer> lecturers = school.getAllLecturers()
                    .stream()
                    .filter(lecturer -> lecturer.getAllOfferings().size() < 4)
                    .collect(Collectors.toCollection(ArrayList::new));
            // All the lecturers can take any distance paper, but in case the
            // current paper we looping through is not the distance - then we
            // want to further refine the lecturers list by campus. That's why
            // we're doing the reassigning here wrapped in an if statement.
            if (!offering.getTypeEnum().equals(OfferingTypeEnum.DISTANCE))
                lecturers = lecturers
                        .stream()
                        .filter(lecturer ->
                                lecturer.getCampus().equals(offering.getType()))
                        .collect(Collectors.toCollection(ArrayList::new));

            // From here on the list of lecturers is only consists of lecturers
            // that can take this particular paper, so by knowing the length of
            // the list, we can generate a random number between 0 and max
            // index of the list.
            Lecturer lecturer = lecturers.get(random.nextInt(lecturers.size()));
            // Now that we have found our lecturer we just want to let the class
            // know that it now has one more offering, and the offering now
            // knows that it has a lecturer.
            lecturer.addOffering(offering);
            offering.setLecturer(lecturer);
        });

        // Settings up values based on testing data, the idea is that we will
        // reassign the variable based on each task.
        ArrayList<Paper> papers;
        ArrayList<Offering> offerings;
        int lecturerId;
        int paperCode;

        // Outputting the data to the console
        displayInfo();

        // Task 1
        displayHeading("Task 1");
        System.out.println("School Full Name: " + school.getName());

        // Task 2
        displayHeading("Task 2");
        System.out.println("All papers details:");
        System.out.print(listPapersWithMajors(school.getAllPapers()));

        // Task 3
        Major major = school.getMajorByCode("SE");

        displayHeading("Task 3");
        System.out.printf("Papers that belong to Major %s:\n", major.getCode());
        System.out.print(listPapers(major.getAllPapers()));
        System.out.printf(
                "Total matching papers in specified Major - %s: %s\n",
                major.getCode(),
                major.getAllPapers().size());

        // Task 4
        papers = school.getAllPapers()
                .stream()
                .filter(paper ->
                        paper.containsAssessmentType(AssessmentTypeEnum.EXAM))
                .collect(Collectors.toCollection(ArrayList::new));

        displayHeading("Task 4");
        System.out.print("Papers that have exam:\n");
        System.out.print(listPapers(papers));
        System.out.printf(
                "Total number of papers that have exam: %s\n",
                papers.size());

        // Task 5
        int weight = 50;
        papers = school.getAllPapers()
                .stream()
                .filter(paper -> {
                    AssessmentTypeEnum type = AssessmentTypeEnum.ASSIGNMENT;
                    return paper.containsAssessmentType(type);
                })
                .filter(paper -> {
                    AssessmentTypeEnum type = AssessmentTypeEnum.ASSIGNMENT;
                    return paper.getAssessmentByType(type).getWeight() > weight;
                })
                .collect(Collectors.toCollection(ArrayList::new));

        displayHeading("Task 5");
        System.out.printf(
                "Papers that their assignments weight higher than %s%%:\n",
                weight);
        System.out.print(listPapers(papers));
        System.out.printf(
                "Total number of papers that have assignments weighting more " +
                        "than %s%%: %s\n",
                weight,
                papers.size());

        // Task 6
        displayHeading("Task 6");
        System.out.println("Paper offering details:");
        System.out.print(listOfferings(school.getAllOfferings()));

        // Task 7
        lecturerId = 25016435;
        offerings = school.getLecturerById(lecturerId).getAllOfferings();

        displayHeading("Task 7");
        if (!offerings.isEmpty())
            System.out.println("The paper offerings that I teach:");
        System.out.print(listLecturerOfferings(offerings));
        System.out.printf(
                "I am teaching %s paper%s\n",
                offerings.size(),
                offerings.size() == 1 ? "" : "s");

        // Task 8
        paperCode = 159234;
        Offering filteredOffering = school.getAllOfferings()
                .stream()
                .filter(offering ->
                        offering.getPaper().getCode() == paperCode)
                .filter(offering ->
                        offering.getType().equals(
                                school.getLecturerById(lecturerId).getCampus()))
                .findFirst()
                .orElse(null);

        displayHeading("Task 8");
        if (filteredOffering != null) {
            // Java compiler was complaining, and I could not sort it out, so
            // here we are with this wrapper.
            Lecturer lecturer = filteredOffering.getLecturer();
            System.out.printf(
                    "The lecturer of Auckland offering of %s:\n",
                    paperCode);
            System.out.printf("Lecturer's Name: %s\n", lecturer.getFullName());
            System.out.printf(
                    "This lecturer is teaching %s paper%s\n",
                    lecturer.getAllOfferings().size(),
                    lecturer.getAllOfferings().size() == 1 ? "" : "s");
        }
    }
}
