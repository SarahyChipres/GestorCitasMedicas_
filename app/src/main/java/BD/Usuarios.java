package BD;

public class Usuarios {

    private String codigo;
    private String password, user;

    public Usuarios(String codigo, String password, String user) {
        setCodigo(codigo);
        setPassword(password);
        setUser(user);

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
