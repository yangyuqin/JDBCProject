package com.yyq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Created by gao on 16-4-12.
 */
public class Transaction {
    public static final String Driver = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO student(name,score,class) values(?,null,null)";
        String sql2 = "delete from student where id = 69";
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"testing");
            System.out.println("第一条语句执行....");
            pstmt.executeUpdate();

//            pstmt = conn.prepareStatement(sql2);
//            System.out.println("第二条语句执行....");
//            pstmt.executeQuery();
            conn.commit();
            System.out.println("提交事务");
        }catch (ClassNotFoundException e){
            System.out.println("找不到驱动程序类");
            e.printStackTrace();
        }catch (SQLException e){
            try{
                conn.rollback();
                System.out.println("回退事务....");
                e.printStackTrace();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }finally {
            try{
                conn.setAutoCommit(true);
            }catch (SQLException e){
                e.printStackTrace();
            }
            if (null != pstmt){
                try{
                    pstmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (null != conn){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

