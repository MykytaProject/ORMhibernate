package ad.orm.hibernate.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DISTRIBUIDORA")
public class Distribuidora {

    @Id
    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "PLATAFORMA")
    @Enumerated(EnumType.STRING)    
    private Plataforma plataforma;

    // !Relacion con DISTRIBUIDORA
    @ManyToMany(mappedBy = "distribuidoras")
    private List<Juego> juegos = new ArrayList<>();

    // !Getters y Setters
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the plataforma
     */
    public Plataforma getPlataforma() {
        return plataforma;
    }

    /**
     * @param plataforma the plataforma to set
     */
    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    /**
     * @return the juegos
     */
    public List<Juego> getJuegos() {
        return juegos;
    }

    /**
     * @param juegos the juegos to set
     */
    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }

    /**
     * @param nombre
     * @param plataforma
     */

    // !Constructores
    public Distribuidora(String nombre, Plataforma plataforma) {
        this.nombre = nombre;
        this.plataforma = plataforma;
    }

    public Distribuidora() {

    }

}
