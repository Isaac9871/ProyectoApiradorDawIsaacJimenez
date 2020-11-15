/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoaspiradordawisaac;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class Aspirador {

    public static void main(String[] args) {
//Con este objeto limitamos los decimales del resultado en solo 2 decimales
        DecimalFormat formato = new DecimalFormat("#.##");
//Declarar Constante
        final int CANTCUARTOS = 5;

        final double METROSCIENCARGA = 66.67, CARGATOTAL = 100, CARGAXMETRO = 1.5;

//Declarar variables
//Variables boolean
        boolean repetir = true;

//Variables INT
        int //Variables para el Menú Inicial
                opcion, contador = 0,
                //Variables del case 1
                contador2 = 0,
                //Variables del case 3
                aspirar, contadorMlimpiar = 0;

//Variables Double
        //Variables del case 1
        double metros, total = 0, banio = 0, salon = 0, cocina = 0, dormi = 0, dormi2 = 0,
                //Variables del case 2  
                carga = 0,
                //Variables del case 3 
                reglaTresBanio = 0, dosHabi = 0, tresHabi = 0, cuatroHabi = 0, cincoHabi = 0;

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

//If que no permite el acceso al case 3 si no tiene el aspirador más de 3% de bateria
                    if (carga <= 3) {
//Mensaje que informa en el caso de que no puedas acceder
                        JOptionPane.showMessageDialog(null, "No tiene suficiente batería para poder realizar ninguna acción, carga la batería antes ");
                    } else {

//Bucle que se repitirá en el caso de no introducir un valor valido
                        do {
//Menú del case 3 donde podremos elegir los dos modos difetentes que podemos realizar (Introducir un valor String)
                            String aspiracionString = JOptionPane.showInputDialog(null, "Seleccione la opción deseada:\n"
                                    + "1-Modo Completo\n"
                                    + "2-Modo Dependencias\n");
//Cambiar el valor String anterior a un valor Int
                            aspirar = Integer.parseInt(aspiracionString);
//If que nos muestra un mensaje en el caso de que el valor introducido no sea valido
                            if (aspirar < 1 || aspirar > 2) {
                                JOptionPane.showMessageDialog(null, "Valor no valido..");
                            }
                        } while (aspirar < 1 || aspirar > 2);
//If que nos envia de nuevo al modelo completo si no se a terminado antes
                        if (contadorMlimpiar < total && aspirar == 2 && contadorMlimpiar > 1) {
                            JOptionPane.showMessageDialog(null, "Debes terminar el Modo Completo en proceso antes de elegir de nuevo otra opción.");
                            aspirar = 1;
                        }
//Operaciones de los tamaños de habitaciones
                        dosHabi = banio + cocina;

                        tresHabi = banio + cocina + salon;

                        cuatroHabi = banio + cocina + salon + dormi;

                        cincoHabi = banio + cocina + salon + dormi + dormi2;
//Switch donde tendremos las dos opciones de aspirar
                        switch (aspirar) {
                            case 1:
//For que se repitirá hasta que se complete todos los metros
                                for (int i = contadorMlimpiar; i < total; i++) {
//Contador de los metros limpiados por 1.5 de bateria
                                    contadorMlimpiar++;
//Bateria perdida por cada metro
                                    carga -= CARGAXMETRO;
                                    
                                    //Para comprobar que se realizaba el bucle correctamente
                                   // System.out.println(carga + " metros= " + contadorMlimpiar);
//If que nos muestra un mensaje en el caso de que el tamaño de la habitacion sea demasiado grande para que nuestra aspiradora pueda aspirarla    
                                    if (banio >= METROSCIENCARGA) {

                                        JOptionPane.showMessageDialog(null, "La habitación es demasiado grande para que pueda limpiarlo la aspiradora.\n"
                                                + "La aspiradora con 100% de carga, puede limpiar hasta 66m^2");
                          //Los break fuerza la salida del bucle for
                                        break;
                                    }
//If en el caso que no haya bateria suficiente para limpiar el baño
                                    if (carga < reglaTresBanio && contadorMlimpiar < banio) {
                                        JOptionPane.showMessageDialog(null, "No hay suficiente bateria para limpiar el baño. \n"
                                                + "Ve a la base de Carga");
                                        break;
//If que cuando el contador sea igual a los metros del baño, aspirará todo el baño
                                    } else if (contadorMlimpiar == banio) {
                                        JOptionPane.showMessageDialog(null, "Aspirando Baño...");
                                        JOptionPane.showMessageDialog(null, "El baño ha sido Apirado.\n"
                                                + "Bateria restante " + carga + " % ");
//If que nos avisa que no hay bateria suficiente para aspirar la cocina
                                        if (carga < (CARGAXMETRO * cocina)) {
                                            JOptionPane.showMessageDialog(null, "No hay suficiente bateria para limpiar la cocina. \n"
                                                    + "Ve a la base de Carga");
                                            break;
                                        }
                                    }
//If que cuando el contador sea igual a los metros de la cocina, aspirará todo la cocina
                                    if (contadorMlimpiar == dosHabi) {
                                        JOptionPane.showMessageDialog(null, "Aspirando Cocina...");
                                        JOptionPane.showMessageDialog(null, "La cocina ha sido Apirado.\n"
                                                + "Bateria restante " + carga + " % ");
//If que nos avisa que no hay bateria suficiente para aspirar el salon
                                        if (carga < (CARGAXMETRO * salon)) {
                                            JOptionPane.showMessageDialog(null, "No hay suficiente bateria para limpiar el Salón. \n"
                                                    + "Ve a la base de Carga");
                                            break;
                                        }

                                    }
//If que cuando el contador sea igual a los metros del salon, aspirará todo el salon
                                    if (contadorMlimpiar == tresHabi) {
                                        JOptionPane.showMessageDialog(null, "Aspirando el Salón...");
                                        JOptionPane.showMessageDialog(null, "El Salón ha sido Apirado.\n"
                                                + "Bateria restante " + carga + " % ");
//If que nos avisa que no hay bateria suficiente para limpiar el dormitorio 1
                                        if (carga < (CARGAXMETRO * dormi)) {
                                            JOptionPane.showMessageDialog(null, "No hay suficiente bateria para limpiar el Dormitrio(1). \n"
                                                    + "Ve a la base de Carga");
                                            break;
                                        }

                                    }
//If que cuando el contador sea igual a los metros del dormitorio, aspirará todo el dormitorio 1
                                    if (contadorMlimpiar == cuatroHabi) {
                                        JOptionPane.showMessageDialog(null, "Aspirando el Dormitorio(1)");
                                        JOptionPane.showMessageDialog(null, "El Dormitorio(1) ha sido Apirado.\n"
                                                + "Bateria restante " + carga + " % ");
//If que nos avisa que no hay bateria suficiente para limpiar el dormitorio 2
                                        if (carga < (CARGAXMETRO * dormi2)) {
                                            JOptionPane.showMessageDialog(null, "No hay suficiente bateria para limpiar el Dormitorio(2). \n"
                                                    + "Ve a la base de Carga");
                                            break;
                                        }

                                    }
//If que cuando el contador sea igual a los metros del dormitorio 2, aspirará todo el dormitorio 2
                                    if (contadorMlimpiar == cincoHabi) {
                                        JOptionPane.showMessageDialog(null, "Aspirando el Dormitorio(2)");
                                        JOptionPane.showMessageDialog(null, "El Dormitorio(2) ha sido Apirado.\n"
                                                + "Bateria restante " + carga + " % ");
                                    }
//If que nos informa de que hemos limpiado todas las habitaciones
                                    if (contadorMlimpiar == total) {
                                        JOptionPane.showMessageDialog(null, "Todas las habitaciones han sido limpiadas");
                                        break;
                                    }
//If que nos avisa que la bateria se a agotado
                                    if (carga <= 3) {
                                        JOptionPane.showMessageDialog(null, "Bateria agotada. Ve a la Base de carga");
                                        carga = 3;
                                        break;
                                    }

                                }
//If que resetea el contador cuando se haya completado la limpieza de todas las habitaciones
                                if (contadorMlimpiar == total) {
                                    contadorMlimpiar = 0;
                                }
                                break;

                            case 2:
                                break;
                        }

                    }
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Colocandose en la base de carga ");
//Bucle que carga la bateria de la aspiradora hasta 100%
                    while (carga < 100) {
//Velocidad a la que se carga la batería
                        carga = carga + 1 + (carga * 40) / 100;
//If que en el caso que sobrepase el 100% lo pondrá en 100 
                        if (carga > 100) {
                            carga = 100;
                        }
//Mensaje que se muestra cada vez que se repite el bucle y muestra la batería en ese momento
                        JOptionPane.showMessageDialog(null, "Batería actual: " + formato.format(carga) + " % ");
                    }
//Mensaje cuando la batería esta totalmente cargada
                    if (carga == 100) {
                        JOptionPane.showMessageDialog(null, "La bateria esta totalmente cargada");
                    }
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
