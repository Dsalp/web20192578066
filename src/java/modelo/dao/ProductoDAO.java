package modelo.dao;

import conexion.ConexionMySQL;
import java.util.List;
import modelo.dto.ProductoDTO;
import modelo.interfaces.Obligacion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author david
 */
public class ProductoDAO implements Obligacion<ProductoDTO> {

    private static final String SQL_CREATE = "INSERT INTO tb_producto " + "(nombre_producto, descripcion_producto, unidades, valor) Values(?,?,?,?) ";
    private static final String SQL_DELETE="DELETE FROM tb_producto WHERE id_producto = ? ";
    private static final String SQL_UPDATE="UPDATE tb_producto SET"+" nombre_producto = ?, descripcion_producto = ?, unidades = ?, valor = ? WHERE id_producto = ? ";
    private static final String SQL_READ="SELECT * FROM tb_producto WHERE id_producto = ? ";
    private static final String SQL_READALL="SELECT * FROM tb_producto ";

    private static final ConexionMySQL con=  ConexionMySQL.getInstance();
    @Override
    public boolean create(ProductoDTO nuevo) {
        try {
            PreparedStatement ps;
            ps= con.getCnn().prepareStatement(SQL_CREATE);
            ps.setString(1, nuevo.getNombre_prod());
            ps.setString(2, nuevo.getDescripcion_prod());
            ps.setInt(3, nuevo.getUnd());
            ps.setLong(4, nuevo.getValor());
            if (ps.executeUpdate()>0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al crear producto"+ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public List<ProductoDTO> readALL() {
       List<ProductoDTO> lista= null;
       PreparedStatement ps;
        try {
            ps= con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs= ps.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                ProductoDTO obj= new ProductoDTO(
                rs.getInt("id_producto"),
                rs.getString("nombre_producto"),
                rs.getString("descripcion_producto"),
                rs.getInt("unidades"),
                rs.getLong("valor"));
               lista.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Error en consultar readALL"+ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return lista;
    }

    @Override
    public ProductoDTO read(ProductoDTO filter) {
       ProductoDTO objRes= null;
       PreparedStatement psnt;
        try {
            psnt= con.getCnn().prepareStatement(SQL_READ);
            psnt.setInt(1, filter.getId_prod());
            ResultSet rs= psnt.executeQuery();
            if(rs.next()){
                objRes= new ProductoDTO(
                rs.getInt("id_producto"),
                rs.getString("nombre_producto"),
                rs.getString("descripcion_producto"),
                rs.getInt("unidades"),
                rs.getLong("valor"));
            }
        } catch (SQLException ex) {
            System.out.println("Error en consultar read"+ex.getMessage());
        }
        return objRes;
    }

    @Override
    public boolean update(ProductoDTO item) {
        PreparedStatement ps;
        try {
            ps= con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, item.getNombre_prod());
            ps.setString(2, item.getDescripcion_prod());
            ps.setInt(3, item.getUnd());
            ps.setLong(4, item.getValor());
            ps.setInt(5, item.getId_prod());
            if (ps.executeUpdate()>0) {
                return true;
            }
        } catch (SQLException ex) {
             System.out.println("Error en actualizar"+ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(ProductoDTO item) {
         PreparedStatement ps;
        try {
            ps= con.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getId_prod());
            if (ps.executeUpdate()>0) {
                return true;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en Eliminar"+ex.getMessage());
        }
        finally{
            con.cerrarConexion();
        }return false;
    }

}
