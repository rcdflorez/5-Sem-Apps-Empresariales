package org.example;

public class SwitchCase_5 {

    public String calcularDescuento(int diaSemana, double totalSinDescuento){
        int descuento = 0;
        switch (diaSemana){
            case 1:
                descuento = 5;
                break;
            case 2:
                descuento = 3;
                break;
            case 3:
                descuento = 10;
                break;
            case 4:
                descuento = 4;
                break;
            case 5:
                descuento = 6;
                break;
            case 6:
                descuento = 2;
                break;
            case 7:
                descuento = 1;
                break;
            default:
                return "día no valido";
        }
        double totalConDescuento = totalSinDescuento - ( totalSinDescuento * descuento / 100);
        return "total a pagar con descuento: $" + totalConDescuento;
    }

}