package solano.alberto.bl.direccion;

public class Direccion {
    private Provincia provincia;
    private Canton canton;
    private Distrito distrito;
    private String direccionExacta;

    /**
     * @author Alberto Solano
     * Constructor por defecto
     */
    public Direccion() {
        this.provincia = null;
        this.canton = null;
        this.distrito = null;
        this.direccionExacta = null;
    }

    /**
     * Constructor para la clase direccion
     * @param pprovincia String, de la provincia
     * @param pcanton String, del canton
     * @param pdistrito String, del distrito
     * @param pdireccionExacta String, de la direccion exacta
     */
    public Direccion(Provincia pprovincia, Canton pcanton,Distrito pdistrito, String pdireccionExacta) {
        this.provincia = pprovincia;
        this.canton = pcanton;
        this.distrito = pdistrito;
        this.direccionExacta = pdireccionExacta;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    /**
     * Metodo get para la direccion exacta
     * @return String, de la direccion exacta
     */
    public String getDireccionExacta() {
        return direccionExacta;
    }

    /**
     * Metodo set para la dirreccion exacta
     * @param direccionExacta String, de la direccion exacta
     */
    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    /**
     * Metodo toString de la clase
     * @return String, de la info de la direccion
     */
    @Override
    public String toString() {
        return "Direccion{" +
                "provincia='" + provincia + '\'' +
                ", canton='" + canton + '\'' +
                ", distrito='" + distrito + '\'' +
                ", direccionExacta='" + direccionExacta + '\'' +
                '}';
    }
}
