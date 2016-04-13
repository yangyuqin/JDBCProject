package com.yyq.resultset;

import com.yyq.factory.CloseFactory;
import com.yyq.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gao on 16-4-13.
 */
public class ResultSetTest {
    public static void testPager(int firstResult, int maxResults) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select id,name,score,class from student";
        try {
            //可滚动的，只读的结果集
            pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = pstmt.executeQuery();

            //光标移到最后一行
            rs.absolute(-1); //rs.last();
            //获取总记录数
            int count = rs.getRow();
            System.out.println("Recorder SUM:" + count);
            //光标移到指定行的前一行
            rs.absolute(firstResult - 1);
            for (int i = 0; i < maxResults; i++) {
                if (rs.next()) {
                    System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(4) + ", " + rs.getInt(3));
                } else {
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseFactory.close(pstmt, conn);
        }
    }

    public static void main(String[] args) {
        ResultSetTest.testPager(6, 12);
    }
}
