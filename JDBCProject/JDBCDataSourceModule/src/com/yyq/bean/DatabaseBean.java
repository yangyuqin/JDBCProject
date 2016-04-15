package com.yyq.bean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by gao on 16-4-15.
 */
public class DatabaseBean {
    private DataSource dataSource;

    public DatabaseBean(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DatabaseBean() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            //查找jdbc/demo对应的DataSource对象
            dataSource = (DataSource) envContext.lookup("jdbc/demo");
        } catch (NamingException ex) {
            Logger.getLogger(DatabaseBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    public boolean isConnectedOK() {
        boolean ok = false;
        Connection conn = null;
        try {
            //通过DataSource对象取得连接
            conn = dataSource.getConnection();
            if (!conn.isClosed()) {
                ok = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ok;
    }
}
