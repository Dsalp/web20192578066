/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author david
 */
public class UsuarioDTO implements Serializable {

    private int id;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String n_identifi;
    private String correo;
    private String clave;
    private String sexo;
    private Date fecha_nac;
    private boolean estado;

    public UsuarioDTO() {
    }
    public UsuarioDTO(String nombre1, String nombre2, String apellido1, String apellido2, String n_identifi, String correo, String clave, String sexo, Date fecha_nac, boolean estado) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.n_identifi = n_identifi;
        this.correo = correo;
        this.clave = clave;
        this.sexo = sexo;
        this.fecha_nac = fecha_nac;
        this.estado = estado;
    }

    public UsuarioDTO(int id, String nombre1, String nombre2, String apellido1, String apellido2, String n_identifi, String correo) {
        this.id = id;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.n_identifi = n_identifi;
        this.correo = correo;
    }

    

    public UsuarioDTO(int id, String nombre1, String nombre2, String apellido1, String apellido2, String n_identifi, String correo, String clave, String sexo, Date fecha_nac, boolean estado) {
        this.id = id;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.n_identifi = n_identifi;
        this.correo = correo;
        this.clave = clave;
        this.sexo = sexo;
        this.fecha_nac = fecha_nac;
        this.estado = estado;
    }

    public UsuarioDTO(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getN_identifi() {
        return n_identifi;
    }

    public void setN_identifi(String n_identifi) {
        this.n_identifi = n_identifi;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre1+ " " + nombre2 + " " + apellido1 + " " + apellido2  ;

}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nombre1);
        hash = 79 * hash + Objects.hashCode(this.nombre2);
        hash = 79 * hash + Objects.hashCode(this.apellido1);
        hash = 79 * hash + Objects.hashCode(this.apellido2);
        hash = 79 * hash + Objects.hashCode(this.n_identifi);
        hash = 79 * hash + Objects.hashCode(this.correo);
        hash = 79 * hash + Objects.hashCode(this.clave);
        hash = 79 * hash + Objects.hashCode(this.sexo);
        hash = 79 * hash + Objects.hashCode(this.fecha_nac);
        hash = 79 * hash + (this.estado ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioDTO other = (UsuarioDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.nombre1, other.nombre1)) {
            return false;
        }
        if (!Objects.equals(this.nombre2, other.nombre2)) {
            return false;
        }
        if (!Objects.equals(this.apellido1, other.apellido1)) {
            return false;
        }
        if (!Objects.equals(this.apellido2, other.apellido2)) {
            return false;
        }
        if (!Objects.equals(this.n_identifi, other.n_identifi)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.fecha_nac, other.fecha_nac)) {
            return false;
        }
        return true;
    }
    
}