/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.*;
import java.util.*;
import util.OracleConnection;

/**
 *
 * @author jqu
 */
public class Student implements Serializable {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dname;
    
    Connection conn = null;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
    
    public String toString(){
        return "Student :"+email+" "+firstName+" "+lastName;
    }
    public void createStudent(int id, String firstName, String lastName, String email, String phone, String dName){
        try{
            conn = OracleConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO STUDENT values(?, ?, ?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, dName);
            ps.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            OracleConnection.closeConnection();
        }
    }
    
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<Student>();
        try{
            conn = OracleConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from student";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Student stu = new Student();
                stu.setFirstName(rs.getString("firstName")); //firstname
                stu.setLastName(rs.getString(3)); //lastname
                stu.setEmail(rs.getString(4)); //email
                stu.setPhone(rs.getString(5)); //phone
                students.add(stu);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            OracleConnection.closeConnection();
        }
        
        return students;
    }
    
    public boolean ValidateStudent(String email, String phone){
        boolean validated = false;
        try{
            conn = OracleConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM STUDENT WHERE Email = ? and phone = ?");
            ps.setString(1, email);
            ps.setString(2, phone);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){ //have correct combination of email and phone
                validated = true;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            OracleConnection.closeConnection();
        }
        return validated;
    }
    
    
    public static void main(String[] args){
        Student stu = new Student();
        List<Student> students = stu.getStudents();
        for(Student s : students){
            System.out.println(s.toString());
        }
        //test validate student method
       /* String email = "jd@clayton.edu";
        String phone = "1234567891";
        if(stu.ValidateStudent(email, phone)){
            System.out.println("Hi " + email + " Welcome to CSCI3310");
        }
        else{
            System.out.println("Hi " + email + " please register first");
        }
        */
       
       int id = 9100;
       String fName = "Jill";
       String lName = "Smith";
       String e = "js2@clayton.edu";
       String p = "1234567891";
       String dName = "Computer Science";
       
       
    }
}
