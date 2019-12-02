package guru.springframework.petclinic.PetClinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.PetClinic.model.Speciality;
import guru.springframework.petclinic.PetClinic.repository.SpecialtyRepository;
import guru.springframework.petclinic.PetClinic.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialityService{
	
	SpecialtyRepository specialtyRepository;
	
	@Autowired
	public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<Speciality>();
		specialtyRepository.findAll().forEach(specialities :: add);
		return specialities;
	}

	@Override
	public Speciality findById(Long Id) {
		// TODO Auto-generated method stub
		return specialtyRepository.findById(Id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		Speciality speciality = specialtyRepository.save(object);
		return speciality;
	}

	@Override
	public void delete(Speciality object) {
		// TODO Auto-generated method stub
		specialtyRepository.delete(object);
	}

	@Override
	public void deleteById(Long Id) {
		// TODO Auto-generated method stub
		specialtyRepository.deleteById(Id);
	}

}
