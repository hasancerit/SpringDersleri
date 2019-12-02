package guru.springframework.petclinic.PetClinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.petclinic.PetClinic.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long>{

}
