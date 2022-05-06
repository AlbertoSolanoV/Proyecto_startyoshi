package solano.alberto.bl.servicio;

public class Servicio {
    private String codigo;
    private String descripcion;
    private double precioBase;
    private String tipo;
    private boolean estado;
    private double precioLitro;

    /**
     * @author Alberto Solano
     * Constructor por defecto
     */
    public Servicio() {
        this.codigo = null;
        this.descripcion = null;
        this.precioBase = 0;
        this.tipo = null;
        this.estado = false;
        this.precioLitro = 0;
    }

    /**
     * Constructor para gasolina
     *
     * @param pcodigo      String, del codigo del servicio
     * @param pdescripcion String, de la ddescripcion del servicio
     * @param pprecioBase  double, del precio base del servicio
     * @param ptipo        String, del tipo de servicio
     * @param pestado      boolean, del estado del servicio
     * @param pprecioLitro double, del precio del litro
     */
    public Servicio(String pcodigo, String pdescripcion, double pprecioBase, String ptipo, boolean pestado, double pprecioLitro) {
        this.codigo = pcodigo;
        this.descripcion = pdescripcion;
        this.precioBase = pprecioBase;
        this.tipo = ptipo;
        this.estado = pestado;
        this.precioLitro = pprecioLitro;
    }

    /**
     * Constructor para servicios no gasolina
     *
     * @param pcodigo      String, del codigo del servicio
     * @param pdescripcion String, de la ddescripcion del servicio
     * @param pprecioBase  double, del precio base del servicio
     * @param ptipo        String, del tipo de servicio
     * @param pestado      boolean, del estado del servicio
     */
    public Servicio(String pcodigo, String pdescripcion, double pprecioBase, String ptipo, boolean pestado) {
        this.codigo = pcodigo;
        this.descripcion = pdescripcion;
        this.precioBase = pprecioBase;
        this.tipo = ptipo;
        this.estado = pestado;
        this.precioLitro = 0;
    }

    /**
     * Metodo get del codigo del servicio
     * @return String, del codigo del servicio
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Metodo set para el codigo
     * @param codigo String, del codigo del servicio
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo get para la descripcion del servicio
     * @return String, de la descripcion del servicio
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo set para la descripcion del servicio
     * @param descripcion String, de la descripcion del servicio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo get para precio base del servicio
     * @return double, del precio base del servicio
     */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Metodo set para el precio base del servicio
     * @param precioBase double, para el precio base del servicio
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Metodo get para el tipo del servicio
     * @return String, del tipo del servicio
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo set para el tipo del servicio
     * @param tipo String, del tipo del servicio
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo get del estado del servicio
     * @return boolean del estado del servicio
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Metodo set para estado del servicio
     * @param estado boolean, del estado del servicio
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Metodo get del precio litro
     * @return double, del precio litro
     */
    public double getPrecioLitro() {
        return precioLitro;
    }

    /**
     * Metodo set para el precio de litro
     * @param precioLitro double, del precio del litro
     */
    public void setPrecioLitro(double precioLitro) {
        this.precioLitro = precioLitro;
    }

    /**
     * Metodo toString de la clase
     * @return String, con la info de la clase
     */
    @Override
    public String toString() {
        return "Servicios{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioBase=" + precioBase +
                ", tipo='" + tipo + '\'' +
                ", estado=" + estado +
                ", precioLitro=" + precioLitro +
                '}';
    }
}
