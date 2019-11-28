package guru.springframework.petclinic.PetClinic.services.map;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.PetClinic.model.Speciality;
import guru.springframework.petclinic.PetClinic.model.Vet;
import guru.springframework.petclinic.PetClinic.services.SpecialityService;
import guru.springframework.petclinic.PetClinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{
	
	private final SpecialityService specialityService;
	
	@Autowired
	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}
	
	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Vet findById(Long Id) {
		// TODO Auto-generated method stub
		return super.findById(Id);
	}

	@Override
	public Vet save(Vet object) {
		if(object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(speciality -> {
				if(speciality.getId() == null) {
					System.out.println("5");
					Speciality savedSpeciality = specialityService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		return super.save(object);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long Id) {
		super.deleteById(Id);
	}

	
}
