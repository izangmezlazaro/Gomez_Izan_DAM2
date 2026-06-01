package examen.gomez.izan.beans;

public class DetalleMuestraADN {
    
    private int id;
    private boolean mutacionDetectada;
    private double porcentajeCoincidencia;
    private String observaciones;
    private String autorExamen;

    public DetalleMuestraADN() {
        // constructor vacío necesario
    }

    public DetalleMuestraADN(int id, boolean mutacionDetectada, double porcentajeCoincidencia, String observaciones,
            String autorExamen) {
        this.id = id;
        this.mutacionDetectada = mutacionDetectada;
        this.porcentajeCoincidencia = porcentajeCoincidencia;
        this.observaciones = observaciones;
        this.autorExamen = autorExamen;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public boolean isMutacionDetectada() { return mutacionDetectada; }
    public void setMutacionDetectada(boolean mutacionDetectada) { this.mutacionDetectada = mutacionDetectada; }

    public double getPorcentajeCoincidencia() { return porcentajeCoincidencia; }
    public void setPorcentajeCoincidencia(double porcentajeCoincidencia) { this.porcentajeCoincidencia = porcentajeCoincidencia; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getAutorExamen() { return autorExamen; }
    public void setAutorExamen(String autorExamen) { this.autorExamen = autorExamen; }

    @Override
    public String toString() {
        return "DetalleMuestraADN{id=" + id + ", mutacionDetectada=" + mutacionDetectada +
               ", porcentajeCoincidencia=" + porcentajeCoincidencia + ", observaciones=" + observaciones + "}";
    }
}
