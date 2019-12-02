package guru.springframework.petclinic.PetClinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.PetClinic.model.Vet;
import guru.springframework.petclinic.PetClinic.repository.VetRepository;
import guru.springframework.petclinic.PetClinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService{
	
	private final VetRepository vetRepository;
	
	
	@Autowired
	public VetSDJpaService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<Vet>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long Id) {
		return vetRepository.findById(Id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long Id) {
		vetRepository.deleteById(Id);
	}

}
