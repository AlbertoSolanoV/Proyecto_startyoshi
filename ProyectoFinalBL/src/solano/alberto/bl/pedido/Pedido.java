package solano.alberto.bl.pedido;

import solano.alberto.bl.servicio.Servicio;
import solano.alberto.bl.usuario.Usuario;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String fechaCreacion;
    private String estado;
    private ArrayList<Servicio> servicios;
    private Usuario user;

    /**
     * @author Alberto Solano
     * Constructor por defecto
     */
    public Pedido() {
        this.numero = 0;
        this.fechaCreacion = null;
        this.estado = null;
        this.servicios = null;
        this.user = null;
    }

    /**
     * Constructor de la clase
     * @param pnumero int, numero del pedido
     * @param pfechaCreacion String, fecha de creacion (dd/mm/aa)
     * @param pestado String, del estado del pedido
     * @param pservicios ArrayList<Servicio>, con los servicios pedidos
     * @param puser Usuario, usuario del cliente
     */
    public Pedido(int pnumero, String pfechaCreacion, String pestado, ArrayList<Servicio> pservicios, Usuario puser) {
        this.numero = pnumero;
        this.fechaCreacion = pfechaCreacion;
        this.estado = pestado;
        this.servicios = pservicios;
        this.user = puser;
    }

    /**
     * Metodo get para el numero de pedido
     * @return int, numero de peedido
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Metodo ser del numero de pedido
     * @param numero int, numero del pedido
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Metodo get de la fecha de creacion
     * @return String, de la fecha de creacion del pedido
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Metodo set de la fecha de creacion
     * @param fechaCreacion String, de la fecha de creacion de pedido
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Metodo get para el estado de pedido
     * @return String, con el estado de pedido
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo set para el estado de pedido
     * @param estado String, del estado de pedido
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo get para los servicios de pedido
     * @return ArrayList<Servicio>, de los servicios del pedido
     */
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    /**
     * Metodo set para los servicios
     * @param servicios ArrayList<Servicio>, de los servicios del pedido
     */
    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    /**
     * Metodo get para el usuario Cliente
     * @return Usuario, el cliente del pedido
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * Metodo set para el usuario Cliente
     * @param user Usuario, el cliente del pedido
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

    /**
     * Metodo toString
     * @return String, con la info del pedido
     */
    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", estado='" + estado + '\'' +
                ", servicios=" + servicios +
                ", user=" + user +
                '}';
    }
}
