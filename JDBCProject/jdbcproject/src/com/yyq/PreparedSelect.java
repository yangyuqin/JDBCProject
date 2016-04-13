package com.yyq;

import java.sql.*;
/**
 * Created by gao on 16-4-12.
 */
public class PreparedSelect {
    //step2:提供连接数据库所需的driver，url,user,password
    private String dirver = "com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/test";
    private String user="root";
    private String password="123456";

    public Student findById(int id){
        //声明一个局部的Connection对象
        Connection conn=null;
        //声明一个局部的Statement 对象
        PreparedStatement pst=null;
        //声明一个ResultSet结果集对象
        ResultSet rs=null;
        //定义SQL语句
        String sql="select * from student where id=?";
        //保存返回结果
        Student stu = null;
        try {
            //step1:加载数据库厂商提供的驱动JAR包
            Class.forName(dirver);
            //step3:通过DriverManager获取一个数据库连接对象
            conn=DriverManager.getConnection(url, user, password);
            //step4:创建一个PreparedStatement对象
            pst=conn.prepareStatement(sql);
            pst.setInt(1, id);
            //step5:执行sql语句
            rs=pst.executeQuery();
            //step6:处理结果集
            if(rs.next()){
                stu=new Student();
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setMyClass(rs.getString("class"));
                stu.setScore(rs.getDouble("score"));
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
            if(pst!=null){
                try {
                    pst.close();
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
        return stu;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PreparedSelect ps=new PreparedSelect();
        //调用查询方法
        Student stu=ps.findById(12);
        System.out.println("Id:"+stu.getId()+"\t姓名:"+stu.getName()+"\t班级:"+stu.getMyClass()+"\t分数:"+stu.getScore());
    }
}
