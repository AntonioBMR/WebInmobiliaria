package hibernate;
// Generated 31-ene-2015 19:40:23 by Hibernate Tools 3.6.0



/**
 * Foto generated by hbm2java
 */
public class Foto  implements java.io.Serializable {


     private Integer id;
     private Inmueble inmueble;
     private String ruta;

    public Foto() {
    }

    public Foto(Inmueble inmueble, String ruta) {
       this.inmueble = inmueble;
       this.ruta = ruta;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Inmueble getInmueble() {
        return this.inmueble;
    }
    
    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
    public String getRuta() {
        return this.ruta;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }




}


