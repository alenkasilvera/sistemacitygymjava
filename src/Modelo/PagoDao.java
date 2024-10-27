
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PagoDao {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int IdPago() {
        int id = 0;
        String sql = "SELECT MAX(id) FROM ventas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }

    public int RegistrarPago(Pago p) {
        String sql = "INSERT INTO ventas (socio, vendedor, total) VALUES (?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getSocio());
            ps.setString(2, p.getVendedor());
            ps.setDouble(3, p.getTotal());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public int RegistrarDetalle(Detalle Dv) {
        String sql = "INSERT INTO detalles (codigo_plan, cantidad, precio, id_venta) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Dv.getCodigo_plan());
            ps.setInt(2, Dv.getCantidad());
            ps.setDouble(3, Dv.getPrecio());
            ps.setInt(4, Dv.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
   
    }

    public boolean ActualizarCupos(int cant, String cod) {
        String sql = "UPDATE plan SET cupos = ? WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List Listarpagos() {
        List<Pago> ListaPago = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pago pag = new Pago();
                pag.setId(rs.getInt("id"));
                pag.setSocio(rs.getString("socio"));
                pag.setVendedor(rs.getString("vendedor"));
                pag.setTotal(rs.getDouble("total")); 
                ListaPago.add(pag);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cierra la conexión si está abierta
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return ListaPago;
    }
    
    
    
    
}
