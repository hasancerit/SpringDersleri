package guru.springframework.petclinic.PetClinic.services;


import java.util.List;

import guru.springframework.petclinic.PetClinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	Owner findByLastName(String lastname);
	
	List<Owner> findAllByLastNameLike(String lastname);
}
