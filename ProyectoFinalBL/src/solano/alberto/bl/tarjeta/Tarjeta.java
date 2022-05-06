package solano.alberto.bl.tarjeta;

public class Tarjeta {
    private String nombreTarjeta;
    private String numeroTarjeta;
    private String proveedor;
    private String vencimiento;
    private String ccv;

    /**
     * @author Alberto Solano
     * Constructor por defecto
     */
    public Tarjeta() {
        this.nombreTarjeta = null;
        this.numeroTarjeta = null;
        this.proveedor = null;
        this.vencimiento = null;
        this.ccv = null;
    }

    /**
     *Constructo para la clase Tarjeta
     * @param pnombreTarjeta String, nombre del dueño de la tarjeta
     * @param pnumeroTarjeta String, numero de la tarjeta
     * @param pproveedor String, del proveedor de la tarjeta
     * @param pvencimiento String, de la fecha de vencimiento ("dd/mm/aa")
     * @param pccv String, con el numero de seguridad de la tarjeta
     */
    public Tarjeta(String pnombreTarjeta, String pnumeroTarjeta, String pproveedor, String pvencimiento, String pccv) {
        this.nombreTarjeta = pnombreTarjeta;
        this.numeroTarjeta = pnumeroTarjeta;
        this.proveedor = pproveedor;
        this.vencimiento = pvencimiento;
        this.ccv = pccv;
    }

    /**
     * Metodo get de Nombre de tarjeta
     * @return String, del nombre de tarjeta
     */
    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    /**
     * Metodo set de Nombre de tarjeta
     * @param nombreTarjeta String, con el nombre del dueño de la tarjeta
     */
    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    /**
     * Metodo get para numero de tarjeta
     * @return Numero de tarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Metodo set para numero de tarjeta
     * @param numeroTarjeta String, del numero de tarjeta
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Metodo get para Proveedor de la tarjetaa
     * @return String, del proveedor de la tarjeta
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * Metodo set para proveedor de la tarjeta
     * @param proveedor String, del proveedor de la tarjeta
     */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Metodo get para vencimiento de tarjeta
     * @return String, de vencimiento de tarjeta
     */
    public String getVencimiento() {
        return vencimiento;
    }

    /**
     * Metodo set para vencimiento de tarjeta
     * @param vencimiento String, de vencimiento de tarjeta
     */
    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    /**
     * Metodo get para el CCV de la tarjeta
     * @return String, del ccv de la tarjeta
     */
    public String getCcv() {
        return ccv;
    }

    /**
     * Metodo set del ccv de tarjeta
     * @param ccv String, del ccv de la tarjeta
     */
    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    /**
     * Metodo to String de la clase
     * @return String, con la info de la tarjeta
     */
    @Override
    public String toString() {
        return "Tarjetas{" +
                "nombreTarjeta='" + nombreTarjeta + '\'' +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", vencimiento='" + vencimiento + '\'' +
                ", ccv='" + ccv + '\'' +
                '}';
    }
}
