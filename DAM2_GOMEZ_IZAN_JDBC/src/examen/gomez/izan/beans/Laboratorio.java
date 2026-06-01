package examen.gomez.izan.beans;

public class Laboratorio {
    
    private int id;
    private String nombre;
    private String pais;

    private String autorExamen;

    
    public Laboratorio() {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.autorExamen = autorExamen;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPais() {
        return pais;
    }


    public void setPais(String pais) {
        this.pais = pais;
    }



    public String getAutorExamen() {
        return autorExamen;
    }


    public void setAutorExamen(String autorExamen) {
        this.autorExamen = autorExamen;
    }

    
}
