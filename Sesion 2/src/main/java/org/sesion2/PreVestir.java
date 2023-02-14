package org.sesion2;

public class PreVestir extends Producto implements IVista {
    private boolean planchado;
    private String talla;

    public boolean isPlanchado() {
        return planchado;
    }

    public void setPlanchado(boolean planchado) {
        this.planchado = planchado;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }


    public PreVestir() {
    }

    public PreVestir(String codigo, String description, double pcompra, double pventa, int cbodega, int cminreq, int cmaxreq, String talla,boolean planchado) {
        super(codigo, description, pcompra, pventa, cbodega, cminreq, cmaxreq);
        this.talla = talla;
        this.planchado = planchado;
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
        return String.format("%s-%s-%.2f-%.2f-%d-%d-%d-%s-%s", this.getCodigo(), this.getDescription(), this.getPcompra(), this.getPventa(), this.getCantBodega(), this.getCminreq(), this.getCmaxreq(),this.getTalla(), (this.isPlanchado() ? "SI":"NO"));
    }

    @Override
    public String toString() {
        return "Calzado{" + "\n" +
                "   codigo = " + getCodigo() + "\n" +
                "   descripcion = " + getDescription() + "\n" +
                "   talla = " + talla + "\n" +
                "   precio de compra = " + this.getPcompra() + "\n" +
                "   precio de venta = " + this.getPventa() + "\n" +
                "   cantidad en bodega = " + this.getCantBodega() + "\n" +
                "   cantidad minima requerida = " + this.getCminreq() + "\n" +
                "   cantidad maxima requerida = " + this.getCmaxreq() + "\n" +
                "   planchado = " + (this.isPlanchado() ? "Si" : "No") + "\n" +
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
