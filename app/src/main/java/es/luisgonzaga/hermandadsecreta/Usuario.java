package es.luisgonzaga.hermandadsecreta;

/**
 * Created by Nino Ruano on 08/12/2017.
 */

public class Usuario {

    int id;
    String nombre;
    String password;
    String estado;


    public Usuario(int id,String nombre, String password, String estado) {
        this.id=id;
        this.nombre = nombre;
        this.password = password;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
