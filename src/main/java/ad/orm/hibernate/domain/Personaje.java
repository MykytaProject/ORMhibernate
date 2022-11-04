package ad.orm.hibernate.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAJE")
public class Personaje {

    @Id
    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "ORO")
    private int oro;

    @Column(name = "GENERO")
    @Enumerated(value = EnumType.STRING)
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "RAZA_has_CLASE_RAZA_NOMBRE")
    private String raza;

    @ManyToOne
    @JoinColumn(name = "RAZA_has_CLASE_CLASE_NOMBRE")
    private String clase;

    private String cuentaUser;

    // !Constructores
    public Personaje() {

    }

    public Personaje(String nombre, int oro, Genero genero, String raza, String clase) {
        this.nombre = nombre;
        this.oro = oro;
        this.genero = genero;
        this.raza = raza;
        this.clase = clase;
    }

    // !Getters y Setters
    /**
     * @return the cuentaUser
     */
    public String getCuentaUser() {
        return cuentaUser;
    }

    /**
     * @param cuentaUser the cuentaUser to set
     */
    public void setCuentaUser(String cuentaUser) {
        this.cuentaUser = cuentaUser;
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
     * @return the oro
     */
    public int getOro() {
        return oro;
    }

    /**
     * @param oro the oro to set
     */
    public void setOro(int oro) {
        this.oro = oro;
    }

    /**
     * @return the genero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    } 
}
