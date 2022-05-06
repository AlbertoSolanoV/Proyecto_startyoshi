package solano.alberto.clasesTablas;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class serviciosTabla {
    private SimpleStringProperty Codigo;
    private SimpleStringProperty Nombre;
    private SimpleStringProperty Tipo;
    private SimpleStringProperty Estado;
    private SimpleDoubleProperty PrecioBase;
    private SimpleDoubleProperty PrecioLitro;

    public serviciosTabla(String codigo, String nombre, String tipo, String estado, String precioBase, String precioLitro) {
        Codigo =new SimpleStringProperty(codigo);
        Nombre = new SimpleStringProperty(nombre);
        Tipo = new SimpleStringProperty(tipo);
        Estado = new SimpleStringProperty(estado);
        PrecioBase = new SimpleDoubleProperty(Double.parseDouble(precioBase));
        PrecioLitro = new SimpleDoubleProperty(Double.parseDouble(precioLitro));
    }

    public String getCodigo() {
        return Codigo.get();
    }

    public SimpleStringProperty codigoProperty() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        this.Codigo.set(codigo);
    }

    public String getNombre() {
        return Nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre.set(nombre);
    }

    public String getTipo() {
        return Tipo.get();
    }

    public SimpleStringProperty tipoProperty() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo.set(tipo);
    }

    public String getEstado() {
        return Estado.get();
    }

    public SimpleStringProperty estadoProperty() {
        return Estado;
    }

    public void setEstado(String estado) {
        this.Estado.set(estado);
    }

    public double getPrecioBase() {
        return PrecioBase.get();
    }

    public SimpleDoubleProperty precioBaseProperty() {
        return PrecioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.PrecioBase.set(precioBase);
    }

    public double getPrecioLitro() {
        return PrecioLitro.get();
    }

    public SimpleDoubleProperty precioLitroProperty() {
        return PrecioLitro;
    }

    public void setPrecioLitro(double precioLitro) {
        this.PrecioLitro.set(precioLitro);
    }
}
