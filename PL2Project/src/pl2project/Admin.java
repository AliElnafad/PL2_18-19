/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;

import java.io.Serializable;

/**
 *
 * @author Ali Abdulhady
 */
public class Admin extends SystemUser implements Serializable{
    
    
    
    @Override
    public String toString(){
        
     return "ADMIN's First name: " + FName +  " Last name: " +Lname + " ID : " 
             + ID + " UserName: " + UserName + " Password: " + PassWord ;

    }
    
//    *************************************************************************
    
    public Admin(){
        
    }
    public Admin(int id,String email,String username,String password,
            String fname,String lname){
        super(id,email,username,password,fname,lname);
    }
        public boolean login(String username,String password){
            if(username.equals("admin")&&password.equals("admin"))
                    return true;
            else 
                return false;
        }

//    **********************************************
//    public void add_studnet(int id,String email,String username,String password,
//            String fname,String lname){
//       SystemUser x=new SystemUser(id,email,username,password,fname,lname);
//       if(x.addstudent())
//           System.out.println("A new Student has been added successfully,with"+
//                   x.toString());
//       else
//           System.out.println("failed to add");
//    }
//    ************************************************************************
    public void add_leturer(int id,String email,String username,String password,
            String fname,String lname){
        Lecturer x=new Lecturer(id,email,username,password,fname,lname);
        if(x.addlecturer())
           System.out.println("A new Lecturer has been added successfully,with"+
                    x.toString());
        else
            System.out.println("Failed to add");
    }
//    ************************************************************************
    public void update_lecturer(int oldL_id,Lecturer newLecturerdata){
        Lecturer x=new Lecturer();
        if(x.update_lecturerdata(oldL_id,newLecturerdata))
            System.out.println("The lecturer with this ID has been updated successfully");
        else
            System.out.println("Failed to updated");
    }
//    *****************************************************8
//    public void update_student(int oldS_id,Student newStudentdata){
//        Student x=new Student();
//        if(x.update_studnet())
//           System.out.println("The student with this ID has been changed"
//                   + " successfully");
//        else 
//            System.out.println("Failed to updated");
//    }
//    ********************************************************
    public void list_lecturers(){
         Lecturer x=new Lecturer();
         x.list_lecturerdata();
    }
//********************************************************
//    public void list_students(){
//         Student x=new Student();
//         x.list_students();
//}    
  public void search_lecturer(int ID){
      Lecturer x=new Lecturer();
      x.searchlecturer(ID);     
  }
//*********************************************************
//  public void search_srudent(int id){
//      Student x=new Student();
//      x.serach_student;
//  }
//  *******************************************
  public void delete_lecturer(int id){
      Lecturer x=new Lecturer();
      if(x.delete_lecturerdata(id))
          System.out.println("Delted successfully");
  }
//  ********************************
//  public void delete_student(int id){
//      Student x=new Student();
//      if(x.deletestudent(id))
//          System.out.println("Deleted successfulllllyyyy!!");
//  }
    
      @Override
        public Admin login(String username,String password){
          for(Admin x:admins){
            if(username.equals(this.UserName)&&password.equals(this.PassWord))
                return this;
             }
           return null;
  
  
        }
}
