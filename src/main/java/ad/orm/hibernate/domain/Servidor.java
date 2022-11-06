package ad.orm.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVIDOR")
public class Servidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "CAPACIDAD")
    private int capacidad;

    /*@OneToOne
    @Column(name = "JUEGO_ID")
    private Juego juego;*/

    // !Constructores
    /**
     * @param id
     * @param capacidad
     * @param juego
     */
    public Servidor(int id, int capacidad) {
        this.id = id;
        this.capacidad = capacidad;
    }

    public Servidor() {

    }

    // !Getters y Setters
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
