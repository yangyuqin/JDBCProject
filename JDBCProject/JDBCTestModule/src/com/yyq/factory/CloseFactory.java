package com.yyq.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by gao on 16-4-13.
 */
public class CloseFactory {
    //�ر�Connection
    public static void close(Connection conn){
        if (null != conn){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //�ر�Statemnt
    public static void close(Statement stmt){
        if (null != stmt){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //�ر�ResultSet
    public static void close(ResultSet rs){
        if (null != rs){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //�ر�����ִ��Select��JDBC��Դ
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        close(rs);
        close(stmt,conn);
    }

    public static void close(Statement stmt, Connection conn){
        close(stmt);
        close(conn);
    }
}
