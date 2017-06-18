package controller;

import model.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Juanjo on 07/06/2017.
 */
public class Procesos {

    public static void deleteProd(ArrayList<Producto> compraList) {
        Scanner input = new Scanner(System.in);
        int index;

        showProd(compraList);

        do {
            System.out.printf("Introducir el índice: ");
            index = input.nextInt();
        } while (!correctIndex(index, compraList));


        compraList.remove(index);


    }

    /**
     *
     * @param index elimina el numero que pongas en el input llamando index
     * @param compraList dentro de mi arraylist
     * @return
     */


    public static boolean correctIndex(int index, ArrayList<Producto> compraList) {
        if (index >= 0 && index < compraList.size()) {
            return true;
        } else {
            return false;
        }
    }



    public static void addProd(ArrayList<Producto> compraList) {
        String list;
        double price = 0;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Introducir Producto:");
            list = input.nextLine();

            boolean index=true;

            while (index){
                Scanner inputTwo = new Scanner(System.in);
                try {
                    index=false;

                    System.out.println("Introducir Precio:");
                    price = inputTwo.nextDouble();

                    if (price>0){
                        index = false;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Introduce un numero correcto.");
                    index = true;
                }

            }



        } while (list.length() == 0);

        compraList.add(new Producto(list, price));

    }

    /**
     * addProd añade un producto string y un precio double al arraylist
     * @param compraList
     */

    public static void showProd(ArrayList<Producto> compraList) {
        int index = 0;
        for (Producto p :compraList) {
            System.out.println(p.toString());
        }

    }

    /**
     * showProd muestra todos los productos y precios añadidos a la arraylist
     * @param compraList
     */

    public static void showPrice(ArrayList<Producto> compraList) {
        double total = 0;


        for (Producto p : compraList) {

            total = total + p.getPrecio();
            System.out.println(p.toString());
        }

        System.out.println("Total de los productos: " + total + "€");
    }

    /**
     * showPrice te muestra todos los articulos y precio y al final te dice un total de todos
     * @param compraList
     */

    public static void PayReturn(ArrayList<Producto> compraList){

        FileWriter fichero = null;
        PrintWriter pw = null;
        double factura = 0;
        double pago = 0;
        String prod = new String();
        double devolver = 0;


        for (Producto f: compraList){
            prod = prod + f.toString();
            factura = factura + f.getPrecio();
        }

        System.out.println("Precio total= " + factura + "€");

        boolean index=true;

        while (index){
            Scanner input = new Scanner(System.in);
            try {
                index=false;

                System.out.println("Dinero a introducir:");
                pago  = input.nextDouble();

                if (pago>0){
                    index = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Introduce un numero correcto.");
                index = true;
            }

        }


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
     * @return
     */

    public static void saveProd(ArrayList<Producto>compraList) {
        try {
            ObjectOutputStream saveProd = new ObjectOutputStream(new FileOutputStream("productos.dat"));
            saveProd.writeObject(compraList);
            saveProd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadProd(ArrayList<Producto>compraList){
        try {
            ObjectInputStream readProd = new ObjectInputStream(new FileInputStream("productos.dat"));
            compraList = (ArrayList<Producto>) readProd.readObject();
            readProd.close();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void ordeName(ArrayList<Producto>compraList){
        Collections.sort(compraList, new Producto());
        Procesos.showProd(compraList);

    }

    public static void ordePrice(ArrayList<Producto>compraList){
        Collections.sort(compraList, Procesos.comparePrice);
        Procesos.showProd(compraList);
    }

    private static Comparator<Producto> comparePrice = new Comparator<Producto>() {
        @Override
        public int compare(Producto o1, Producto o2) {
            return (int)(o2.getPrecio() - o1.getPrecio());
        }
    };

}
