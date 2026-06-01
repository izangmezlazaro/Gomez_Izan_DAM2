package examen.gomez.izan.beans;

public class MuestraADN {

    private int id;
    private String codigo;
    private String tipo;
    private String fechaExtraccion;
    private String autorExamen;
    private Laboratorio laboratorio;
    private DetalleMuestraADN detalle;

    public MuestraADN(int id,
                      String codigo,
                      String tipo,
                      String fechaExtraccion,
                      String autorExamen,
                      Laboratorio laboratorio,
                      DetalleMuestraADN detalle) {

        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.fechaExtraccion = fechaExtraccion;
        this.autorExamen = autorExamen;
        this.laboratorio = laboratorio;
        this.detalle = detalle;
    }

    public MuestraADN() {
        this.laboratorio = new Laboratorio();
        this.detalle = new DetalleMuestraADN(id, false, id, autorExamen, autorExamen);
    }

    
    public MuestraADN(int id, String codigo, String tipo, String fechaExtraccion, String autorExamen, int laboratorioId,
            String observaciones) {
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.fechaExtraccion = fechaExtraccion;
        this.autorExamen = autorExamen;
        this.laboratorio = new Laboratorio();
        this.laboratorio.setId(laboratorioId);
        this.detalle = new DetalleMuestraADN(laboratorioId, false, laboratorioId, observaciones, observaciones);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getFechaExtraccion() { return fechaExtraccion; }
    public void setFechaExtraccion(String fechaExtraccion) { this.fechaExtraccion = fechaExtraccion; }

    public String getAutorExamen() { return autorExamen; }
    public void setAutorExamen(String autorExamen) { this.autorExamen = autorExamen; }

    public Laboratorio getLaboratorio() { return laboratorio; }
    public void setLaboratorio(Laboratorio laboratorio) { this.laboratorio = laboratorio; }

    public DetalleMuestraADN getDetalle() { return detalle; }
    public void setDetalle(DetalleMuestraADN detalle) { this.detalle = detalle; }

    public Laboratorio getLaboratorioID() {
        return laboratorio;
    }

    @Override
    public String toString() {
        return "MuestraADN{id=" + id + ", codigo=" + codigo + ", tipo=" + tipo +
               ", fechaExtraccion=" + fechaExtraccion + ", autorExamen=" + autorExamen +
               ", laboratorioId=" + (laboratorio != null ? laboratorio.getId() : "null") + "}";
    }
}
