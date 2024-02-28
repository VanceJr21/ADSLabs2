import java.util.ArrayList;

public class Student {
    String fname;
    //static int counter; // static variable
    int sID;
    ArrayList<Integer> grades;

    public String getFname() {
        return fname;
    }

    public int getsID() {
        return sID;
    }

    public ArrayList<Integer> getGrades() {
        ArrayList gs = new ArrayList(this.grades);
        return gs;
    }

    public Student(){
        sID = 0;
        fname = " ";
        grades = new ArrayList<>();
    }

    public Student(int sID, String fname){
        this.fname = fname;
        this.sID = sID;
        this.grades = new ArrayList<>();
    }

    // copy constructor
    public Student(Student otherStudent){
        this.sID = otherStudent.sID;
        this.fname = otherStudent.fname;
        // Do not do it this way  --- EVER!
        //this.grades = otherStudent.grades;
        this.grades = new ArrayList<Integer>(otherStudent.grades);
    }

    public String toString(){
        String s = "Student id is: " + this.sID +
                " Student firstname: " + this.fname +
                " Student grades are: \n";
        for (int i = 0; i < grades.size(); i++){
            s += grades.get(i) + "\n";
        }
        return s;
    }
}
