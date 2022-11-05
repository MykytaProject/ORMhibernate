package ad.orm.hibernate.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTORA")
public class Productora {

    @Id
    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "LOCALIDAD")
    private String localidad;

    @Column(name = "DIRECTOR")
    private String director;

    @OneToMany(mappedBy = "productora", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    private List<Juego> juegos;

    // !Metodo agregar

    public void agregarJuego(Juego juego) {
        if (juegos == null) {
            juegos = new ArrayList<>();
        }
        juegos.add(juego);
        juego.setProductora(this);
    }

    // !Getters y Setters

    /**
     * @return the juego
     */
    public List<Juego> getJuego() {
        return juegos;
    }

    /**
     * @param juego the juego to set
     */
    public void setJuego(List<Juego> juegos) {
        this.juegos = juegos;
    }

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
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    // !Constructores
    public Productora() {
    }

    public Productora(String nombre, String localidad, String director, List<Juego> juegos) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.director = director;
        this.juegos = juegos;
    }
}
