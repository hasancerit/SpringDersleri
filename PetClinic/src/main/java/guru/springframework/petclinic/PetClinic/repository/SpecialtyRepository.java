package guru.springframework.petclinic.PetClinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.petclinic.PetClinic.model.Speciality;

@Repository
public interface SpecialtyRepository extends CrudRepository<Speciality,Long>{

}
