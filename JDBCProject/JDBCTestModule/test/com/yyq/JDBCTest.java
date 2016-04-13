package com.yyq;
import com.yyq.factory.CloseFactory;
import com.yyq.factory.ConnectionFactory;
import com.yyq.factory.ContrlFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by gao on 16-4-13.
 */

public class JDBCTest {
    Connection conn = null;
    @Test
    public void connectionTest(){
        conn = ConnectionFactory.getConnection();
        if(null == conn){
            System.out.println("未获取数据库连接对象");
        }else {
            System.out.println("已获取数据库连接对象");
        }
    }

//    @Test
//    public void closeTest() throws SQLException {
//        connectionTest();
//        CloseFactory.close(null,null,conn);
//        if(null == conn){
//            System.out.println("数据库连接对象已关闭");
//        }else {
//            System.out.println("数据库连接对象未关闭");
//        }
//    }

    @Test
    public void contrlQueryTest() throws Exception {
        String sql = "select * from student;";
        ResultSet rs = ContrlFactory.executeQuery(sql);
        while (rs.next()){
            System.out.println("Id："+rs.getInt("id")+"\t姓名："+rs.getString("name")+"\t科目："
                    +rs.getString("class")+"\t分数："+rs.getInt("score"));
        }
    }

    @Test
    public void contrlInsertTest() throws Exception{
        String sql = "insert into student(name,score,class) values('sheng',88,'linxu')";
        ContrlFactory.executeUpdate(sql);
    }
}
