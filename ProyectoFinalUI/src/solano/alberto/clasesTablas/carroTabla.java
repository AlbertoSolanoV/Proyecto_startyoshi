package solano.alberto.clasesTablas;

public class carroTabla {

    private String tipo;
    private String marca;
    private String placa;
    private String color;

    public carroTabla(String tipo, String marca, String placa, String color) {
        this.tipo = tipo;
        this.marca = marca;
        this.placa = placa;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
