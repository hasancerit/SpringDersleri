package guru.springframework.petclinic.PetClinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.petclinic.PetClinic.model.Vet;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long>{

}
