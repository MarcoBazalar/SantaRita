package pe.upc.proyecto;

import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.stream.Stream;

public class ProyectoParcial {

    /* Ejemplo: Almacen = AZU1000477150323

          (0,3)    AZU = Nombre del producto
          (3,6)    100 = Cantidad de productos (kilos, litros, unidades)
          (6,10)   0477 = Precio en soles (00.00)
          (10,16)  150323 = Fecha de vencimiento (DD/MM/AA)

    Productos: Arroz = ARR    / Yogurt = YOG
               Azucar = AZU   / Detergente = DET
               Aceite = ACE   / Sal = SAL
               Huevo = HUE    / Shampoo = SHA
               Atun = ATU     / Mani = MAN
               Dulces = DUL   / Frituras = FRI

     */


    static String[] almacen = {"ARR0290288040725", "AZU0400200200723","ACE0791300170823", "HUE1000030220923","ATU0620248040923", "DUL2100073040724", "YOG0600500100224", "DET0600320151223", "SAL1200100160725","SHA0500950011023","MAN0350540040923", "FRI0520070011123"};
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese producto: ");
        String producto = sc.next();
        System.out.println("**************************");
        System.out.println("INFORMACION");
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidadDeProductos(producto));
        System.out.println("Precio de compra: " + precioDeCompra(producto));
        DecimalFormat precioVentaDecimal = new DecimalFormat("0.##");
        System.out.println("Precio de venta: " + precioVentaDecimal.format(precioDeVenta(producto)));
        System.out.println("Fecha de vencimiento: " + diaDeVenc(producto) + "/" + mesDeVenc(producto) + "/" + anioDeVenc(producto));
        System.out.println("**************************");
    }

    public static int cantidadDeProductos(String producto){

        int stock = 0;
        for (int i = 0; i < almacen.length; i++) {
            if (almacen[i].substring(0,3).equalsIgnoreCase(producto)){
                stock+= Integer.parseInt(almacen[i].substring(3,6));
            }
        }
        return stock;
    }

    public static double precioDeCompra(String producto){
        double precioCompra = 0;
        for (int i = 0; i < almacen.length; i++) {
            if (almacen[i].substring(0,3).equalsIgnoreCase(producto)){
                precioCompra += (Double.parseDouble(almacen[i].substring(6,10)) / 100);
            }
        }
        return precioCompra;
    }

    public static double precioDeVenta(String producto){
        double precioVenta = 0;
        for (int i = 0; i < almacen.length; i++) {
            if (almacen[i].substring(0,3).equalsIgnoreCase(producto)){
                precioVenta += (Double.parseDouble(almacen[i].substring(6,10)) *1.3) /100;
            }
        }
        return precioVenta;

    }

    public static int diaDeVenc(String producto){

        int dia = 0;
        for (int i = 0; i < almacen.length; i++) {
            if (almacen[i].substring(0,3).equalsIgnoreCase(producto)){
                dia+= Integer.parseInt(almacen[i].substring(10,12));
            }
        }
        return dia;
    }

    public static int mesDeVenc(String producto){

        int mes = 0;
        for (int i = 0; i < almacen.length; i++) {
            if (almacen[i].substring(0,3).equalsIgnoreCase(producto)){
                mes+= Integer.parseInt(almacen[i].substring(12,14));
            }
        }
        return mes;
    }



    public static int anioDeVenc(String producto){

        int anio = 0;
        for (int i = 0; i < almacen.length; i++) {
            if (almacen[i].substring(0,3).equalsIgnoreCase(producto)){
                anio+= Integer.parseInt(almacen[i].substring(14,16));
            }
        }
        return anio;
    }

}
