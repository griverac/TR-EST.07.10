
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class tipos_sangre {
    
    private String idtipossangre, sangre;
    Conexion cn;

    public tipossangre() {
    }

    public tipossangre(String idtipossangre, String sangre) {
        this.idtipossangre = idtipossangre;
        this.sangre = sangre;
    }

    public String getIdtipossangre() {
        return idtipossangre;
    }

    public void setIdtipossangre(String idtipossangre) {
        this.idtiposangre = idtipossangre;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }
    
    
         public HashMap dropsangre(){
    HashMap<String,String> drop = new HashMap();
    try{
        String query ="SELECT  idtiposangre as id,sangre FROM tipossangre;";
         cn = new Conexion();
         cn.abrirconexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop.put(consulta.getString("id"),consulta.getString("sangre") );
            }
         cn.cerrarconexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop;
    }
    
    
}
