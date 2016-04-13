package com.yyq.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接对象(Connection)工厂类
 */
public class ConnectionFactory {
    private static String DB_DRIVER;
    private static String DB_URL;
    private static String DB_USERNAME;
    private static String DB_PASSWORD;

    public ConnectionFactory() {
    }

    /**
     * 在静态代码块中，获得属性文件中的driver,url,username,password
     */
    static{
        //step1:创建一个Properties对象
        Properties pro = new Properties();
        //step2:以流的形式读取属性文件中的内容
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
        try {
            //step3:加载流is到p对象中
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
     * 该方法用来加载驱动，并获得数据库的连接对象
     *
     * @return 数据库连接对象conn
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            //加载驱动
            Class.forName(DB_DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("连接成功");
        return conn;
    }


}
