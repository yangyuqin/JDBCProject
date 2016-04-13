package com.yyq;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gao on 16-4-12.
 */
public class DoSelect {
    //step2:提供连接数据库所需的driver，url,user,password
    private String dirver = "com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/test";
    private String user="root";
    private String password="123456";

    public List<Student> findAll(){
        //声明一个局部的Connection对象
        Connection conn=null;
        //声明一个局部的Statement 对象
        Statement st=null;
        //声明一个ResultSet结果集对象
        ResultSet rs=null;
        //定义SQL语句
        String sql="select * from student";
        //保存返回结果
        List<Student> list=new ArrayList<Student>();
        try {
            //step1:加载数据库厂商提供的驱动JAR包
            Class.forName("com.mysql.jdbc.Driver");
            //step3:通过DriverManager获取一个数据库连接对象
            conn=DriverManager.getConnection(url, user, password);
            //step4:创建一个Statement对象
            st=conn.createStatement();
            //step5:执行sql语句
            rs=st.executeQuery(sql);
            //step6:处理结果集
            while(rs.next()){
                Student stu=new Student();
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setMyClass(rs.getString("class"));
                stu.setScore(rs.getDouble("score"));
                list.add(stu);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //step7:关闭连接数据库资源
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
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
        return list;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DoSelect select=new DoSelect();
        //调用查询的方法
        List<Student> list=select.findAll();
        for(Student stu:list){
            System.out.println("Id:"+stu.getId()+"\t姓名:"+stu.getName()+"\t班级:"+stu.getMyClass()+"\t分数:"+stu.getScore());
        }
    }
}
