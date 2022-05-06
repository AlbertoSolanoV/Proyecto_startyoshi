package solano.alberto.bl.factura;

import solano.alberto.bl.pedido.Pedido;

public class Factura {
    private int numero;
    private Pedido pedido;
    private double total;

    /**
     * @author Alberto Solano
     * Constructor por defecto
     */
    public Factura(){
        this.numero=0;
        this.pedido = null;

        this.total = 0;
    }

    /**
     * Constructor para la clase factura
     * @param numero int, numero de factura
     * @param pedido Pedido, la informacion de la factura
     * @param total double, total con el iva incluido
     */
    public Factura(int numero, Pedido pedido, double total) {
        this.numero = numero;
        this.pedido = pedido;

        this.total = total;
    }

    /**
     * Metodo get para numero de factura
     * @return int, numero de pedido
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Metodo set para el numero
     * @param numero int, del numero de factura
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Metodo get para el pedido
     * @return Pedido, la informacion de la factura
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * Metodo set para el pedido
     * @param pedido Pedido, la informacion de la factura
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    /**
     * Metodo get para el total de la factura
     * @return double, del total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Metodo set para el total de la factura
     * @param total double, del total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Metodo toString de la clase
     * @return String, con la informacion de la clase
     */
    @Override
    public String toString() {
        return "Factura{" +
                "numero=" + numero +
                ", pedido=" + pedido +
                ", total=" + total +
                '}';
    }
}
