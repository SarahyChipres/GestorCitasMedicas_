package BD;

public class Fechas {
    private int codigofecha;
    private String fechalaboral;

    public Fechas(int codigofecha, String fechalaboral) {

    setCodigofecha(codigofecha);
    setFechalaboral(fechalaboral);

    }

    public int getCodigofecha() {
        return codigofecha;
    }

    public void setCodigofecha(int codigofecha) {
        this.codigofecha = codigofecha;
    }

    public String getFechalaboral() {
        return fechalaboral;
    }

    public void setFechalaboral(String fechalaboral) {
        this.fechalaboral = fechalaboral;
    }
}