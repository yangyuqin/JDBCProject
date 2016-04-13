package com.yyq.blob;

import com.yyq.factory.CloseFactory;
import com.yyq.factory.ConnectionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by gao on 16-4-13.
 */
public class BlobInsertTest {
    public static void insert() throws SQLException{
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into stuinfo(name,content,image) values(?,?,?)";
        BufferedReader brtxt = null;
        InputStream isimg = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"test");
            // ���ļ��л�ȡ������--��ȡ�ı�
            InputStream istxt =  Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("test.txt");
            brtxt = new BufferedReader(new InputStreamReader(istxt));
            //����Blob
            pstmt.setCharacterStream(2,brtxt);

            //���ļ��л�ȡ������--��ȡͼƬ
            isimg = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("panda.png");
            pstmt.setBinaryStream(3,isimg);

            if (pstmt.executeUpdate() == 1){
                System.out.println("��ϲ�ɹ����һ����¼��");
            }else{
                System.out.println("��Ӽ�¼ʧ�ܣ�");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                brtxt.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try{
                isimg.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            CloseFactory.close(pstmt,conn);
        }
    }

    public static void main(String[] args) throws SQLException {
        BlobInsertTest.insert();
    }
}
