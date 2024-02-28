public class TestCopyConstuctor {
    public static void main(String[] args) {
        Student s1 = new Student(1, "John");
        s1.grades.add(100);
        s1.grades.add(99);
        s1.getGrades().remove(0);
        System.out.println(s1);
        /*Student s2 = new Student(s1);
        System.out.println(s2);
        */
    }
}
