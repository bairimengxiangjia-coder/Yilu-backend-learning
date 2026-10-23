public class Student_Test {
    public static void main(String[] args) {
        Student a = new Student("001", "张三", 80, Student.StudentStatus.STUDYING);
        show(a);

        Student b = new Student("002", "张四", 86, Student.StudentStatus.GRADUATED);
        show(b);

        Student c = new Student("003", "张五", 99, Student.StudentStatus.STUDYING);
        show(c);
        c.setScore(85);
        c.setStatus(Student.StudentStatus.GRADUATED);
        show(c);
    }

    public static void show(Student s) {
        System.out.println("学号:" + s.getStudentID()
                + " 姓名:" + s.getName()
                + " 分数:" + s.getScore()
                + " 状态:" + s.getStatus()
                + " 当前对象数量:" + Student.getCount()
                + " 工作室名称:" + Student.getStudio());
    }
}
