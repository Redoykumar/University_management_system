package university_management_system;

import AdminDashboard.Student;
import AdminDashboard.Teacher;
import Student.Course;
import Student.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static university_management_system.FXMLDocumentController.user;

public class DatabaseConnection {

   public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ums", "root", "");
        return con;
    }

    String Vlogin(String u, String p) throws SQLException {

        Connection con = getConnection();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("select * from login where admin ='" + u + "' or s_id ='" + u + "' or f_id = '" + u + "'");

        String admin = "";
        String s_id = "";
        String f_id = "";
        String pass = "";

        while (rs.next()) {
            admin = rs.getString("admin");
            s_id = rs.getString("s_id");
            f_id = rs.getString("f_id");
            pass = rs.getString("pass");
        }
        if (u.equals(admin) && p.equals(pass)) {

            return "admin";

        } else if (u.equals(s_id) && p.equals(pass)) {

            return "student";
        } else if (u.equals(f_id) && p.equals(pass)) {

            return "faculty";
        } else {
            return "";
        }

    }

    public String st() throws SQLException {
        String num = null;
        Connection con = getConnection();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT count(*) as c from student");
        while (rs.next()) {
            num = rs.getString("c");
        }
        System.out.println(num);
        return num;

    }

    public String tt() throws SQLException {
        String num = null;
        Connection con = getConnection();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT count(*) as c from faculty");
        while (rs.next()) {
            num = rs.getString("c");
        }

        return num;

    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ObservableList<Student> getStudent() throws SQLException {
        ObservableList<Student> std = FXCollections.observableArrayList();
        Connection con = getConnection();
        Statement st = con.createStatement();
        String query = "select * from Student";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {

            String S_id = rs.getString("S_id");
            String name = rs.getString("Name");
            String age = rs.getString("Age");
            String Email = rs.getString("Email");
            String Sex = rs.getString("sex");
            String Phone = rs.getString("phone");
            String Address = rs.getString("Address");
            String F_id = rs.getString("F_id");
            String D_ID = rs.getString("D_ID");
            Student s = new Student(S_id, name, Integer.parseInt(age), Email, Sex, Phone, Address, F_id,D_ID);
            std.add(s);
        }
        return std;
    }

   public  String insertStudent(Student st) throws SQLException {
        Connection con = getConnection();
        Statement stm = con.createStatement();
        String query = "insert into Student values('" + st.getS_id() + "','" + st.getName() + "','" + st.getAge() + "','" + st.getEmail() + "','" + st.getSex() + "','" + st.getPhone() + "','" + st.getAddress() + "','" + st.getF_id() + "','" + Integer.parseInt(st.getDepartment())+ "')";
        if (stm.executeUpdate(query) > 0) {
            return ("Add Student Succesfully");
        } else {
            return ("Faild");
        }
    }
   public String lastID() throws SQLException
   {
         Connection con = getConnection();
        Statement st = con.createStatement();
        String query = "select max(S_id) FROM student";
        ResultSet rs = st.executeQuery(query);
        String S_id =null;
         while (rs.next())
         {
            S_id = rs.getString("max(S_id)");
         }
       return S_id;
   }
   
   public Student Search(String S_id) throws SQLException
   {
       Connection con = getConnection();
        Statement st = con.createStatement();
        String query = "select * FROM student where S_id='"+S_id+"'";
        ResultSet rs = st.executeQuery(query);
       
        Student s = new Student();
        while(rs.next())
        {
            String s_id = rs.getString("S_id");
            String name = rs.getString("Name");
            String age = rs.getString("Age");
            String Email = rs.getString("Email");
            String Sex = rs.getString("sex");
            String Phone = rs.getString("phone");
            String Address = rs.getString("Address");
            String F_id = rs.getString("F_id");
             String D_ID = rs.getString("D_ID");
            s = new Student(s_id, name, Integer.parseInt(age), Email, Sex, Phone, Address, F_id,D_ID);
        }
            
        
            return s;
       
   }
   
   public ObservableList<Teacher> getTeacher() throws SQLException {
        ObservableList<Teacher> teacher = FXCollections.observableArrayList();
        Connection con = getConnection();
        Statement st = con.createStatement();
        String query = "select * from faculty";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {

            String F_id = rs.getString("F_ID");
            String name = rs.getString("Name");
            String age = rs.getString("Age");
            String Email = rs.getString("Email");
            String Sex = rs.getString("sex");
            String Phone = rs.getString("Phone");
            String Address = rs.getString("Address");
            String Subject = rs.getString("Subject");
            Teacher t = new Teacher(F_id, name,Integer.parseInt(age),Email, Sex, Phone, Subject, Address);
            teacher.add(t);
        }
        return teacher;
    }
   
     public  String insertTeacher(Teacher st) throws SQLException {
        Connection con = getConnection();
        Statement stm = con.createStatement();
        String query = "insert into faculty values('" + st.getT_id() + "','" + st.getName() + "','" + st.getEmail() + "','" + st.getSex() + "','" + st.getPhone() + "','" + st.getSubject() + "','" + st.getAddress() + "','" + st.getAge() + "')";
        if (stm.executeUpdate(query) > 0) {
            return ("Add Teacher Succesfully");
        } else {
            return ("Faild");
        }
    }
   public String lastTID() throws SQLException
   {
         Connection con = getConnection();
        Statement st = con.createStatement();
        String query = "select max(F_id) FROM Faculty";
        ResultSet rs = st.executeQuery(query);
        String T_id =null;
         while (rs.next())
         {
            T_id = rs.getString("max(F_id)");
         }
       return T_id;
   }
   
    public Teacher TSearch(String T_id) throws SQLException
   {
       Connection con = getConnection();
        Statement st = con.createStatement();
        String query = "select * FROM Faculty where F_id='"+T_id+"'";
        ResultSet rs = st.executeQuery(query);
       
        Teacher s = new Teacher();
        while(rs.next())
        {
            String s_id = rs.getString("F_id");
            String name = rs.getString("Name");
            String age = rs.getString("Age");
            String Email = rs.getString("Email");
            String Sex = rs.getString("sex");
            String Phone = rs.getString("phone");
            String Address = rs.getString("Address");
            String Subject= rs.getString("Subject");
            s = new Teacher(s_id, name, Integer.parseInt(age), Email, Sex, Phone,Subject, Address);
        }
            
        
            return s;
       
   }
    
     public ObservableList<Course> getcourse() throws SQLException {
        ObservableList<Course> Course = FXCollections.observableArrayList();
        Connection con = getConnection();
        Statement st = con.createStatement();
        String query = "select * from Course where S_ID='"+user+"'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {

           
            String Course_ID = rs.getString("Course_ID");
            String Course_name = rs.getString("Course_name");
            String Duration = rs.getString("Duration");
            String Fee = rs.getString("Fee");
            Course t = new Course(Course_ID, Course_name,Duration,Fee);
            Course.add(t);
        }
        return Course;
    }
     
     public ObservableList<Result> getResult() throws SQLException {
        ObservableList<Result> Result = FXCollections.observableArrayList();
        Connection con = getConnection();
        Statement st = con.createStatement();
        String query = "select * from grade where S_ID='"+user+"'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {

           
            String Major = rs.getString("Major");
            String Mark = rs.getString("Mark");
            String Samister = rs.getString("Samister");
            String F_ID = rs.getString("F_ID");
            Result t = new Result(Major, Mark,Samister,F_ID);
            Result.add(t);
        }
        return Result;
    }
     
      public String Gread() throws SQLException {
        String num = null;
        Connection con = getConnection();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT count(*) as c from Grade");
        while (rs.next()) {
            num = rs.getString("c");
        }
        System.out.println(num);
        return num;

    }
      
      public String samister() throws SQLException {
        String num = null;
        Connection con = getConnection();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT count(*) as c from Course");
        while (rs.next()) {
            num = rs.getString("c");
        }
        System.out.println(num);
        return num;

    }
   
   
   

}
