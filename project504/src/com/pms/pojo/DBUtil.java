package com.pms.pojo;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getDBConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
        }catch (SQLException sqe){
            System.out.println("Un");
        }
        return conn;
    }
    public static void disconnect(){
        try{
            getDBConnection().close();
        }catch(SQLException sqe){
            sqe.getMessage();
        }
    }
}