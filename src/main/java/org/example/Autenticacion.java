package org.example;
import java.util.Scanner;

public class Autenticacion {
    public static void main(String[] args) {

        Scanner lea = new Scanner(System.in);
        String usuario;
        String usuarioBD = "tomas0304";
        String contrasenaBD = "tomas0304";
        String contrasena;
        String usuarioDestino;

        int opcion;
        int intentos = 0;
        int maxIntentos = 3;
        double saldo = 10000;
        double valorRetiro;
        double cantidadEnviar;

        while (intentos < maxIntentos) {
            System.out.print("Ingrese su usuario: ");
            usuario = lea.nextLine();

            if (!usuario.equals(usuarioBD)) {
                System.out.println("Usuario incorrecto.");
                intentos++;
            }

            System.out.print("Ingrese su contraseña: ");
            contrasena = lea.nextLine();

            if (contrasena.equals(contrasenaBD)) {
                System.out.println("¡Ingreso exitoso!");

                while (true) {
                    System.out.println("Saldo actual: $" + saldo);
                    System.out.println("1. Retirar dinero");
                    System.out.println("2. Enviar dinero");
                    System.out.println("3. Salir");
                    System.out.print("Seleccione una opción: ");
                    opcion = lea.nextInt();

                    if (opcion == 1) {
                        System.out.print("¿Cuánto desea retirar? ");
                         valorRetiro = lea.nextDouble();

                        if (valorRetiro < 0) {
                            System.out.println("El valor de retiro no puede ser negativo. Inténtelo de nuevo.");
                        } else if (valorRetiro > saldo) {
                            System.out.println("No tiene suficiente saldo para realizar este retiro.");
                        } else {
                            saldo -= valorRetiro;
                            System.out.println("Retiro exitoso de $" + valorRetiro);
                            System.out.println("Saldo restante: $" + saldo);
                        }
                    } else if (opcion == 2) {
                        System.out.print("¿Cuánto dinero desea enviar? ");
                        cantidadEnviar = lea.nextDouble();
                        System.out.print("Ingrese el usuario de destino: ");
                        usuarioDestino = lea.next();


                        if (cantidadEnviar < 0) {
                            System.out.println("La cantidad a enviar no puede ser negativa. Inténtelo de nuevo.");
                        } else if (cantidadEnviar > saldo) {
                            System.out.println("No tiene suficiente saldo para realizar esta transferencia.");
                        } else {
                            saldo -= cantidadEnviar;
                            System.out.println("Se han enviado $" + cantidadEnviar + " a la cuenta de " + usuarioDestino);
                            System.out.println("Saldo restante: $" + saldo);
                        }
                    } else if (opcion == 3) {
                        break;
                    } else {
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                    }
                }
                break;
            } else {
                System.out.println("Contraseña incorrecta.");
            }

            intentos++;
        }

        if (intentos == maxIntentos) {
            System.out.println("Ha excedido el número máximo de intentos.");
        }

        lea.close();
    }
}