package assignment3.assignment3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //relates a class to a database table
@Table(name = "pets") //Optional
public class Pets {
     //pet attributes
  @Id //annotation to indicate primary key of the entity
  @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-incremented/generated value/id
  private Long petId;

  @Column(nullable = false) //name has to have value in this column, not null 
  private String name;
  private String description;
  private String species;
 
  @Column(nullable = false)
  private double age;
  //default constructor
  public Pets() {
  }

  public Pets(Long petId, String name, String description, double age, String species) {
    this.petId = petId;
    this.name = name;
    this.description = description;
    this.age = age;
    this.species = species;
  }
  //pet constructor without id, later is auto-generated in database
  public Pets(String name, String description, double age, String species) {
    this.name = name;
    this.description = description;
    this.age = age;
    this.species = species;
  }

  public Long getPetId() {
    return petId;
  }

  public void setPetId(Long id) {
    this.petId = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getAge() {
    return age;
  }

  public double setAge(double age) {
    this.age = age;
    return age;
  }
  public String getSpecies() {
    return species;
  }
  public void setSpecies(String species) {
    this.species = species;
  }
}
