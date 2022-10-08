
package modelo;

public class Persona {
    
    private String nombres, apellidos,direccion,telefono, correoelectronico, fechanacimiento;

    public Persona() {
    }

    public Persona(String nombres, String apellidos, String direccion, String telefono, String correoelectronico, String fechanacimiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoelectronico = correoelectronico;
        this.fechanacimiento = fechanacimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    
  public int agregar(){return 0;}
  public int modificar (){return 0;}
  public int eliminar (){return 0;}
    
}
