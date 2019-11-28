package guru.springframework.petclinic.PetClinic.services.map;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.petclinic.PetClinic.model.Owner;
import guru.springframework.petclinic.PetClinic.model.Pet;
import guru.springframework.petclinic.PetClinic.services.CrudService;
import guru.springframework.petclinic.PetClinic.services.OwnerService;
import guru.springframework.petclinic.PetClinic.services.PetService;
import guru.springframework.petclinic.PetClinic.services.PetTypeService;
//Imp classlar
//Owner Service Interface'i kullanarak metodları tanımladık.
//Bütün imp'lerde ayrı ayrı aynı kodları yazmak yerine, AbstractMapService'de yazdığımız kodları kullandık.
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long>  implements OwnerService{
	
	//Repo ile bir DB'ye baglanmak yerine, Service'de Map ile tuttuk(Abstract Map Service'den override edilen map)
	
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	@Autowired
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

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
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if(pet.getPetType() != null) {
						System.out.println("1");
						if(pet.getPetType().getId() == null) {
							System.out.println("2");
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					}else {
						throw new RuntimeException("Pet Type Zorunlu");
					}
					
					if(pet.getId() == null) {
						System.out.println("3");
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save(object);
		}else {
			return null;
		}
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
