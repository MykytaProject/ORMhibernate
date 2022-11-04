package ad.orm.hibernate.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUENTA")
public class Cuenta {

    @Id
    @Column(name = "USER")
    private String user;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONO")
    private int telefono;

    @Column(name = "CONTRASEÑA")
    private String contranya;

    @OneToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "USUARIO_ID")
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUENTA_USER")
    private Set<Personaje> personaje;

    // !Constructores
    public Cuenta() {
    }

    public Cuenta(String user, String email, int telefono, String contrasenya, Set<Personaje> personaje) {
        this.user = user;
        this.email = email;
        this.telefono = telefono;
        this.contranya = contrasenya;
        this.personaje = personaje;
    }

    // !Getters y Setters
    /**
     * @return the personaje
     */
    public Set<Personaje> getPersonaje() {
        return personaje;
    }

    /**
     * @param personaje the personaje to set
     */
    public void setPersonaje(Set<Personaje> personaje) {
        this.personaje = personaje;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the contranya
     */
    public String getContranya() {
        return contranya;
    }

    /**
     * @param contranya the contranya to set
     */
    public void setContranya(String contranya) {
        this.contranya = contranya;
    }

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

}
