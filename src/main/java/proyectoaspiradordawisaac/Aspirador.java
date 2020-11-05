/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoaspiradordawisaac;

import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class Aspirador {

    public static void main(String[] args) {
//Declarar variables
//Variables INT
        int opcion, contador = 0;
//Variables boolean
        boolean repetir = true;
//Blucle Do Wile, que se repite  todo el programa o finaliza el programa si el valor repetir es false
        do {
//Bucle Do While,Que se repite si introduces un valor que no esté dentro del menú
            do {
//Menú donde eligiremos la opción que deseamos realizar 
                contador++;
                String opcionString = JOptionPane.showInputDialog(null, "Seleccione la opción deseada:\n"
                        + "1-Configurar el Sistema\n"
                        + "2-Carga\n"
                        + "3-Aspiración\n"
                        + "4-Aspiración y fregado\n"
                        + "5-Estado general\n"
                        + "6-Base de carga\n"
                        + "0-Salir\n");

//Convertir el valor String anterior a un valor Int
                opcion = Integer.parseInt(opcionString);

            } while (opcion < 0 || opcion > 6);
            
//If para obligar a Configurar el sistema la primera vez que iniciemos el programa
            if (opcion != 1 && contador == 1) {
                JOptionPane.showMessageDialog(null, "Debes Configurar el Sistema antes de poder elegir otra opción");
            //Te reidirije a la opcion uno
                opcion = 1;
           
            }

        } while (repetir);
//Mensaje que se muestra al finalizar el programa
        JOptionPane.showMessageDialog(null, "Saliendo del programa....");
    }
}
