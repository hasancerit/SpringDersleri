package guru.springframework.petclinic.PetClinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.petclinic.PetClinic.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{
	Owner findByLastName(String lastname);
}
