package ad.orm.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASE")
public class Clase {

  @Id
  @Column(name = "NOMBRE")
  private String nombre;

  // !Constructores
  public Clase(String s) {
    nombre = s;
  }

  public Clase() {
  }

  // !Getters y Setters
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
