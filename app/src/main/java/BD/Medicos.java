package BD;

public class Medicos{
    private String codigomedico;
    private String passwordmedico, usermedico;

    public Medicos(String codigomedico, String passwordmedico, String usermedico) {
        setCodigomedico(codigomedico);
        setPasswordmedico(passwordmedico);
        setUsermedico(usermedico);

    }

    public String getCodigomedico() {
        return codigomedico;
    }

    public void setCodigomedico(String codigomedico) {
        this.codigomedico = codigomedico;
    }

    public String getPasswordmedico() {
        return passwordmedico;
    }

    public void setPasswordmedico(String passwordmedico) {
        this.passwordmedico = passwordmedico;
    }

    public String getUsermedico() {
        return usermedico;
    }

    public void setUsermedico(String usermedico) {
        this.usermedico = usermedico;
    }
}


