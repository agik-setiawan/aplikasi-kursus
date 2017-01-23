/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appKursusAmd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author SKYDEV2
 */
public class database {
    static Connection konek;
    static Statement stat;
    static ResultSet rs;
    public void koneksi() throws ClassNotFoundException{
        try {
            Class.forName("org.sqlite.JDBC");
           konek = DriverManager.getConnection("jdbc:sqlite:db/dbKursus.db");
           System.out.println("Koneksi Database Sukses"); 
         } catch (SQLException se) {  
           System.out.println("Koneksi Database Gagal : " + se); 
           JOptionPane.showMessageDialog(null, "koneksi ke database gagal");
           System.exit(0);  
         }
        
    }
    
    /*cek login username dan password*/
    public void cek_login(String username, String password){
        String chk_pwd= password;
        String chk_usename=username;
        try{
        koneksi();
          stat=konek.createStatement();
           rs=stat.executeQuery("select * from user_login where username='"+username+"'");
          if(rs.getString("username")==null){
            JOptionPane.showMessageDialog(null, "Username dan Password tidak di temukan");  
          }
while(rs.next()){
    
    if(password.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
        formUtama menuUtama=new formUtama();
        menuUtama.show();
       menuUtama.setVisible(true);
       formLogin fl=new formLogin();
       fl.hide();
       fl.setVisible(false);
       
    }else{
        JOptionPane.showMessageDialog(null, "Username dan Password tidak cocok");
        break;
    }
   
}
           stat.close();
           rs.close();
           konek.close();
        
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, "gagal, Username dan Password tidak cocok");
        }
    }
    /*--end cek login username dan password--*/
    
    public void insert_siswa(){
        
    }
}
