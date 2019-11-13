package guru.springframework.petclinic.PetClinic.services.map;

import java.util.Set;

import guru.springframework.petclinic.PetClinic.model.Owner;
import guru.springframework.petclinic.PetClinic.services.CrudService;
//Crud Service Interface'i kullanarak metodları tanımladık.
//Bu metodların body(işlev)'lerini de AbstractMapService'de tanımladığımız ve doldurduğumuz metodlarla doldurduk.
public class OwnerServiceMap extends AbstractMapService<Owner,Long>  implements CrudService<Owner,Long>{

	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Owner findById(Long Id) {
		// TODO Auto-generated method stub
		return super.findById(Id);
	}

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(),object);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long Id) {
		super.deleteById(Id);
	}

}
