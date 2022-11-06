package ad.orm.hibernate.service;

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
            System.out.println("1. Listar los datos");
            System.out.println("2. Insertar datos en una tabla");
            System.out.println("3. Modificar datos de una tabla");
            System.out.println("4. Eliminar datos de una tabla");
            System.out.println("5. Restaurar último dato borrado de Producotra");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            key = scS.nextLine();
            switch (key) {
                case "1":
                    do {
                        System.out
                                .println(
                                        "Elige la opcion [Productora], [Juego], [Servidor], [Distribuidora], [JuegoProd] [Salir]");
                        tabla = scS.nextLine();
                        switch (tabla) {
                            case "Productora":
                                mm.listarProductora();
                                break;
                            case "Juego":
                                mm.listarJuego();
                                break;
                            case "Servidor":
                                System.out.println("Se va a mostrar la capacidad de servidor de cada juego");
                                mm.listarServidor();
                                break;
                            case "Distribuidora":
                                mm.listarDistribuidoras();
                                break;
                            case "JuegoProd":
                                mm.listarProductoraJuegos();
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
                        System.out.println("Dime la tabla [Productora], [Juego], [Distribuidora] o [Salir]");
                        tabla = scS.nextLine();
                        switch (tabla) {
                            case "Productora":
                                mm.insertarProductora();
                                break;
                            case "Juego":
                                mm.insertarJuego();
                                break;
                            case "Distribuidora":
                                mm.insertarDistribuidora();
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
                        System.out.println("Dime la tabla [Productora], [Juego], [Servidor] o [Salir]");
                        tabla = scS.nextLine();
                        switch (tabla) {
                            case "Productora":
                                mm.modificarProductora();
                                break;
                            case "Juego":
                                mm.modificarJuego();
                                break;
                            case "Servidor":
                                mm.modificarServidor();
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
                case "4":
                    do {
                        System.out.println("Dime la tabla [Productora], [Juego], [Distribuidora] o [Salir]");
                        tabla = scS.nextLine();
                        switch (tabla) {
                            case "Productora":
                                mm.borrarProductora();
                                break;
                            case "Juego":
                                mm.borrarJuego();
                                break;
                            case "Distribuidora":
                                mm.borrarDistribuidora();
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
                    mm.restaurarDato();
                    break;
                case "6":
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
