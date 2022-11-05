package ad.orm.hibernate.service;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import ad.orm.hibernate.app.App;
import ad.orm.hibernate.domain.Juego;
import ad.orm.hibernate.domain.Productora;

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
        /*
         * // ?Lista de juegos
         * 
         * @SuppressWarnings("all")
         * List<Juego> juegos = s.createQuery("FROM Juego").list();
         * 
         * System.out.println("Dime el juego que ha desarollado: ");
         * 
         * s.persist(p);
         * s.getTransaction().commit();
         */
    }

    // Modificar datos de productora
    public void modificarProductora() {
        s.beginTransaction();

        Productora p = new Productora();

        System.out.print("Dime el nombre de la prductora que quieres modificar:");
        string = sc.nextLine();
        p.setNombre(string);

        System.out.print("Dime el nuevo nombre del director:");
        string = sc.nextLine();
        // if(!string.equals(""))
        p.setDirector(string);

        System.out.print("Dime la nueva localidad:");
        string = sc.nextLine();
        p.setLocalidad(string);

        s.update(p);
        s.getTransaction().commit();
    }

    // Eliminar datos de productora
    public void borrarProductora() {
        s.beginTransaction();

        System.out.println("Dime el nombre de la productora que quieres borra");
        string = sc.nextLine();
        Productora p = s.get(Productora.class, string);

        s.delete(p);
        s.getTransaction().commit();
    }

    // !Juego
    // Listar datos de Juego
    public void listarJuego() {
        @SuppressWarnings("all")
        List<Juego> juegos = s.createQuery("From Juego").list();

        for (Juego i : juegos) {
            System.out.printf("Nombre: %s, ventas: %s, fecha de lanzamiento: %s, productora: %s%n", i.getNombre(),
                    i.getVentas(), i.getDate(), i.getProductora());
        }
    }

    // Insertar datos Juego
    public void insertarJuego() {
        s.beginTransaction();

        Juego j = new Juego();
        try {
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
            s.save(j);
            s.getTransaction().commit();
        } catch (NullPointerException e) {
            System.err.println("Inserte la productora primero!!");
            s.getTransaction().rollback();
        } catch (InputMismatchException e) {
            System.err.println("Introduce los datos de forma correcta!!");
        }
    }

    // Modificar datos Juego
    public void modificarJuego() {
        s.beginTransaction();

        Juego j = new Juego();
        try {
            System.out.print("Dime el ID del juego que quieres modificar: ");
            x = sc2.nextInt();
            j.setId(x);

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
            s.update(j);
            s.getTransaction().commit();
        } catch (NullPointerException e) {
            System.err.println("Inserte la productora primero!!");
            s.getTransaction().rollback();
        } catch (InputMismatchException e) {
            System.err.println("Introduce los datos de forma correcta!!");
        }
    }

    // Eliminar datos de juego
    public void borrarJuego() {
        s.beginTransaction();

        System.out.print("Dime el ID del juego que quieres borrar: ");
        x = sc2.nextInt();
        Juego j = s.get(Juego.class, x);

        s.delete(j);
        s.getTransaction().commit();
    }
}
