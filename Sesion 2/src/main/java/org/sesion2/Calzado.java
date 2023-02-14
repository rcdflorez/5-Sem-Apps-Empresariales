package org.sesion2;

public class Calzado extends Producto implements IVista {

    private double talla;

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }



    public Calzado() {
    }

    public Calzado(String codigo, String description, double pcompra, double pventa, int cbodega, int cminreq, int cmaxreq, double talla) {
        super(codigo, description, pcompra, pventa, cbodega, cminreq, cmaxreq);
        this.talla = talla;
    }

    @Override
    public boolean solicitarPedido() {
        return this.getCantBodega() < this.getCminreq();
    }

    @Override
    public double calcularPagar(int cantidad) {
        return cantidad < 0 ? 0 : (cantidad*this.getPcompra());
    }

    @Override
    public String mostrar() {
        return String.format("%s-%s-%.2f-%.2f-%d-%d-%d-%.2f", this.getCodigo(), this.getDescription(), this.getPcompra(), this.getPventa(), this.getCantBodega(), this.getCminreq(), this.getCmaxreq(),this.getTalla());
    }

    @Override
    public String toString() {
        return "Calzado{" + "\n" +
                "   codigo= " + getCodigo() + "\n" +
                "   descripcion= " + getDescription() + "\n" +
                "   talla= " + talla + "\n" +
                "   precio de compra= " + this.getPcompra() + "\n" +
                "   precio de venta= " + this.getPventa() + "\n" +
                "   cantidad en bodega= " + this.getCantBodega() + "\n" +
                "   cantidad minima requerida= " + this.getCminreq() + "\n" +
                "   cantidad maxima requerida= " + this.getCmaxreq() + "\n" +
                '}';
    }

    //metodos de la interfaz
    @Override
    public String mostrarParametros() {
        return null;
    }

    @Override
    public String mostrarCodigoYDesc() {
        return null;
    }

    @Override
    public String mostrarAtributos() {
        return null;
    }
}
