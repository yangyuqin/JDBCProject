package com.yyq.blob;

import com.yyq.factory.CloseFactory;
import com.yyq.factory.ConnectionFactory;

import java.io.*;
import java.net.ConnectException;
import java.sql.*;

/**
 * Created by gao on 16-4-13.
 */
public class BlobSelectTest {
    public static void select() {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt = null;
        String sql = "select id,name,content,image from stuinfo where name=?";
        ResultSet rs = null;
        BufferedReader br = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "test");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Reader rd = rs.getCharacterStream(3);
                br = new BufferedReader(rd);
                String str = null;
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                }
                Blob blob = rs.getBlob(4);
                BufferedInputStream bis = new BufferedInputStream(blob.getBinaryStream());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("newpanda.png"));
                byte[] bys = new byte[1024];
                int len = 0;
                while ((len = bis.read(bys, 0, 1024)) != -1) {
                    bos.write(bys, 0, len);
                }
                bos.flush();
                bos.close();
                System.out.println("\n-------------Õº∆¨–¥∫√¡À£°");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            CloseFactory.close(pstmt,conn);
        }
    }

    public static void main(String[] args) {
        BlobSelectTest.select();
    }
}
