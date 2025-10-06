package assignment3.assignment3;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository //anotated as repository, lowest level connection to database
public interface PetRepository extends JpaRepository<Pets, Long> {
//sql queries in here
    List<Pets> getPetsBySpecies(String species);
//?1 means first argument passed in method
    @Query(value = "select * from pets p where p.age >= ?1", nativeQuery = true)
    List<Pets> getSeniorPets(double age);

    @Query(value = "select * from pets p where p.name like %?1% ", nativeQuery = true)
    List<Pets> getPetsByName(String name);
}