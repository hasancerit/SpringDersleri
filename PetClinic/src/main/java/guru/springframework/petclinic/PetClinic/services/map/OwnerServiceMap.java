package guru.springframework.petclinic.PetClinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.petclinic.PetClinic.model.Owner;
import guru.springframework.petclinic.PetClinic.services.CrudService;
import guru.springframework.petclinic.PetClinic.services.OwnerService;
//Imp classlar
//Owner Service Interface'i kullanarak metodları tanımladık.
//Bütün imp'lerde ayrı ayrı aynı kodları yazmak yerine, AbstractMapService'de yazdığımız kodları kullandık.
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long>  implements OwnerService{
	
	//Repo ile bir DB'ye baglanmak yerine, Service'de Map ile tuttuk(Abstract Map Service'den override edilen map)
	
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
		return super.save(object);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long Id) {
		super.deleteById(Id);
	}

	@Override
	public Owner findByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

}
