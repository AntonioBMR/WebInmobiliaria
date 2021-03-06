package hibernate;
// Generated 31-ene-2015 19:40:23 by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Inmueble generated by hbm2java
 */
public class Inmueble  implements java.io.Serializable {


     private Integer id;
     private String tipo;
     private String localidad;
     private BigDecimal precio;
     private String direccion;
     private String usuario;
     private Set fotos = new HashSet(0);

    public Inmueble() {
    }

	
    public Inmueble(String tipo, String localidad, BigDecimal precio, String direccion, String usuario) {
        this.tipo = tipo;
        this.localidad = localidad;
        this.precio = precio;
        this.direccion = direccion;
        this.usuario = usuario;
    }
    public Inmueble(String tipo, String localidad, BigDecimal precio, String direccion, String usuario, Set fotos) {
       this.tipo = tipo;
       this.localidad = localidad;
       this.precio = precio;
       this.direccion = direccion;
       this.usuario = usuario;
       this.fotos = fotos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Set getFotos() {
        return this.fotos;
    }
    
    public void setFotos(Set fotos) {
        this.fotos = fotos;
    }




}


