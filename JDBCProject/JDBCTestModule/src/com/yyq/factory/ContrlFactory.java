package com.yyq.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by gao on 16-4-13.
 */
public class ContrlFactory {
    /**
    * ÷¥––select”Ôæ‰
    */
    public static ResultSet executeQuery(String sql) throws Exception{
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        }catch (SQLException e){
            throw e;
        }
        return rs;
    }

    /**
    * ÷¥––Insert°¢Update°¢Delete”Ôæ‰
    */
    public static void executeUpdate(String sql) throws Exception{
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            CloseFactory.close(stmt,conn);
        }
    }
 }
