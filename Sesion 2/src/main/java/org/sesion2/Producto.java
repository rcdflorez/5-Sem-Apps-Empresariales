package org.sesion2;

public abstract class Producto {

    //Atributos
    private String codigo;
    private String description;
    private double pcompra;
    private double pventa;
    private int cantBodega;
    private int cminreq;
    private int cmaxreq;
    private static final double PDESCUENTO = 0.01;
    //Metodos
    // Getters and Setters
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPcompra() {
        return pcompra;
    }
    public void setPcompra(double pcompra) {
        this.pcompra = pcompra;
    }

    public double getPventa() {
        return pventa;
    }
    public void setPventa(double pventa) {
        this.pventa = pventa;
    }

    public int getCantBodega() {
        return cantBodega;
    }
    public void setCantBodega(int cantBodega) {
        this.cantBodega = cantBodega;
    }

    public int getCminreq() {
        return cminreq;
    }
    public void setCminreq(int cminreq) {
        this.cminreq = cminreq;
    }

    public int getCmaxreq() {
        return cmaxreq;
    }
    public void setCmaxreq(int cmaxreq) {
        this.cmaxreq = cmaxreq;
    }

    public static double getPDESCUENTO() {
        return PDESCUENTO;
    }


    //Constructores
    public Producto() {
    }
    public Producto(String codigo, String description, double pcompra, double pventa, int cantBodega, int cminreq, int cmaxreq) {
        this.codigo = codigo;
        this.description = description;
        this.pcompra = pcompra;
        this.pventa = pventa;
        this.cantBodega = cantBodega;
        this.cminreq = cminreq;
        this.cmaxreq = cmaxreq;
    }

    //Metodos abstractos
    public abstract boolean solicitarPedido();
    public abstract double calcularPagar(int cantidad);
    public abstract String mostrar();


}
