package controller;

/**
 * Created by Juanjo on 06/06/2017.
 */

import model.Producto;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static controller.Procesos.*;


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
                    //ordena por precio
                    ordeName(compraList);
                    break;
                case 3:
                    // ordenar por precio
                    ordePrice(compraList);
                    break;
                case 5:
                    //Eliminar producto
                    if (compraList.size() > 0) {
                        deleteProd(compraList);
                    }
                    break;
                case 6:
                    // Ver Lista de producto
                    showProd(compraList);
                    break;
                case 7:
                    //Total de precio y todos los productos
                    showPrice(compraList);
                    break;
                case 8:
                    //Pagar el dinero total y si no es igual decir la vuelta
                    PayReturn(compraList);
                    break;
                default:
                    break;
            }

        }
        saveProd(ArrayList <Producto> compraList);
    }

    /**
     *
     * @param compraList contiene el arraylist con todos los case.
     *
     */



    public static int showMenu(ArrayList<Producto> compraList) {

        int option = 0;
        boolean index=true;

        while (index){
            Scanner input = new Scanner(System.in);
            try {
            index=false;
            System.out.println("|------------------------------|");
            System.out.println("|       SISTEMA DE VENTAS      |");
            System.out.println("|------------------------------|");
            System.out.println("| 1 - Añadir Producto          |");
            System.out.println("| 2 - Ordenar por nombre       |");
            System.out.println("| 3 - Ordenar por precio       |");
            System.out.println("| 4 - Buscar producto          |");
            System.out.println("| 5 - Eliminar Producto        |");
            System.out.println("| 6 - Mostrar lista artículos  |");
            System.out.println("| 7 - Importe total            |");
            System.out.println("| 8 - Pagar y Imprimir factura |");
            System.out.println("| 0 - Salir                    |");
            System.out.println("|______________________________|");
            System.out.println("Opción: ");
                option = input.nextInt();

                if (option == 0 || option ==1 || option == 2 || option== 3 || option == 4 || option == 5 || option==6 || option ==7 || option == 8){
                    index = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Introduce un numero correcto.");
                index = true;
            }

        }
        return option;
    }
}
