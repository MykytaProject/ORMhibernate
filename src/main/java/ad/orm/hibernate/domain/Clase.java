package ad.orm.hibernate.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLASE")
public class Clase {

  @Id
  @Column(name = "NOMBRE")
  private String nombre;

  @ManyToMany(mappedBy = "clase")
  private Set<Clase> razas;

  
  // !Constructores
  public Clase(String s, Set<Clase> razas) {
    this.razas = razas;
    nombre = s;
  }

  public Clase() {
  }

  // !Getters y Setters
  /**
   * @return the razas
   */
  public Set<Clase> getRazas() {
    return razas;
  }

  /**
   * @param razas the razas to set
   */
  public void setRazas(Set<Clase> razas) {
    this.razas = razas;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
