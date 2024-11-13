
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class PlanesDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarPlanes(Planes pro) {
        String sql = "INSERT INTO plan (codigo, nombre, entrenador, cupos, precio) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getEntrenador());
            ps.setInt(4, pro.getCupos());
            ps.setDouble(5, pro.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cierra la conexión si está abierta
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public void ConsultarEntrenador(JComboBox entrenador) {
        String sql = "SELECT nombre FROM entrenador";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                entrenador.addItem(rs.getString("nombre"));
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
    }

    public List<Planes> ListarPlanes() {
        List<Planes> Listapro = new ArrayList<>();
        String sql = "SELECT * FROM plan";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Planes pro = new Planes();
                pro.setId(rs.getInt("id"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setEntrenador(rs.getString("entrenador"));
                pro.setCupos(rs.getInt("cupos"));
                pro.setPrecio(rs.getDouble("precio")); // Cambié a getDouble
                Listapro.add(pro);
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
        return Listapro;
    }

    public boolean EliminarPlanes(int id) {
        String sql = "DELETE FROM plan WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cierra la conexión si está abierta
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean ModificarPlanes(Planes pro) {
        String sql = "UPDATE plan SET codigo=?, nombre=?, entrenador=?, cupos=?, precio=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getEntrenador());
            ps.setInt(4, pro.getCupos());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cierra la conexión si está abierta
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public Planes BuscarPro(String cod) {
        Planes plan = new Planes();
        String sql = "SELECT * FROM plan WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                plan.setId(rs.getInt("id")); 
                plan.setCodigo(rs.getString("codigo"));
                plan.setNombre(rs.getString("nombre"));
                plan.setEntrenador(rs.getString("entrenador"));
                plan.setCupos(rs.getInt("cupos"));
                plan.setPrecio(rs.getDouble("precio"));
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
        return plan;
    }
    
    public Config BuscarDatos() {
        Config conf = new Config();
        String sql = "SELECT * FROM configuracion";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                conf.setId(rs.getInt("id")); 
                conf.setNombre(rs.getString("nombre"));
                conf.setCuil(rs.getString("cuil"));
                conf.setTelefono(rs.getString("telefono"));
                conf.setDireccion(rs.getString("direccion"));
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
        return conf;
    }
    
    public boolean ModificarDatos(Config conf) {
        String sql = "UPDATE configuracion SET nombre=?, cuil=?, telefono=?, direccion=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, conf.getNombre());
            ps.setString(2, conf.getCuil());
            ps.setString(3, conf.getTelefono());
            ps.setString(4, conf.getDireccion());
            ps.setInt(5, conf.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cierra la conexión si está abierta
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    
}


