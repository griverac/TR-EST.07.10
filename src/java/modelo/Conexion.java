
package modelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public Connection conexionBD;
    public final String bd = "db_empresa";
    public final String urlConexion = String.format("jdbc:mysql://localhost:3306/%s",bd);
    public final String usuario = "usr";
    public final String contra = "123";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void abrirconexion(){
        try{
            
            Class.forName(jdbc);
            conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);

            
        }catch(HeadlessException | ClassNotFoundException | SQLException ex){
        System.out.println("Error..."+ex.getMessage());
        }
    }

    public void cerrarconexion(){
        try {

            conexionBD.close();
            
        } catch (SQLException ex) {
            System.out.println("Error..."+ex.getMessage());
        }

        
    }
}
