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
//Declarar Constante
        final int CANTCUARTOS = 5;

//Declarar variables
//Variables INT
        int opcion, contador = 0, contador2 = 0;
//Variables boolean
        boolean repetir = true;

        //Variables Double
        double metros, total, carga, banio = 0, salon = 0, cocina = 0, dormi = 0, dormi2 = 0;

//Variables String
        String texto = "";
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
            if (opcion > 1 && contador == 1) {
                JOptionPane.showMessageDialog(null, "Debes Configurar el Sistema antes de poder elegir otra opción");
                //Te reidirije a la opcion uno
                opcion = 1;

            }
//Switch para realizar las acciones del menú anterior
            switch (opcion) {
//Case 1 es el de configurar el Sistema, donde estableceremos los metros de las habitaciones
                case 1:
//Bucle que se repite por cada habitación
                    do {
//Contador para introducir el tamaño solo a las 5 habitaciones
                        contador2++;
//Aparecerá segun el orden del contador y añadiremos el tamaño a cada uno                        
                        switch (contador2) {
                            case 1:
                                texto = "el cuarto de baño";
                                break;
                            case 2:
                                texto = "la cocina";
                                break;
                            case 3:
                                texto = "el salón";
                                break;
                            case 4:
                                texto = "el dormitorio 1";
                                break;
                            case 5:
                                texto = "el dormitorio 2";
                                break;
                        }

//Bucle para limitar los metros en cada cuarto
                        do {
//Mensaje que aparecerá por cada habitación que hay y le introduciremos los metros que tiene cada uno (String)  
                            String metrosString = JOptionPane.showInputDialog(null, "Cuantos m² tiene " + texto);
//Convertir el valor String a un valor Double
                            metros = Double.parseDouble(metrosString);
//Switch que guarda los metros cuadrados de cada cuarto en especifico
                            switch (contador2) {
                                case 1:
                                    banio = metros;
                                    break;
                                case 2:
                                    cocina = metros;
                                    break;
                                case 3:
                                    salon = metros;
                                    break;
                                case 4:
                                    dormi = metros;
                                    break;
                                case 5:
                                    dormi2 = metros;
                                    break;
                            }
//Calculo de los metros total de toda la casa
                            total = banio + cocina + salon + dormi + dormi2;
//If que aparecerá si se introduce un valor no permitido en el bucle
                            if (metros < 1 || metros > 100) {
                                JOptionPane.showMessageDialog(null, "Valor no valido");
                            }

                        } while (metros < 1 || metros > 100);
                    } while (contador2 != CANTCUARTOS);

//Mensaje que muestra el tamaño total de toda la casa
                    JOptionPane.showMessageDialog(null, "Las " + contador2 + " habitaciones tienen un tamaño total de " + total + " m^2");
//Para que se resté el contador 2
                    contador2 = 0;

                    break;

//Case 2 es el que se encarga de asignar el % de bateria en ese momento de la aspiradora
                case 2:
//Bucle que limita el valor que podemos introducir entre 0 y 100
                    do {
//Introducir la cantidad de carga que tiene el robot(String)
                        String cargaString = JOptionPane.showInputDialog(null, "Cuanto % de batería tiene el robot actualmente:");
//Convertir el valor String al valor Double
                        carga = Double.parseDouble(cargaString);
//If que muestra un mensaje cuando se introduce un valor que no está permitido
                        if (carga < 0 || carga > 100) {
                            JOptionPane.showMessageDialog(null, "Valor no valido..");
                        }
                    } while (carga < 0 || carga > 100);
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 0:
//Me permite salir del bucle y finalizar el programa
                    repetir = false;
                    break;

            }

        } while (repetir);
        //Mensaje que se muestra al finalizar el programa
        JOptionPane.showMessageDialog(null, "Saliendo del programa....");

    }
}
