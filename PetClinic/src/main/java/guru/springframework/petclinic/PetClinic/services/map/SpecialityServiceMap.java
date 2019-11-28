package guru.springframework.petclinic.PetClinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.petclinic.PetClinic.model.Speciality;
import guru.springframework.petclinic.PetClinic.services.SpecialityService;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService{

	@Override
	public Set<Speciality> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Speciality findById(Long Id) {
		// TODO Auto-generated method stub
		return super.findById(Id);
	}

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public void delete(Speciality object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long Id) {
		super.deleteById(Id);
	}

}
