package org.sesion2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tienda t = new Tienda();

        boolean init = true;
        System.out.println("Bienvenido a nuestra tienda:");

        while (init){
            System.out.println("Menu: \n " +
                    "1: consultar información del producto \n " +
                    "2: Verificar productos a pedir \n " +
                    "3: Consultar la prenda de vestir con mayor cantidad de unidades en inventario \n " +
                    "4: Consultar el calzado con mayor cantidad de unidades en inventario \n " +
                    "5: Modificar cantidad mínima requerida en bodega \n " +
                    "6: Vender un producto \n " +
                    "0 para finalizar");
            String menu = scanner.next();
            switch (menu){
                case "0":
                    init = false;
                    break;
                case "1":
                    t.consultarProducto();
                    break;
                case "2":
                    System.out.println(t.verificarProductos());
                    break;
                case "3":
                    System.out.println(t.preVestirDeMayorCantidadUnidades());
                    break;
                case "4":
                    System.out.println(t.calzadoDeMayorCantidadUnidades());
                    break;
                case "5":
                    t.modificarCantMinReq();
                    break;
                case "6":
                    t.venderProducto();
                    break;
                default:
                    System.out.println("ingresa un valor válido");
            }
        }

        System.out.println("Fin del programa");

    }
}