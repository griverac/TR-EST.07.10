
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class Estudiante extends Persona {
    
    private String idest, carne, idtiposangre;
    
     Conexion cn;

    public Estudiante() {
    }

    public Estudiante(String idestudiante, String carne, String nombres, String apellidos, String direccion, String telefono, String correoelectronico, String idtiposangre, String fechanacimiento) {
        super(nombres, apellidos, direccion, telefono, correoelectronico, fechanacimiento);
        this.idestudiante = idestudiante;
        this.carne = carne;
        this.idtiposangre = idtiposangre;
    }

    public String getIdestudiante() {
     	   return idestudiante;
    }

    public void setIdestudiante(String idestudiante) {
        this.idestudiante = idestudiante;
    }

    public String getCarne() {
       	 return carne;
    }

    public void setCarne(String carne) {
       	 this.carne = carne;
    }

    public String getIdtiposangre() {
        	return idtiposangre;
    }

    public void setIdtipo_sangre(String idtipo_sangre) {
        this.idtiposangre = idtiposangre;
    }
    

    public int agregar(){
        int retorno = 0;
    try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "INSERT INTO estudiantes(carne,nombres,apellidos,direccion,telefono,correo_electronico,idtiposangre,fechanacimiento) values(?,?,?,?,?,?,?,?);";
            cn.abrirconexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,this.getCarne());
            parametro.setString(2,this.getNombres());
            parametro.setString(3,this.getApellidos());
            parametro.setString(4,this.getDireccion());
            parametro.setString(5,this.getTelefono());
            parametro.setString(6,this.getCorreoelectronico());
            parametro.setString(7,this.getIdtiposangre());
            parametro.setString(8,this.getFechanacimiento());
            retorno = parametro.executeUpdate();
            cn.cerrarconexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
    return retorno;
    }
    
    
 
 public DefaultTableModel leer(){
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "SELECT e.idestudiantes as id,e.carne,e.nombres,e.apellidos,e.direccion,e.telefono,e.correoelectronico,s.sangre,s.idtiposangre, e.fecha_nacimiento FROM estudiantes as e inner join tipossangre as s on e.idtiposangre = s.idtiposangre;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","carne","nombres","apellidos","direccion","telefono","correoelectronico","sangre","idtiposangre","fechanacimiento"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[10];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("carne");
          datos[2] = consulta.getString("nombres");
          datos[3] = consulta.getString("apellidos");
          datos[4] = consulta.getString("direccion");
          datos[5] = consulta.getString("telefono");
          datos[6] = consulta.getString("correo_electronico");
          datos[7] = consulta.getString("sangre");
          datos[8] = consulta.getString("idtiposangre");
          datos[9] = consulta.getString("fechanacimiento");
          tabla.addRow(datos);
      
      }
      
     cn.cerrarconexion();
 }catch(SQLException ex){
     System.out.println(ex.getMessage());
 }
 return tabla;
 }

     public int modificar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "update estudiantes set carne = ?, nombres= ?, apellidos= ?, direccion= ?,telefono= ?, correoelectronico= ?,idtiposangre = ?, fechanacimiento= ? where idestudiantes = ?;";
            cn.abrirconexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,this.getCarne());
            parametro.setString(2,this.getNombres());
            parametro.setString(3,this.getApellidos());
            parametro.setString(4,this.getDireccion());
            parametro.setString(5,this.getTelefono());
            parametro.setString(6,this.getCorreoelectronico());
            parametro.setString(7,this.getId_tiposangre());
            parametro.setString(8,this.getFechanacimiento());
            parametro.setString(9,this.getIdestudiante());
            
            retorno = parametro.executeUpdate();
            cn.cerrarconexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }

    public int eliminar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "delete from estudiantes  where idestudiantes = ?;";
            cn.abrirconexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getId_estudiante());
            retorno = parametro.executeUpdate();
            cn.cerrarconexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
 
    
}
