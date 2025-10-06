package assignment3.assignment3;

import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PetService {
    @Autowired
  private PetRepository petRepository; //connects service to repository 

  /**
   * Method to get all pets
   *
   * @return List of all pets
   */
  public Object getAllPets() {
    return petRepository.findAll(); //method inherited from JpaRepository
  }

  /**
   * Method to get a pet by ID
   *
   * @param petId The ID of the pet to retrieve
   * @return The pet with the specified ID
   */
  public Pets getPetById(@PathVariable long petId) {
    return petRepository.findById(petId).orElse(null);
  }

  /**
   * Method to get pets by name
   *
   * @param name The name of the student to search for
   * @return List of pets with the specified name
   */
  public Object getPetsByName(String name) {
    return petRepository.getPetsByName(name);
  }

  /**
   * Method to get pets by species
   *
   * @param major The major to search for
   * @return List of students with the specified major
   */
  public Object getPetsBySpecies(String species) {
    return petRepository.getPetsBySpecies(species);
  }

  /**
   * Fetch all pets with a certain age.
   *
   * @param age the threshold
   * @return the list of matching Pets
   */
  public Object getSeniorPets(double age) {
    return petRepository.getSeniorPets(age);
  }

  /**
   * Method to add a new pet
   *
   * @param pet The pet to add
   */
  public Pets addPet(Pets pet) {
    return petRepository.save(pet); //save method inherited from JpaRepository, part of API
  }

  /**
   * Method to update a pet
   *
   * @param petId The ID of the pet to update
   * @param pet   The updated pet information
   */
  public Pets updatePet(Long petId, Pets pet) {
    return petRepository.save(pet);
  }

  /**
   * Method to delete a pet
   *
   * @param petId The ID of the pet to delete
   */
  public void deletePet(Long petId) {
    petRepository.deleteById(petId);
  }

  /**
   * Method to write a pet object to a JSON file
   *
   * @param pet The pet object to write
   */
  public String writeJson(Pets pet) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("pets.json"), pet);
      return "Pet written to JSON file successfully";
    } catch (IOException e) {
      e.printStackTrace();
      return "Error writing pet to JSON file";
    }

  }

  /**
   * Method to read a student object from a JSON file
   *
   * @return The pet object read from the JSON file
   */
  public Object readJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File("pets.json"), Pets.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

  }
}
