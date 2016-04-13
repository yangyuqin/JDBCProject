package com.yyq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by gao on 16-4-12.
 */
public class DoInsert {
    private String dirver = "com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/test";
    private String user="root";
    private String password="123456";

    public boolean addStudent(Student stu){
        Connection conn=null;
        Statement st=null;
        String sql="INSERT INTO student(name,class,score) values('"+stu.getName()+"'," +
                "'"+stu.getMyClass()+"',"+stu.getScore()+")";
        boolean flag=false;
        try {
            Class.forName(dirver);
            conn= DriverManager.getConnection(url, user, password);
            st=conn.createStatement();
            int i=st.executeUpdate(sql);
            if(i==1){
                flag=true;
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DoInsert doinsert=new DoInsert();
        Student stu=new Student();
        stu.setName("xiaoming");
        stu.setMyClass("java");
        stu.setScore(98.00);
        boolean flag=doinsert.addStudent(stu);
        if(flag){
            System.out.println("成功插入一条数据!");
        }else{
            System.out.println("插入数据失败!");
        }
    }
    
}
