package com.lextalionis;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DeleteErrorException;
import com.dropbox.core.v2.files.GetMetadataErrorException;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.files.WriteMode;

import java.sql.*;



public class DropBoxManager {

    private static DropBoxManager instance;
    private DbxClientV2 client;
    private Connection conn;

    private DropBoxManager(){
        /*
        InputStream is = DropBoxManager.class.getResourceAsStream("media/token.txt");
        InputStreamReader iis = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(iis);
        String token=null;
        try {
            token = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DbxRequestConfig config = DbxRequestConfig.newBuilder("Lextalionis").build();
        client = new DbxClientV2(config, token);
        */
        InputStream is = DropBoxManager.class.getResourceAsStream("media/dbcred");
        InputStreamReader iis = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(iis);
        String url=null;
        try {
            url = reader.readLine();
            conn = DriverManager.getConnection(url);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public void save(User u){
        try {
            ByteArrayOutputStream fos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(u);
            oos.flush();
            oos.close();
            ByteArrayInputStream bis = new ByteArrayInputStream(fos.toByteArray());
            PreparedStatement ps = conn.prepareStatement("insert into Users values (?, ?) ON CONFLICT (Username) DO UPDATE SET Data = excluded.Data;");
            ps.setString(1, u.getUsername());
            ps.setBinaryStream(2, bis);
            ps.executeUpdate();
            ps.close();
            bis.close();
            //client.files().uploadBuilder("/"+u.getUsername()).withMode(WriteMode.OVERWRITE).uploadAndFinish(bis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public boolean exists(String username){
        try {
            PreparedStatement st = conn.prepareStatement("select 1 from Users where Users.Username = ?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
           return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public User load(String username){
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users where Users.Username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            InputStream is = new ByteArrayInputStream(rs.getBytes(2));
            ObjectInputStream objectInputStream = new ObjectInputStream(is);
            return (User)(objectInputStream.readObject());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static DropBoxManager getInstance() {
        if(instance == null){
            instance = new DropBoxManager();
        }
        return instance;
    }
}
