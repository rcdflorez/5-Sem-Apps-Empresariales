package org.example;

import javax.swing.*;
import java.util.Scanner;

public class Condicionales_1_4 {
    private int cantidadBodega;
    private int dineroEnCaja;
    private int precioProductoXUnidad;

    //Constructor...
    public Condicionales_1_4(int cantidadBodega, int dineroEnCaja, int precioProductoXUnidad) {
        this.cantidadBodega = cantidadBodega;
        this.dineroEnCaja = dineroEnCaja;
        this.precioProductoXUnidad = precioProductoXUnidad;
    }

    //Getters & Setters
    public int getCantidadBodega() {
        return cantidadBodega;
    }
    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public int getDineroEnCaja() {
        return dineroEnCaja;
    }

    public void setDineroEnCaja(int dineroEnCaja) {
        this.dineroEnCaja = dineroEnCaja;
    }

    public int getPrecioProductoXUnidad() {
        return precioProductoXUnidad;
    }

    public void setPrecioProductoXUnidad(int precioProductoXUnidad) {
        this.precioProductoXUnidad = precioProductoXUnidad;
    }

    //Metodos Ejercicio
    public String condicionSimple(int cantidadRequerida){
        if (getCantidadBodega() < cantidadRequerida)
            return ("Es necesario realizar el pedido al proveedor");
        return ("No es necesario realizar el pedido al proveedor");
    }

    public String condicionDoble(int cantidadRequerida){
        if (getCantidadBodega() < cantidadRequerida) {
            return ("Es necesario realizar el pedido al proveedor");
        } else {
            return ("No es necesario realizar el pedido al proveedor");
        }
    }

    public String condicionMultiple(int cantidadRequerida){
        if (getCantidadBodega() > cantidadRequerida) {
            setCantidadBodega(getCantidadBodega() - cantidadRequerida);
        }else{
            return ("Es necesario realizar el pedido al proveedor");
        }
        if(getCantidadBodega() <= 10){
            JOptionPane.showMessageDialog(null, "Alerta! quedan menos de 10 unidades en bodega.");
            String cantidadActual = "No es necesario realizar el pedido al proveedor. Unidades que hacen falta vender: " + getCantidadBodega() + ". Alerta generada.";
            return (cantidadActual);
        }else{
            String cantidadActual = "No es necesario realizar el pedido al proveedor. Unidades que hacen falta vender: " + getCantidadBodega();
            return (cantidadActual);
        }
    }

    public String condicionAnidado(int cantidadRequerida){
        if (getCantidadBodega() > cantidadRequerida) {
            setCantidadBodega(getCantidadBodega() - cantidadRequerida);
            if(getCantidadBodega() <= 10){
                JOptionPane.showMessageDialog(null, "Alerta! quedan menos de 10 unidades en bodega.");
                String cantidadActual = "No es necesario realizar el pedido al proveedor. Unidades que hacen falta vender: " + getCantidadBodega() + ". Alerta generada.";
                return (cantidadActual);
            }
            String cantidadActual = "No es necesario realizar el pedido al proveedor. Unidades que hacen falta vender: " + getCantidadBodega();
            return (cantidadActual);
        }else {
            System.out.println("Es necesario realizar el pedido al proveedor");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese cantidad de productos:");

            int cantidadDeseada = scanner.nextInt();
            int valorCompra = cantidadDeseada * getPrecioProductoXUnidad();
            if( valorCompra <= getDineroEnCaja()){
                return ("Cantidades de compra deseada: " + cantidadDeseada + ". Valor de compra: " + valorCompra + ", Valor en caja: " + getDineroEnCaja() + ". Si es posible realizar el pedido");
            }else{
                return ("Cantidades de compra deseada: " + cantidadDeseada + ". Valor de compra: " + valorCompra + ", Valor en caja: " + getDineroEnCaja() + ". No es posible realizar el pedido");
            }
        }
    }


}
