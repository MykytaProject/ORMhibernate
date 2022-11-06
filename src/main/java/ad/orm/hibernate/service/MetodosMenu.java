package ad.orm.hibernate.service;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import ad.orm.hibernate.app.App;
import ad.orm.hibernate.domain.Distribuidora;
import ad.orm.hibernate.domain.Juego;
import ad.orm.hibernate.domain.Plataforma;
import ad.orm.hibernate.domain.Productora;
import ad.orm.hibernate.domain.Servidor;

public class MetodosMenu {
    Session s = App.s;
    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);
    String string;
    String id;
    int anyo;
    int mes;
    int dia;
    int x;
    public static Object o;

    // !Productora
    // Listar datos de productora
    public void listarProductora() {
        @SuppressWarnings("all")
        List<Productora> lista = s.createQuery("FROM Productora").list();

        for (Productora i : lista) {
            System.out.printf("Productora: %s, localidad: %s, director: %s%n", i.getNombre(),
                    i.getLocalidad(),
                    i.getDirector());
        }
    }

    // Insertar datos en productora
    public void insertarProductora() {
        try {
            s.beginTransaction();
            Productora p = new Productora();

            System.out.print("Dime el nombre de la prductora:");
            string = sc.nextLine();
            p.setNombre(string);

            System.out.print("Dime el nombre del director:");
            string = sc.nextLine();
            p.setDirector(string);

            System.out.print("Dime la localidad:");
            string = sc.nextLine();
            p.setLocalidad(string);

            s.persist(p);
            s.getTransaction().commit();
            System.out.println("Los datos se han introducido correctamente");
        } catch (InputMismatchException e) {
            System.err.println("Introduce los datos de forma correcta!!");
            s.getTransaction().rollback();
        } catch (Exception e) {
            System.err.println("Un error inesperado!");
            s.getTransaction().rollback();
        }
    }

    // Modificar datos de productora
    public void modificarProductora() {
        try {
            s.beginTransaction();

            System.out.print("Dime el nombre de la prductora que quieres modificar:");
            string = sc.nextLine();
            Productora p = s.get(Productora.class, string);

            System.out.print("Dime el nuevo nombre del director: ");
            string = sc.nextLine();
            p.setDirector(string);

            System.out.print("Dime la nueva localidad: ");
            string = sc.nextLine();
            p.setLocalidad(string);

            s.getTransaction().commit();
            System.out.println("Los datos se han modificado correctamente");
        } catch (NullPointerException e) {
            System.err.println("Productora no encontrada");
            s.getTransaction().rollback();
        } catch (InputMismatchException e) {
            System.err.println("Introduce los datos de forma correcta!!");
            s.getTransaction().rollback();
        } catch (Exception e) {
            System.err.println("Un error inesperado!");
            s.getTransaction().rollback();
        }
    }

    // Eliminar datos de productora
    public void borrarProductora() {
        try {
            s.beginTransaction();

            System.out.println("Dime el nombre de la productora que quieres borra");
            string = sc.nextLine();
            Productora p = s.get(Productora.class, string);
            
            // Lo huardo en un objeto o para luego rescatarlo
            o = p;
            s.delete(p);
            s.getTransaction().commit();
            System.out.println("Los datos se han borrado correctamente");
        } catch (NullPointerException e) {
            System.err.println("Productora no encontrada");
            s.getTransaction().rollback();
        } catch (InputMismatchException e) {
            System.err.println("Introduce los datos de forma correcta!!");
            s.getTransaction().rollback();
        } catch (Exception e) {
            System.err.println("Un error inesperado!");
            s.getTransaction().rollback();
        }
    }

    // !Juego
    // Listar datos de Juego
    public void listarJuego() {
        @SuppressWarnings("all")
        List<Juego> juegos = s.createQuery("From Juego").list();

        for (Juego i : juegos) {
            System.out.printf("Nombre: %s, ventas: %s, fecha de lanzamiento: %s, productora: %s%n", i.getNombre(),
                    i.getVentas(), i.getDate(), i.getProductora().getNombre());
        }
    }

    // Insertar datos Juego
    public void insertarJuego() {
        try {
            s.beginTransaction();

            Juego j = new Juego();

            System.out.print("Dime el nombre del juego: ");
            string = sc.nextLine();
            j.setNombre(string);

            System.out.print("Dime las ventas del juego: ");
            x = sc2.nextInt();
            j.setVentas(x);

            System.out.println("Dime la fecha de lanzamiento");
            System.out.print("Año: ");
            anyo = sc2.nextInt();
            System.out.print("Mes: ");
            mes = sc2.nextInt();
            System.out.print("Día: ");
            dia = sc2.nextInt();
            j.setDate(LocalDate.of(anyo, mes, dia));

            System.out.print("Dime la productora del juego: ");
            string = sc.nextLine();
            Productora p = s.get(Productora.class, string);
            p.agregarJuego(j);

            System.out.println("El juego es Online [S/n] para asignar servidor");
            string = sc.nextLine();
            switch (string.toLowerCase()) {
                case "s":
                    try {
                        Servidor ser = new Servidor();
                        System.out.println("Introduceme la capacidad del servidor: ");
                        x = sc2.nextInt();
                        ser.setCapacidad(x);
                        j.setServidor(ser);
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Introduce los datos de forma correcta!!");
                        s.getTransaction().rollback();
                        break;
                    }
                case "n":
                    System.out.println("No se ha introducido ningun servidor.");
                    break;
                default:
                    System.out.println("Valor incorrecto, no se va a introducir ningun servidor");
                    break;
            }

            System.out.println("Cuantas distribuidoras tiene el juego?");
            x = sc2.nextInt();
            // List<Distribuidora> dis = new ArrayList<Distribuidora>();
            for (int i = 0; i < x; i++) {
                System.out.println("Dime el nombre de la Distribuidora " + (i + 1));
                string = sc.nextLine();
                Distribuidora d = s.get(Distribuidora.class, string);
                j.getDistribuidoras().add(d);
            }
            s.save(j);
            s.getTransaction().commit();
            System.out.println("Los datos se han introducido correctamente");
        } catch (NullPointerException e) {
            System.err.println("Inserte la productora o distribuidora primero!!");
            s.getTransaction().rollback();
        } catch (InputMismatchException e) {
            System.err.println("Introduce los datos de forma correcta!!");
            s.getTransaction().rollback();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Un error inesperado!");
            s.getTransaction().rollback();
        }
    }

    // Modificar datos Juego
    public void modificarJuego() {
        try {
            s.beginTransaction();

            System.out.print("Dime el ID del juego que quieres modificar: ");
            x = sc2.nextInt();
            Juego j = s.get(Juego.class, x);

            System.out.print("Dime el nuevo nombre del juego: ");
            string = sc.nextLine();
            j.setNombre(string);

            System.out.print("Dime las nuevas ventas del juego: ");
            x = sc2.nextInt();
            j.setVentas(x);

            System.out.println("Dime la nueva fecha de lanzamiento");
            System.out.print("Año: ");
            anyo = sc2.nextInt();
            System.out.print("Mes: ");
            mes = sc2.nextInt();
            System.out.print("Día: ");
            dia = sc2.nextInt();
            j.setDate(LocalDate.of(anyo, mes, dia));

            System.out.print("Dime la nueva productora del juego: ");
            string = sc.nextLine();
            Productora p = s.get(Productora.class, string);

            p.agregarJuego(j);
            s.getTransaction().commit();
            System.out.println("Los datos se han modificado correctamente");
        } catch (NullPointerException e) {
            System.err.println("Inserte la productora primero!!");
            s.getTransaction().rollback();
        } catch (InputMismatchException e) {
            System.err.println("Introduce los datos de forma correcta!!");
            s.getTransaction().rollback();
        } catch (Exception e) {
            System.err.println("Un error inesperado!");
            s.getTransaction().rollback();
        }
    }

    // Eliminar datos de juego
    public void borrarJuego() {
        try {
            s.beginTransaction();

            System.out.print("Dime el ID del juego que quieres borrar: ");
            x = sc2.nextInt();
            Juego j = s.get(Juego.class, x);

            s.delete(j);
            s.getTransaction().commit();
        } catch (NullPointerException e) {
            System.err.println("Juego no encontrado");
            s.getTransaction().rollback();
        } catch (InputMismatchException e) {
            System.err.println("Introduce los datos de forma correcta!!");
            s.getTransaction().rollback();
        } catch (Exception e) {
            System.err.println("Un error inesperado!");
            s.getTransaction().rollback();
        }
    }

    // !Servidor
    // Listar Juego-CapacidadServidor
    public void listarServidor() {
        @SuppressWarnings("all")
        List<Juego> juegos = s.createQuery("FROM Juego").list();

        for (Juego j : juegos) {
            System.out.printf("Juego: %s, capacidad de servidor: %s %n", j.getNombre(), j.getServidor().getCapacidad());
        }
    }

    // Modificar datos Servidor
    public void modificarServidor() {
        try {
            s.beginTransaction();
            System.out.print("Dime el [ID] del juego cuyo servidor quieres modificar: ");
            x = sc2.nextInt();
            Juego j = s.get(Juego.class, x);
            Servidor ser = s.get(Servidor.class, j.getServidor().getId());
            System.out.print("Dime la nueva capacidad del servidor: ");
            x = sc2.nextInt();
            ser.setCapacidad(x);
            s.getTransaction().commit();
            System.out.println("Los datos se han modificado correctamente");
        } catch (NullPointerException e) {
            System.err.println("Inserte la productora primero!!");
            s.getTransaction().rollback();
        } catch (InputMismatchException e) {
            System.err.println("Introduce los datos de forma correcta!!");
            s.getTransaction().rollback();
        } catch (Exception e) {
            System.err.println("Un error inesperado!");
            s.getTransaction().rollback();
        }
    }

    // !Distribuidora
    // Listar Distribuidoras
    public void listarDistribuidoras() {
        @SuppressWarnings("all")
        List<Distribuidora> distribuidoras = s.createQuery("From Distribuidora").list();

    }

    // Insertar datos Distribuidora
    public void insertarDistribuidora() {
        try {
            s.beginTransaction();
            Distribuidora d = new Distribuidora();

            System.out.println("Dime el nombre de la Distribuidora");
            string = sc.nextLine();
            d.setNombre(string);
            boolean plataforma = true;
            do {
                System.out.println("Escoge la plataforma:");
                System.out.println("[Xbox],[PC],[Steam],[NintendoSwitch],[PlayStation]");
                string = sc.nextLine();
                switch (string) {
                    case "Xbox":
                        d.setPlataforma(Plataforma.Xbox);
                        plataforma = false;
                        s.save(d);
                        s.getTransaction().commit();
                        System.out.println("Los datos se han introducido correctamente");
                        break;
                    case "PC":
                        d.setPlataforma(Plataforma.PC);
                        plataforma = false;
                        s.save(d);
                        s.getTransaction().commit();
                        System.out.println("Los datos se han introducido correctamente");
                        break;
                    case "Steam":
                        d.setPlataforma(Plataforma.Steam);
                        plataforma = false;
                        s.save(d);
                        s.getTransaction().commit();
                        System.out.println("Los datos se han introducido correctamente");
                        break;
                    case "NintendoSwitch":
                        d.setPlataforma(Plataforma.NintendoSwitch);
                        plataforma = false;
                        s.save(d);
                        s.getTransaction().commit();
                        System.out.println("Los datos se han introducido correctamente");
                        break;
                    case "PlayStation":
                        d.setPlataforma(Plataforma.PlayStation);
                        plataforma = false;
                        s.save(d);
                        s.getTransaction().commit();
                        System.out.println("Los datos se han introducido correctamente");
                        break;
                    default:
                        System.out.println("Introduce el valor corecto");
                        break;
                }
            } while (plataforma);
        } catch (Exception e) {
            System.err.println("Un error inesperado!");
            s.getTransaction().rollback();
        }
    }

    // Eliminar Distibuidora
    public void borrarDistribuidora() {
        try {
            s.beginTransaction();

            System.out.println("Dime el nombre de Distribuidora que quieres borrar: ");
            string = sc.nextLine();
            Distribuidora dis = s.get(Distribuidora.class, string);
            s.delete(dis);
            s.getTransaction().commit();
        } catch (NullPointerException e) {
            System.err.println("Distribuidora no encontrado");
            s.getTransaction().rollback();
        } catch (InputMismatchException e) {
            System.err.println("Introduce los datos de forma correcta!!");
            s.getTransaction().rollback();
        } catch (Exception e) {
            System.err.println("Un error inesperado!");
            s.getTransaction().rollback();
        }
    }

    // !Extra
    // Listar todos los juegos de una Productora
    public void listarProductoraJuegos() {
        System.out.println("Dime el [Nombre] de la productora cuyos juegos quieres listar: ");
        string = sc.nextLine();
        try {
            @SuppressWarnings("all")
            Productora p = s.get(Productora.class, string);
            List<Juego> juegos = p.getJuego();

            for (Juego j : juegos) {
                System.out.printf("Productora: %s, Juego: %s, Ventas: %s %n", p.getNombre(), j.getNombre(),
                        j.getVentas());
            }
        } catch (NullPointerException e) {
            System.err.println("Productora no encontrada");
        } catch (Exception e) {
            System.err.println("Un error inesperado!");
        }
    }

    // Recuperar el ultimo dato Borrado
    public void restaurarDato() {
        try {
            s.beginTransaction();
            Productora po = (Productora)o;
            Productora p = new Productora();
            p.setNombre(po.getNombre());
            p.setDirector(po.getDirector());
            p.setLocalidad(po.getLocalidad());

            s.persist(p);
            s.getTransaction().commit();
            System.out.println("Se han recuperado datos");
        } catch (Exception e) {
            System.out.println("No se ha podido recuperar");
            s.getTransaction().rollback();
        }
    }
}
