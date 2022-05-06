package solano.alberto.clasesTablas;

public class motoTabla {
    private String tipo;
    private String marca;
    private String placa;

    public motoTabla(String tipo, String marca, String placa) {
        this.tipo = tipo;
        this.marca = marca;
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
