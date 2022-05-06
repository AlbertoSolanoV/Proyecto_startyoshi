package solano.alberto.bl.vehiculo;

public class Vehiculo {
    private String placa;
    private String marca;

    /**
     * @author Alberto Solano
     * Constructor por defecto, clase Vehiculo
     */
    public Vehiculo() {
        this.placa = null;
        this.marca = null;
    }

    /**
     * Constructor de vehiculo
     * @param pplaca, String placa del vehiculo
     * @param pmarca, String marca del vehiculo
     */
    public Vehiculo(String pplaca, String pmarca) {
        this.placa = pplaca;
        this.marca = pmarca;
    }

    /**
     * Metodo get Placa
     * @return String, placa del vehiculo
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Metodo para asignar una placa
     * @param placa, String de la placa del vehiculo
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Metodo get para Marca
     * @return String, marca del vehiculo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Metodo set para Marca
     * @param marca, String, marca del vehiculo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Metodo to string, clase Vehiculo
     * @return, String con la informacion vehiculo
     */
    @Override
    public String toString() {
        return "Vehiculos{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
