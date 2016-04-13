package com.yyq.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ���ݿ����Ӷ���(Connection)������
 */
public class ConnectionFactory {
    private static String DB_DRIVER;
    private static String DB_URL;
    private static String DB_USERNAME;
    private static String DB_PASSWORD;

    public ConnectionFactory() {
    }

    /**
     * �ھ�̬������У���������ļ��е�driver,url,username,password
     */
    static{
        //step1:����һ��Properties����
        Properties pro = new Properties();
        //step2:��������ʽ��ȡ�����ļ��е�����
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
        try {
            //step3:������is��p������
            pro.load(is);
            DB_DRIVER = pro.getProperty("driver");
            DB_URL = pro.getProperty("url");
            DB_USERNAME = pro.getProperty("username");
            DB_PASSWORD = pro.getProperty("password");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * �÷�������������������������ݿ�����Ӷ���
     *
     * @return ���ݿ����Ӷ���conn
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            //��������
            Class.forName(DB_DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("���ӳɹ�");
        return conn;
    }


}
