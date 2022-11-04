package ad.orm.hibernate.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RAZA")
public class Raza {

    @Id
    @Column(name = "NOMBRE")
    private String nombre;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "FACCION")
    private Faccion faccion;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<Clase> clase;

    // !Constructores
    public Raza() {
    }

    public Raza(String nombre, Faccion faccion, Set<Clase> clase) {
        this.nombre = nombre;
        this.faccion = faccion;
        this.clase = clase;
    }

    // !Getters y Setters
    /**
     * @return the clase
     */
    public Set<Clase> getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(Set<Clase> clase) {
        this.clase = clase;
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
     * @return the faccion
     */
    public Faccion getFaccion() {
        return faccion;
    }

    /**
     * @param faccion the faccion to set
     */
    public void setFaccion(Faccion faccion) {
        this.faccion = faccion;
    }

}
