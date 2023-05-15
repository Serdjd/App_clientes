public class Cliente implements java.io.Serializable{
    private String nombre;
    private String apellido_1;
    private String apelido_2;
    private int edad;
    private String direccion; 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getApelido_2() {
        return apelido_2;
    }

    public void setApelido_2(String apelido_2) {
        this.apelido_2 = apelido_2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public Cliente(String nombre, String apellido_1,String apellido_2, int edad, String direccion) {
        this.nombre = nombre;
        this.apellido_1 = apellido_1;
        this.apelido_2 = apellido_2;
        this.edad = edad;
        this.direccion = direccion;
    }
    public Cliente() {
        this.nombre = "";
        this.apellido_1 = "";
        this.apelido_2 = "";
        this.edad= 0;
        this.direccion="";
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + "\n apellido_1=" + apellido_1 + "\n apelido_2=" + apelido_2 + "\n edad="
                + edad + "\n direccion=" + direccion;
    }

}

