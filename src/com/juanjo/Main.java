package com.juanjo;

import controller.Menu;
import java.util.Scanner;
import java.lang.String;

public class Main
{
    public static void main(String[] args)
    {

        String checkUser;

        // introduce el nombre del usuario si no te echa.
        String user = "juanjo";

        Menu presentationMenu = new Menu ();

        Scanner teclado = new Scanner(System.in);

            System.out.println("Introduzca tu nombre:");
            checkUser = teclado.next();



            if (checkUser.equals(user))
            {
                presentationMenu.start();
            }
        }
    /**
     * Intoduce el usuario correspodiente al String user y si es asi te entra en el programa si no te saca.
     */
}



