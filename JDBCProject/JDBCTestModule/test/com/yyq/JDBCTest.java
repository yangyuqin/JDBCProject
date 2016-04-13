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
            System.out.println("δ��ȡ���ݿ����Ӷ���");
        }else {
            System.out.println("�ѻ�ȡ���ݿ����Ӷ���");
        }
    }

//    @Test
//    public void closeTest() throws SQLException {
//        connectionTest();
//        CloseFactory.close(null,null,conn);
//        if(null == conn){
//            System.out.println("���ݿ����Ӷ����ѹر�");
//        }else {
//            System.out.println("���ݿ����Ӷ���δ�ر�");
//        }
//    }

    @Test
    public void contrlQueryTest() throws Exception {
        String sql = "select * from student;";
        ResultSet rs = ContrlFactory.executeQuery(sql);
        while (rs.next()){
            System.out.println("Id��"+rs.getInt("id")+"\t������"+rs.getString("name")+"\t��Ŀ��"
                    +rs.getString("class")+"\t������"+rs.getInt("score"));
        }
    }

    @Test
    public void contrlInsertTest() throws Exception{
        String sql = "insert into student(name,score,class) values('sheng',88,'linxu')";
        ContrlFactory.executeUpdate(sql);
    }
}
