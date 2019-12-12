package guru.springframework.petclinic.PetClinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

import org.springframework.context.annotation.Profile;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.PetClinic.model.Owner;
import guru.springframework.petclinic.PetClinic.model.PetType;
import guru.springframework.petclinic.PetClinic.repository.OwnerRepository;
import guru.springframework.petclinic.PetClinic.repository.PetRepository;
import guru.springframework.petclinic.PetClinic.repository.PetTypeRepository;
import guru.springframework.petclinic.PetClinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService{
	
	OwnerRepository ownerRepository;
	PetRepository petRepository;
	PetTypeRepository petTypeRepository;

	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		System.out.println("FİND ALL");
		Set<Owner> owners = new HashSet<Owner>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long Id) {	
		Optional<Owner> optionalOwner = ownerRepository.findById(Id);
		if(optionalOwner.isPresent()) {
			return optionalOwner.get();
		}else {
			return null;
		}
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long Id) {
		ownerRepository.deleteById(Id);
	}

	@Override
	public Owner findByLastName(String lastname) {
		return ownerRepository.findByLastName(lastname);
	}

}
