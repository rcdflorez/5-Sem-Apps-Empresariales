package org.example;

import java.util.Scanner;

public class Ciclos_6_7 {

    public int calcularPrecioXCliente(){
        int cuentaTotal = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero de productos: ");
        int cantidadProductos = scanner.nextInt();

        for (int i = 1; i <= cantidadProductos; i++) {
            System.out.println("Ingrese cantidad del producto " + i + ":");
            int cantidadProducto = scanner.nextInt();

            System.out.println("Ingrese el valor del producto " + i + ":");
            int valorProducto = scanner.nextInt();

            cuentaTotal += (cantidadProducto * valorProducto);
        }
        System.out.println("Total de la factura: " + cuentaTotal);
        return cuentaTotal;
    }

    public String calcularPrecioXMesa(){
        boolean cliente = true;
        Scanner scanner = new Scanner(System.in);
        int totalVendido = 0;
        int i = 1;
        while (cliente){
            System.out.println("cliente: " + i);

            totalVendido += calcularPrecioXCliente();

            System.out.println("agregar cliente? si o no");
            String add = scanner.nextLine();
            cliente = add.equals("si") ? true : false;
            i++;
        }
        return "total vendido: " + totalVendido;
    }
}
