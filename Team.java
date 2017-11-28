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
 * @author Kenya
 */
public class Team implements Serializable{
    private int teamNumber;
     private int teamSize;
     private String mentorID;
     private String projectNumber;
     
     Connection conn = null;
     
     public int getTeamNumber(){
         return teamNumber;
     }
     public void setTeamNumber(int timeNumber){
         this.teamNumber = timeNumber;
     } 
     public int getTeamSize(){
         return teamSize;
     }
     
     public void setTeamSize(int teamSize){
         this.teamSize = teamSize;
     }
     
     public String getMentorID(){
         return mentorID;
     }
     
     public void setMentorID(String mentorID){
         this.mentorID = mentorID;
     }
     
     public String getProjectNumber(){
         return projectNumber;
     }
     
     public void setProjectNumber(String projectNumber){
         this.projectNumber = projectNumber;
     }
     
     public List<Team> getTeams(){
         List<Team> teams = new ArrayList<>();
         try{
             conn = OracleConnection.getConnection();
             Statement stmt = conn.createStatement();
             String sql = "SELECT * FROM GROUP_1";
             ResultSet rs = stmt.executeQuery(sql);
             while(rs.next()){
                 Team tm = new Team();
                 tm.setTeamNumber(rs.getInt(1));
                 tm.setTeamSize(rs.getInt(2));
                 tm.setMentorID(rs.getString(3));
                 tm.setProjectNumber(rs.getString(4));
                 teams.add(tm);
             }
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             OracleConnection.closeConnection();
         }
         return teams;
     }
     
     
}
