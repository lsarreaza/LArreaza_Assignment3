package assignment3.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //annotated as a controller, middle layer between service and outside world 
public class PetController {
    @Autowired
  private PetService petService; //connects controller to service 

  /**
   * Endpoint to get all pets
   *
   * @return List of all pets
   */
  @GetMapping("/pets") //shows all pets
  public Object getAllPets() {
    return petService.getAllPets();
  }

  /**
   * Endpoint to get a pet by ID
   *
   * @param id The ID of the pet to retrieve
   * @return The pet with the specified ID
   */
  @GetMapping("/pets/{id}") ///find pet by id , path variable is id
  public Pets getPetById(@PathVariable long id) {
    return petService.getPetById(id);
  }

  /**
   * Endpoint to get pets by name
   *
   * @param name The name of the student to search for
   * @return List of pets with the specified name
   */
  @GetMapping("/pets/name")
  public Object getPetsByName(@RequestParam String key) {
    if (key != null) {
      return petService.getPetsByName(key);
    } else {
      return petService.getAllPets();
    }

  }

  /**
   * Endpoint to get pets by species
   *
   * @param species The species to search for
   * @return List of pets with the specified species
   */
  @GetMapping("/pets/species/{species}")
  public Object getPetsBySpecies(@PathVariable String species) {
    return petService.getPetsBySpecies(species);
  }

  /**
   * Endpoint to get senior pets above a specified age
   *
   * @param age The age threshold for senior pets
   * @return List of senior pets above the specified age
   */
  @GetMapping("/pets/senior")
  public Object getSeniorPets(@RequestParam(name = "age", defaultValue = "7") int age) {
    return new ResponseEntity<>(petService.getSeniorPets(age), HttpStatus.OK);

  }

  /**
   * Endpoint to add a new pet
   *
   * @param pet The pet to add
   * @return List of all pets
   */
  @PostMapping("/pets") //triggered when post request is made to /pets endpoint
  public Object addPet(@RequestBody Pets pet) {
    return petService.addPet(pet);
  }

  /**
   * Endpoint to update a pet
   *
   * @param id      The ID of the student to update
   * @param pet The updated student information
   * @return The updated pet
   */
  @PutMapping("/pets/{id}")
  public Pets updatePet(@PathVariable Long id, @RequestBody Pets pet) {
    petService.updatePet(id, pet);
    return petService.getPetById(id);
  }

  /**
   * Endpoint to delete a pet
   *
   * @param id The ID of the student to delete
   * @return List of all pets
   */
  @DeleteMapping("/pets/{id}")
  public Object deletePet(@PathVariable Long id) {
    petService.deletePet(id);
    return petService.getAllPets();
  }

  /**
   * Endpoint to write a pet to a JSON file
   *
   * @param pet The pet to write
   * @return An empty string indicating success
   */
  @PostMapping("/pets/writeFile")
  public Object writeJson(@RequestBody Pets pet) {
    return petService.writeJson(pet);
  }

  /**
   * Endpoint to read a JSON file and return its contents
   *
   * @return The contents of the JSON file
   */
  @GetMapping("/pets/readFile")
  public Object readJson() {
    return petService.readJson();

  }
}
