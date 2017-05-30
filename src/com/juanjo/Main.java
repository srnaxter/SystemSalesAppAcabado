package com.juanjo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList compraList = new ArrayList();

        int option;
        while( ( option = showMenu(compraList) ) != 0){
            switch (option){
                case 1:
                    // Añadir producto
                    addProd(compraList);
                    break;
                case 2:
                    //Eliminar producto
                    if( compraList.size() > 0 ){
                        deleteProd(compraList);
                    }
                    break;
                case 3:
                    // Ver Lista de producto
                    showProd(compraList);
                case 4:
                    //Total de precio y pagar y dinero a devolver
                    showPrice(compraList);

                    break;
                default:
            }
        }
    }

    public static void deleteProd(ArrayList myList){
        Scanner input = new Scanner(System.in);
        int index;

        showProd(myList);

        do{
            System.out.printf("Introducir el índice: ");
            index = input.nextInt();
        }while( !correctIndex(index, myList) );


        myList.remove(index);

    }

    public static boolean correctIndex(int index, ArrayList myList){
        if( index >=0 && index < myList.size() ){
            return true;
        }else{
            return false;
        }
    }

    public static void addProd(ArrayList myList){
        Scanner input = new Scanner(System.in);
        String list;
        Double price;

        do{
            System.out.println("Introducir Producto:");
            list = input.nextLine();

            System.out.println("Introducir Precio:");
            price = input.nextDouble();

        }while( list.length() == 0);

        myList.add( list + " = " + price + " €" );



    }

    public static void showProd(ArrayList myList){
        int index = 0;
        for (Object list: myList) {
            System.out.println( (index++) + " - " + list);
        }

    }

    public static void showPrice(ArrayList <Producto> myList){
        double total = 0;

        for (Producto p : myList){

          total = total +  p.getPrecio();

        }
    }

    public static int showMenu(ArrayList myList){
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("*******************************");
        System.out.println("* 1 - Añadir Producto         *");
        System.out.println("* 2 - Eliminar Producto       *");
        System.out.println("* 3 - Mostrar lista artículos *");
        System.out.println("* 4 - Importe total y pagar   *");
        System.out.println("* 0 - Salir                   *");
        System.out.println("*******************************");
        System.out.println("Opción: ");

        option = input.nextInt();

        return option;
    }
}