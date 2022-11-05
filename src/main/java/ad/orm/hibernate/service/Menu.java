package ad.orm.hibernate.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void ejecutarMenu() {
        MetodosMenu mm = new MetodosMenu();
        boolean menu = true;
        String key = null;
        String tabla = null;
        Scanner scS = new Scanner(System.in);

        System.out.println("Bienvenido a la base de datos");
        do {
            boolean submenu = true;
            System.out.println("Elige lo que quieres hacer:");
            System.out.println("1. Listar los datos de una tabla");
            System.out.println("2. Insertar datos en una tabla");
            System.out.println("3. Modificar datos de una tabla");
            System.out.println("4. Eliminar datos de una tabla");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            key = scS.nextLine();
            switch (key) {
                case "1":
                    do {
                        System.out.println("Dime la tabla [Productora], [Juego] o [Salir]");
                        tabla = scS.nextLine();
                        switch (tabla) {
                            case "Productora":
                                mm.listarProductora();
                                break;
                            case "Juego":

                                break;
                            case "Salir":
                                submenu = false;
                                tabla = null;
                                break;
                            default:
                                System.out.println("Introduce el valor correcto");
                                break;
                        }
                    } while (submenu);
                    break;
                case "2":
                    do {
                        System.out.println("Dime la tabla [Productora], [Juego] o [Salir]");
                        tabla = scS.nextLine();
                        switch (tabla) {
                            case "Productora":
                                mm.insertarProductora();
                                break;
                            case "Juego":
                                mm.insertarJuego();
                                System.err.println("Introduce el tipo de dato correcto!");

                                break;
                            case "Salir":
                                submenu = false;
                                tabla = null;
                                break;

                            default:
                                System.out.println("Introduce el valor correcto");
                                break;
                        }
                    } while (submenu);
                    break;
                case "3":
                    do {
                        System.out.println("Dime la tabla [Productora], [Juego] o [Salir]");
                        tabla = scS.nextLine();
                        switch (tabla) {
                            case "Productora":
                                mm.modificarProductora();
                                break;
                            case "Juego":
                                mm.modificarJuego();
                            case "Salir":
                                submenu = false;
                                tabla = null;
                                break;

                            default:
                                System.out.println("Introduce el valor correcto");
                                break;
                        }
                    } while (submenu);
                    break;
                case "4":
                    do {
                        System.out.println("Dime la tabla [Productora] o [Salir]");
                        tabla = scS.nextLine();
                        switch (tabla) {
                            case "Productora":
                                mm.borrarProductora();
                                break;
                            case "Salir":
                                submenu = false;
                                tabla = null;
                                break;

                            default:
                                System.out.println("Introduce el valor correcto");
                                break;
                        }
                    } while (submenu);
                    break;
                case "5":
                    menu = false;
                    scS.close();
                    break;
                default:
                    System.out.println("Introduce la opciñon correcta.");
                    break;
            }
        } while (menu);
    }
}
