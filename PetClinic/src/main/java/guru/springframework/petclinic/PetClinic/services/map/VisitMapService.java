package guru.springframework.petclinic.PetClinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.PetClinic.model.Visit;
import guru.springframework.petclinic.PetClinic.services.VisitService;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService{

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long Id) {
		// TODO Auto-generated method stub
		return super.findById(Id);
	}

	@Override
	public Visit save(Visit object) {
		if(object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null) {
			throw new RuntimeException("İnvalid Visit");
		}
		return super.save(object);
	}

	@Override
	public void delete(Visit object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long Id) {
		super.deleteById(Id);
	}

}
