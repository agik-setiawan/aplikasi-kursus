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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SKYDEV2
 */
public class m_SiswaBaru extends javax.swing.JPanel{
    database db=new database();
     static Connection konek;
    static Statement stat;
    static ResultSet rs;
    /*tampil data siswa*/
    public void tampilSiswa(){
        try{
        db.koneksi();
        stat=konek.createStatement();
        rs=stat.executeQuery("select * from siswa");
        DefaultTableModel tb=new DefaultTableModel();
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
