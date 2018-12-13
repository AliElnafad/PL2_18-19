package pl2project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Ali Abdulhady
 */
public class Lecturer extends SystemUser implements Serializable {

    /**
     *
     * @author pc
     */
    public static ArrayList<Lecturer> lecturers = new ArrayList<>();
    static ArrayList<String> teached_subjects = new ArrayList<>();
//    public static ArrayList<student>reports = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, Integer> student_degrees = new HashMap<>();

    Scanner sc = new Scanner(System.in);
    BinaryManager fmanager=new BinaryManager();

    public static ArrayList<String> getTeached_subjects() {
        return teached_subjects;
    }

    public static void setTeached_subjects(ArrayList<String> teached_subjects) {
        Lecturer.teached_subjects = teached_subjects;
    }
    private final String lecturerFileName = "lecturer.txt";
    private final String reportsfilename = "reports.txt";

    public Lecturer() {
    }

    public Lecturer(int id, String email, String username, String password, String fname, String lname) {
        super(id, email, username, password, fname, lname);

    }

    public boolean addlecturer() {
        loadAUX();
        lecturers.add(this);
        return updateAUX();
    }

    @Override
    public String toString() {
        return "First name: " + FName + " Last name: " + Lname + " ID : " + ID + " UserName: " + UserName + " Password: " + PassWord;

    }

    //AUX FUNCTIONS SECTION//
    //WE USE IT IN OTHER FUNCTIONS AND DONT MAKE BODY OF FUNCTION SO BIG//
    private void loadAUX() {
        lecturers = (ArrayList<Lecturer>) fmanager.read(lecturerFileName);
//        Student s = (Student) lecturers.get(10);
    }

    private int getterAUX(int id) {
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getID() == id) {
                return i;

            }
        }
        return 0;
    }

    private boolean updateAUX() {
        return fmanager.write(lecturerFileName, lecturers);
    }

    private String getDataAUX() {
        return this.ID + "~~" + this.FName + "~~" + this.Lname + "~~" + this.UserName + "~~" + this.PassWord + "~~" + Lecturer.teached_subjects + "~~";

    }

    private Student write_reports_Aux(Student x) {
        map.put(x.id, x.degree);

        for (int i = 0; i < x.reports.length; i++) {
            System.out.print("Enter The Report Please : " + (i + 1) + " : ");
            x.reports[i] = sc.nextLine();
        }
        return x;

    }

    //END OF AUX FUNCTIONS SECTION//
    public String searchlecturer(int id){
        loadAUX();
        int index=getterAUX(id);
        if(index>0)
            return "found!!"+lecturers.get(index).toString();
        else 
            return "not found";
        
        
    }
    public String list_lecturerdata() {
        loadAUX();
        String x = "\n";
        for (Lecturer z : lecturers) {
            x = x + z.toString();
        }
        return x;
    }

    public boolean update_lecturerdata(int oid, Lecturer l) {
        loadAUX();
        int ind = getterAUX(oid);
        if (ind >= 0) {
            lecturers.set(ind, l);
            updateAUX();
            return true;
        }
        return false;
    }

    public boolean delete_lecturerdata(int id) {
        loadAUX();
        int ind = getterAUX(id);
        lecturers.remove(ind);
        updateAUX();
        return true;
    }

    public void addexam(subject x) {
        x.addexam();
    }

    /*void student_reports()
    {
        
    }*/
    public void delete_exam(int id, exam l) {
        l.delete_exam();
    }

    public void update_exam(exam l) {
        l.update_exam();
    }

    public void list_exams(exam l) {
        l.list_exams();
    }

    /* public void Assign_studnet_degree(student x , subject y )
    {
        
     
    }
     */
   
}
