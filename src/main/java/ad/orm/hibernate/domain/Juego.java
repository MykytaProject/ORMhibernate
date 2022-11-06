package ad.orm.hibernate.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JUEGO")
public class Juego implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "VENTAS")
    private int ventas;

    @Column(name = "LANZAMIENTO")
    private LocalDate date;

    // !Relacion con PRODUCTORA
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "PRODUCTORA_NOMBRE")
    private Productora productora;

    // !Relacion con SERVIDOR
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SERVIDOR_ID")
    private Servidor servidor;

    // !Relacion con DISTRIBUIDORA
    @ManyToMany(cascade =  { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "J_D", joinColumns = {
            @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "NOMBRE") })
    private List<Distribuidora> distribuidoras = new ArrayList<>();

    // !Getters y Setters

    /**
     * @return the distribuidoras
     */
    public List<Distribuidora> getDistribuidoras() {
        return distribuidoras;
    }

    /**
     * @param distribuidoras the distribuidoras to set
     */
    public void setDistribuidoras(List<Distribuidora> distribuidoras) {
        this.distribuidoras = distribuidoras;
    }

    /**
     * @return the servidor
     */
    public Servidor getServidor() {
        return servidor;
    }

    /**
     * @param servidor the servidor to set
     */
    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    /**
     * @return the productora
     */
    public Productora getProductora() {
        return productora;
    }

    /**
     * @param productora the productora to set
     */
    public void setProductora(Productora productora) {
        this.productora = productora;
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
     * @return the ventas
     */
    public int getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // !Constructores
    public Juego() {
    }

    public Juego(String nombre, int ventas, LocalDate date, Productora productora) {
        this.nombre = nombre;
        this.ventas = ventas;
        this.date = date;
        this.productora = productora;
    }

}
