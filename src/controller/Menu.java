package controller;

/**
 * Created by Juanjo on 06/06/2017.
 */

import model.Producto;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;



public class Menu {
    public void start(){

        ArrayList<Producto> compraList = new ArrayList();

        int option;
        while ((option = showMenu(compraList)) != 0) {
            switch (option) {
                case 1:
                    // Añadir producto
                    addProd(compraList);
                    break;
                case 2:
                    //Eliminar producto
                    if (compraList.size() > 0) {
                        deleteProd(compraList);
                    }
                    break;
                case 3:
                    // Ver Lista de producto
                    showProd(compraList);
                    break;
                case 4:
                    //Total de precio y todos los productos
                    showPrice(compraList);
                    break;
                case 5:
                    //Pagar el dinero total y si no es igual decir la vuelta
                    PayReturn(compraList);

                default:
            }
        }
    }

    /**
     *
     * @param myList contiene el arraylist con todos los case.
     *
     */

    public static void deleteProd(ArrayList<Producto> myList) {
        Scanner input = new Scanner(System.in);
        int index;

        showProd(myList);

        do {
            System.out.printf("Introducir el índice: ");
            index = input.nextInt();
        } while (!correctIndex(index, myList));


        myList.remove(index);


    }

    /**
     *
     * @param index elimina el numero que pongas en el input llamando index
     * @param myList dentro de mi arraylist
     * @return
     */


    public static boolean correctIndex(int index, ArrayList<Producto> myList) {
        if (index >= 0 && index < myList.size()) {
            return true;
        } else {
            return false;
        }
    }



    public static void addProd(ArrayList<Producto> myList) {
        Scanner input = new Scanner(System.in);
        String list;
        Double price;

        do {
            System.out.println("Introducir Producto:");
            list = input.nextLine();

            System.out.println("Introducir Precio:");
            price = input.nextDouble();

        } while (list.length() == 0);

        myList.add(new Producto(list, price));

    }

    /**
     * addProd añade un producto string y un precio double al arraylist
     * @param myList
     */

    public static void showProd(ArrayList<Producto> myList) {
        int index = 0;
        for (Producto p : myList) {
            System.out.println(p.toString());
        }

    }

    /**
     * showProd muestra todos los productos y precios añadidos a la arraylist
     * @param myList
     */

    public static void showPrice(ArrayList<Producto> myList) {
        double total = 0;


        for (Producto p : myList) {

            total = total + p.getPrecio();
            System.out.println(p.toString());
        }

        System.out.println("Total de los productos: " + total + "€");
    }

    /**
     * showPrice te muestra todos los articulos y precio y al final te dice un total de todos
     * @param myList
     */

    public static void PayReturn(ArrayList<Producto> myList){


        Scanner input = new Scanner(System.in);
        FileWriter fichero = null;
        PrintWriter pw = null;
        double factura = 0;
        double pago = 0;
        String prod = new String();
        double devolver = 0;


        for (Producto f: myList){
            prod = prod + f.toString();
            factura = factura + f.getPrecio();
        }

        System.out.println("Precio total= " + factura + "€");

        System.out.println("Dinero a introducir:");
        pago  = input.nextDouble();
        devolver = pago - factura;

        System.out.println("Dinero a devolver: " + devolver + "€");

        System.out.println("Imprimiendo Ticket...");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println("...Ticket imprimido\n");

        try
        {
            fichero = new FileWriter("Factura.txt");
            pw = new PrintWriter(fichero);

            pw.println(prod + "\n" + " Total " + factura + "€");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * PayReturt te dice el precio total de todos y te salta un double para que introduzca lo que te a pagado
     * te devuelve el dinero a devolver sobre el precio total y te imprime un .txt con el ticket
     * @param myList
     * @return
     */

    public static int showMenu(ArrayList<Producto> myList) {
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("|------------------------------|");
        System.out.println("|       SISTEMA DE VENTAS      |");
        System.out.println("|------------------------------|");
        System.out.println("| 1 - Añadir Producto          |");
        System.out.println("| 2 - Eliminar Producto        |");
        System.out.println("| 3 - Mostrar lista artículos  |");
        System.out.println("| 4 - Importe total            |");
        System.out.println("| 5 - Pagar y Imprimir factura |");
        System.out.println("| 0 - Salir                    |");
        System.out.println("|______________________________|");
        System.out.println("Opción: ");

        option = input.nextInt();

        return option;
    }
}
