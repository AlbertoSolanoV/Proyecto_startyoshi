package solano.alberto.bl.vehiculo;

public class Carro extends Vehiculo {
    private String color;
    private String tipo;

    /**
     * @author Alberto Solano
     * Constructor por defecto para clase Carro
     */
    public Carro() {
        super();
        this.color = null;
        this.tipo = null;
    }

    /**
     *Constuctor para la clase Vehiculo
     * @param pplaca String, placa del carro
     * @param pmarca String, marca del carro
     * @param pcolor String, color del carro
     * @param ptipo String, tipo del carro
     */
    public Carro(String pplaca, String pmarca, String pcolor, String ptipo) {
        super(pplaca, pmarca);
        this.color = pcolor;
        this.tipo = ptipo;
    }

    /**
     * Metodo get de colo
     * @return String, color del carro
     */
    public String getColor() {
        return color;
    }

    /**
     * Metodo set de color
     * @param color String, color del carro
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Metodo get de tipo
     * @return String, del tipo del carro
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo set de tipo
     * @param tipo String, del tipo de carro
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo toString de la clase Carro
     * @return String, con la info de la clase
     */
    @Override
    public String toString() {
        return "Carro{" +
                "color='" + color + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
