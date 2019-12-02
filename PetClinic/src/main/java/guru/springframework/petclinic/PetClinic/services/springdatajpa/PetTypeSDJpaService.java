package guru.springframework.petclinic.PetClinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.PetClinic.model.Pet;
import guru.springframework.petclinic.PetClinic.model.PetType;
import guru.springframework.petclinic.PetClinic.repository.PetTypeRepository;
import guru.springframework.petclinic.PetClinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService{
	
	private final PetTypeRepository petTypeRepository;
	
	@Autowired
	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<PetType>();
		petTypeRepository.findAll().forEach(petTypes :: add);
		return petTypes;
	}

	@Override
	public PetType findById(Long Id) {
		// TODO Auto-generated method stub
		return petTypeRepository.findById(Id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		// TODO Auto-generated method stub
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long Id) {
		petTypeRepository.deleteById(Id); 
	}
	
	
	
}
