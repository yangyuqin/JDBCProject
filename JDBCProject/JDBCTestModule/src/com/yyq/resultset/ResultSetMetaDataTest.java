package com.yyq.resultset;

import com.yyq.factory.CloseFactory;
import com.yyq.factory.ConnectionFactory;

import java.sql.*;

/**
 * Created by gao on 16-4-13.
 */
public class ResultSetMetaDataTest {
    public static void test() {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from student";
        try {
            //可滚动的，只读的结果集
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            //在结果集上获取元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount(); //获取总列（字段）数
            System.out.println("ColumnCount：" + count);
            for (int i = 1; i <= count; i++) {
                System.out.println("No:" + i);
                System.out.println("Catalog Name:" + rsmd.getCatalogName(i));
                System.out.println("Data Type Class:" + rsmd.getColumnClassName(i));
                System.out.println("ColumnDisplaySize:" + rsmd.getColumnDisplaySize(i));
                System.out.println("ColumnLabel:" + rsmd.getColumnLabel(i));
                System.out.println("Column Type:" + rsmd.getColumnType(i));
                System.out.println("Column Type Name:" + rsmd.getColumnTypeName(i));
                System.out.println("Precision:" + rsmd.getPrecision(i));
                System.out.println("Scale"+rsmd.getScale(i));
                System.out.println("SchemaName:"+rsmd.getSchemaName(i));
                System.out.println("Table Name:"+rsmd.getTableName(i));
                System.out.println("IsAutoIncrement:"+rsmd.isAutoIncrement(i));
                System.out.println("IsCurrency:"+rsmd.isCurrency(i));
                System.out.println("IsNullable:"+rsmd.isNullable(i));
                System.out.println("IsReadOnly:"+rsmd.isReadOnly(i));
                System.out.println("isSearchable:"+rsmd.isSearchable(i));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseFactory.close(pstmt, conn);
        }
    }

    public static void main(String[] args) {
        ResultSetMetaDataTest.test();
    }
}