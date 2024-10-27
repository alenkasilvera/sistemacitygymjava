
package Modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocioDao {
    
   Conexion cn = new Conexion();
   Connection con;
   PreparedStatement ps;
   ResultSet rs;
   
   public boolean RegistrarSocio(Socio cl) {
       
       String sql = "INSERT INTO socios (dni, nombre, telefono, direccion) VALUES (?, ?, ?, ?)";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1,cl.getDni());
           ps.setString(2, cl.getNombre());
           ps.setString(3, cl.getTelefono());
           ps.setString(4, cl.getDireccion());
           ps.execute();
           return true;
       } catch (SQLException e) {
           JOptionPane.showInternalMessageDialog(null, e.toString());
           return false;
       } finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
           
   }
   
   public List ListarSocio(){
       List<Socio> ListaCl = new ArrayList();
       String sql = "SELECT * FROM socios";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {
               Socio cl = new Socio();
               cl.setId(rs.getInt("id"));
               cl.setDni(rs.getString("dni"));
               cl.setNombre(rs.getString("nombre"));
               cl.setTelefono(rs.getString("telefono"));
               cl.setDireccion(rs.getString("direccion"));
               ListaCl.add(cl);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
           
       }
       
       return ListaCl;
   }
   
   public boolean EliminarSocio(int id){
       String sql = "DELETE FROM socios WHERE id = ?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.execute();
           return true;
       } catch (SQLException e){
           System.out.println(e.toString());
           return false;
           
       }finally{
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println(ex.toString());
           }
       }
   }
   
   public boolean ModificarSocio(Socio cl){
       String sql = "UPDATE socios SET dni=?, nombre=?, telefono=?, direccion=? WHERE id=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1, cl.getDni());
           ps.setString(2, cl.getNombre());
           ps.setString(3, cl.getTelefono());
           ps.setString(4, cl.getDireccion());
           ps.setInt(5, cl.getId());
           ps.execute();
           return true;
       } catch (SQLException e){
           System.out.println(e.toString());
           return false;
           
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
            System.out.println(e.toString());
                       
           }
       }
   }
   
   public Socio BuscarSocio(String dni) {
       Socio cl = new Socio();
       String sql = "SELECT * FROM socios WHERE dni = ?";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, dni);
           rs = ps.executeQuery();
           if (rs.next()) {
               cl.setNombre(rs.getString("nombre"));
               cl.setTelefono(rs.getString("telefono"));
                cl.setDireccion(rs.getString("direccion"));
           }
           
       } catch (SQLException e){
           System.out.println(e.toString());
       }
       return cl;
   }
   
   
}
