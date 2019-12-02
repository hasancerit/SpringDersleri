package guru.springframework.petclinic.PetClinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.PetClinic.model.Visit;
import guru.springframework.petclinic.PetClinic.repository.VisitRepository;
import guru.springframework.petclinic.PetClinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService{
	
	private final VisitRepository visitRepository;
	
	public VisitSDJpaService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<Visit>();
		visitRepository.findAll().forEach(visits :: add);
		return visits;
	}

	@Override
	public Visit findById(Long Id) {
		return visitRepository.findById(Id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		// TODO Auto-generated method stub
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long Id) {
		visitRepository.deleteById(Id);
	}
	
	
	
}
