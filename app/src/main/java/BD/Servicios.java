package BD;


public class Servicios {
    private int codigoservicio;
    private String nombreservicio, precioservicio;


    public Servicios(int codigoservicio, String nombreservicio, String precioservicio) {

        setCodigoservicio(codigoservicio);
        setNombreservicio(nombreservicio);
        setPrecioservicio(precioservicio);
    }

    public Servicios() {
        codigoservicio = 0;
        nombreservicio = "";
        precioservicio = "";
    }

    public int getCodigoservicio() {
        return codigoservicio;
    }

    public void setCodigoservicio(int codigoservicio) {
        this.codigoservicio = codigoservicio;
    }

    public String getPrecioservicio() {
        return precioservicio;
    }

    public void setPrecioservicio(String precioservicio) {
        this.precioservicio = precioservicio;
    }

    public String getNombreservicio() {
        return nombreservicio;
    }

    public void setNombreservicio(String nombreservicio) {
        this.nombreservicio = nombreservicio;
    }
}

