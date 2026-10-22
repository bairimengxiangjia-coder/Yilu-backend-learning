public class Student {
    private String studentID;
    private String name;
    private int score;
    private static int count;
    private static final String studio="一路工作室";
    public enum StudentStatus {
        STUDYING,
        GRADUATED
    }

    private StudentStatus status;

    public static String getStudio() {
        return studio;
    }
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public Student() {
        count++;
    }

    public Student(String studentID, String name, int score, StudentStatus status) {
        this.studentID = studentID;
        this.name = name;
        this.score = score;
        this.status = status;
        count++;
    }

}
