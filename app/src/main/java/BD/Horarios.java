package BD;

public class Horarios {
    private int id;
    private String hora;

    public Horarios(int id, String hora ) {
        setId(id);
        setHora(hora);
    }

    public Horarios() {
        String holi = "holi";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
