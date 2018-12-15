package pl2project;

import java.io.*;
import java.util.*;

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
    private static ArrayList<Subject> teachedSubjects = new ArrayList<>();
//    public static ArrayList<student>reports = new ArrayList<>();
    HashMap<Integer, Double> map = new HashMap<>();
    HashMap<Integer, Integer> student_degrees = new HashMap<>();

    Scanner sc = new Scanner(System.in);
    BinaryManager fmanager=new BinaryManager();

//    public static ArrayList<String> getTeached_subjects() {
//        return teached_subjects;
//    }
//
//    public static void setTeached_subjects(Lecturer) {
//        Lecturer.teached_subjects.add(e)
 
//    }
    private final String lecturerFileName = "lecturer.bin";
    private final String reportsfilename = "reports.bin";
    private final String subjectsFileName="teachedSubjects.bin";

    public Lecturer() {
    }

    public Lecturer(int id, String email, String username, String password, String fname, String lname) {
        super(id, email, username, password, fname, lname);

    }
    @Override
    public Lecturer login(String username,String password){
        loadAUX();
        for(Lecturer x:lecturers){
            if(username.equals(x.UserName)&&password.equals(x.PassWord))
                    return x;
                }
        return null;
    }

        private void loadSubjects(){
           teachedSubjects=(ArrayList < Subject >)fmanager.read(subjectsFileName);
        }
        private boolean updateSubjects(){
            return fmanager.write(subjectsFileName,teachedSubjects);
        }
        
           public  boolean SetTeachedSubjects(Subject e) {
        loadSubjects();
        teachedSubjects.add(e);
        return updateSubjects();
        
        
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
        return this.ID + "~~" + this.FName + "~~" + this.Lname + "~~" + this.UserName + "~~" + this.PassWord + "~~" + Lecturer.teachedSubjects + "~~";

    }

    private Student write_reports_Aux(Student x) {
        map.put(x.ID, x.getDegree());

        for (int i = 0; i < x.reports.length; i++) {
            System.out.print("Enter The Report Please : " + (i + 1) + " : ");
            x.reports[i] = sc.nextLine();
        }
        return x;

    }

    //END OF AUX FUNCTIONS SECTION//
    public boolean searchlecturer(int id){
        loadAUX();
        int index=getterAUX(id);
        return (index>0);
        
        
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

    public void addexam(Subject x) {
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
