package solano.alberto.bl.vehiculo;

public class Moto extends Vehiculo {
    private String tipo;

    /**
     * @author Alberto Solano
     * Contructor por defecto
     */
    public Moto() {
        super();
        this.tipo = null;
    }

    /**
     *Contructor para la clase Moto
     * @param pplaca String de la placa de moto
     * @param pmarca String de la marca de moto
     * @param ptipo String del tipo de moto
     */
    public Moto(String pplaca, String pmarca, String ptipo) {
        super(pplaca, pmarca);
        this.tipo = ptipo;
    }

    /**
     * Metodo get de tipo
     * @return String con el tipo de moto
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo set de tipo
     * @param tipo String con el tipo de moto
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo toString clase Moto
     * @return String con la info de moto
     */
    @Override
    public String toString() {
        return "Moto{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
