package com.jas.kaur;

import java.sql.*;


public class Main {

    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/employees";
    static final String USER="root";
    static final String PASS="";

    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?user=root&password=");
            statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultSet=statement.executeQuery("Select * from employees");

           // ResultSetMetaData metadata=resultSet.getMetaData();
           // int num=metadata.getColumnCount();
            while (resultSet.next()) {
               System.out.println(resultSet.getString("firstName")+resultSet.getString("lastName"));
            }
        }
        catch (Exception e)
        {

        }





    }
}
