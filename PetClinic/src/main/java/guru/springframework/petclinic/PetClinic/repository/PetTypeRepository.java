package guru.springframework.petclinic.PetClinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.petclinic.PetClinic.model.PetType;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long>{

}
