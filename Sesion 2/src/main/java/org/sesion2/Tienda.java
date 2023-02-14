package org.sesion2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    int nPreVestir;
    int nCalzado;

    PreVestir vectorVestir[];
    Calzado vectorCalzado[];
    Scanner scanner = new Scanner(System.in);

    //Constructor de tienda
    public Tienda() {
        System.out.println("ingrese el numero de productos de tipo prendas a vestir a manejar");
        this.nPreVestir = scanner.nextInt();
        System.out.println("ingrese el numero de productos de tipo calzado a manejar");
        this.nCalzado = scanner.nextInt();

        this.vectorVestir = new PreVestir[this.nPreVestir];
        this.vectorCalzado = new Calzado[this.nCalzado];

        surtirTienda();
    }

    //Getters & Setters
    public int getnPreVestir() {
        return nPreVestir;
    }
    public void setnPreVestir(int nPreVestir) {
        this.nPreVestir = nPreVestir;
    }

    public int getnCalzado() {
        return nCalzado;
    }
    public void setnCalzado(int nCalzado) {
        this.nCalzado = nCalzado;
    }

    public PreVestir[] getVectorVestir() {
        return vectorVestir;
    }
    public void setVectorVestir(PreVestir[] vectorVestir) {
        this.vectorVestir = vectorVestir;
    }

    public Calzado[] getVectorCalzado() {
        return vectorCalzado;
    }
    public void setVectorCalzado(Calzado[] vectorCalzado) {
        this.vectorCalzado = vectorCalzado;
    }

    //metodo para inicializar tienda
    private void surtirTienda(){
        for (int i = 0; i < getnPreVestir(); i++) guardarPreVestir(i);
        for (int i = 0; i < getnCalzado(); i++) guardarCalzado(i);
    }
    private void guardarPreVestir(int i){

        System.out.println("ingrese los datos para la PRENDA DE VESTIR ");

        System.out.println("código: ");
        String codigo = scanner.next();

        System.out.println("descripción: ");
        String description = scanner.next();

        System.out.println("precio de compra: ");
        double pcompra = scanner.nextDouble();

        System.out.println("precio de venta");
        double pventa = scanner.nextDouble();

        System.out.println("cantidad en bodega: ");
        int cantBodega = scanner.nextInt();

        //cantidad minima en bodega para alertar
        int cminreq = 10;

        //cantidad maxima de almacenamiento en bodega
        int cmaxreq = 100;

        System.out.println("Talla: (xs-s-m-l-xl-xxl)");
        String talla = scanner.next();

        System.out.println("planchado?: responde con un 'si' o 'no'");
        boolean planchado = scanner.next() == "si" ? true : false;

        vectorVestir[i] = new PreVestir(codigo, description,pcompra, pventa, cantBodega,cminreq, cmaxreq, talla, planchado);
    }
    private void guardarCalzado(int i){

        System.out.println("ingrese los datos para el CALZADO ");

        System.out.println("código: ");
        String codigo = scanner.next();

        System.out.println("descripción: ");
        String description = scanner.next();

        System.out.println("precio de compra: ");
        double pcompra = scanner.nextDouble();

        System.out.println("precio de venta");
        double pventa = scanner.nextDouble();

        System.out.println("cantidad en bodega: ");
        int cantBodega = scanner.nextInt();

        //cantidad minima en bodega para alertar
        int cminreq = 10;

        //cantidad maxima de almacenamiento en bodega
        int cmaxreq = 100;

        System.out.println("Talla: (24 a 45)");
        int talla = scanner.nextInt();

        vectorCalzado[i] = new Calzado(codigo, description, pcompra, pventa, cantBodega, cminreq, cmaxreq, talla);
    }

    public void consultarProducto() {
        System.out.println("Ingresa el tipo de producto: \n 1 para calzado \n 2 para prendas de vestir");
        int tipo = scanner.nextInt();


        if(tipo == 1){
            System.out.println("Ingresa el código del calzado: ");
            String codigo = scanner.next();

            for(Calzado c: vectorCalzado) {
                if(c.getCodigo().equals(codigo)){
                    System.out.println(c.toString());
                }else {
                    System.out.println("codigo de calzado no encontrado");
                }
            }

        } else if (tipo == 2) {
            System.out.println("Ingresa el código de la prenda de vestir: ");
            String codigo = scanner.next();

            for(PreVestir v: vectorVestir) {
                if(v.getCodigo().equals(codigo)){
                    System.out.println(v.toString());
                }else {
                    System.out.println("codigo de calzado no encontrado");
                }
            }

        }else{
            System.out.println("Código de producto no valido.");
        }
    }
    public String verificarProductos(){
        Boolean solicitarPedido = false;
        String codigosPedido = "Es necesario pedir los productos con código: ";

        for (PreVestir v: vectorVestir) {
            if(v.getCantBodega() <= v.getCminreq()){
                codigosPedido += v.getCodigo() + ", ";
                solicitarPedido = true;
            }
        }
        for (Calzado c: vectorCalzado) {
            if(c.getCantBodega() <= c.getCminreq()){
                codigosPedido += c.getCodigo() + ", ";
                solicitarPedido = true;
            }
        }

        if(solicitarPedido){
            JOptionPane.showMessageDialog(null, codigosPedido);
            return codigosPedido;
        }

        return "No es necesario realizar pedido";
    }
    public String preVestirDeMayorCantidadUnidades(){
        String codigo = "";
        int cantidad = 0;
        for (PreVestir v: vectorVestir) {
            if(v.getCantBodega() > cantidad){
                cantidad = v.getCantBodega();
                codigo = v.getCodigo();
            }
        }
        return "El código de la prenda de vestir con mayor cantidad de unidades es: " + codigo;
    }
    public String calzadoDeMayorCantidadUnidades(){
        String codigo = "";
        int cantidad = 0;
        for (Calzado c: vectorCalzado) {
            if(c.getCantBodega() > cantidad){
                cantidad = c.getCantBodega();
                codigo = c.getCodigo();
            }
        }
        return "El código del calzado con mayor cantidad de unidades es: " + codigo;
    }
    public void modificarCantMinReq(){
        System.out.println("Ingresa el tipo de producto: 1: calzado, 2: prenda de vestir");
        String tipo = scanner.next();

        if(tipo.equals("1")){
            Calzado cl = null;
            System.out.println("Ingresa el código del calzado: ");
            String codigo = scanner.next();

            for (Calzado c: vectorCalzado) {
                if(c.getCodigo().equals(codigo)) cl = c;
            }

            if(cl != null){
                System.out.println("Ingresa la nueva cantidad minina requerida: ");
                int cantidad = scanner.nextInt();
                if (cantidad >= 0) {
                    cl.setCminreq(cantidad);
                } else {
                    cl.setCminreq(0);
                }
                System.out.println("Producto actualizado");
            } else{
                System.out.println("Codigo no encontrado");
            }


        } else if (tipo.equals("2")) {

            PreVestir pV = null;
            System.out.println("Ingresa el códido de la prenda de vestir: ");
            String codigo = scanner.next();

            for (PreVestir v: vectorVestir) {
                if(v.getCodigo().equals(codigo)) pV = v;
            }

            if(pV != null){
                System.out.println("Ingresa la nueva cantidad minina requerida: ");
                int cantidad = scanner.nextInt();
                if (cantidad >= 0) {
                    pV.setCminreq(cantidad);
                } else {
                    pV.setCminreq(0);
                }
                System.out.println("Producto actualizado");
            } else{
                System.out.println("Codigo no encontrado");
            }


        }else {
            System.out.println("tipo de producto no valido");
        }
    }

    public void venderProducto(){
        System.out.println("Ingresa el tipo de producto: 1: calzado, 2: prenda de vestir");
        String tipo = scanner.next();

        if(tipo.equals("1")){
            Calzado cl = null;
            System.out.println("Ingresa el código del calzado: ");
            String codigo = scanner.next();

            for (Calzado c: vectorCalzado) {
                if(c.getCodigo().equals(codigo)) cl = c;
            }

            if(cl != null){
                System.out.println("Ingresa la cantidad a comprar: ");
                int cantidad = scanner.nextInt();
                if(cl.getCantBodega() > cantidad){
                    double precioTotal = cl.getPventa() * cantidad;
                    double sinDescuento = precioTotal;
                    double conDescuento = precioTotal - (precioTotal / 100);
                    cl.setCantBodega(cl.getCantBodega() - cantidad);

                    System.out.println("El precio del producto sin descuento fue del: " + sinDescuento + " y con descuento fue del: " + conDescuento);
                }
            } else{
                System.out.println("Codigo no encontrado");
            }
        } else if (tipo.equals("2")) {

            PreVestir pV = null;
            System.out.println("Ingresa el códido de la prenda de vestir: ");
            String codigo = scanner.next();

            for (PreVestir v: vectorVestir) {
                if(v.getCodigo().equals(codigo)) pV = v;
            }

            if(pV != null){
                System.out.println("Ingresa la cantidad a comprar: ");
                int cantidad = scanner.nextInt();
                if(pV.getCantBodega() > cantidad){
                    double precioTotal = pV.getPventa() * cantidad;
                    double sinDescuento = precioTotal;
                    double conDescuento = precioTotal - (precioTotal / 100);
                    pV.setCantBodega(pV.getCantBodega() - cantidad);

                    System.out.println("El precio del producto sin descuento fue del: " + sinDescuento + " y con descuento fue del: " + conDescuento);
                }
            } else{
                System.out.println("Codigo no encontrado");
            }


        }else {
            System.out.println("tipo de producto no valido");
        }
    }
}
