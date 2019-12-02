package guru.springframework.petclinic.PetClinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.petclinic.PetClinic.model.Owner;
import guru.springframework.petclinic.PetClinic.model.Pet;
import guru.springframework.petclinic.PetClinic.model.PetType;
import guru.springframework.petclinic.PetClinic.model.Speciality;
import guru.springframework.petclinic.PetClinic.model.Vet;
import guru.springframework.petclinic.PetClinic.model.Visit;
import guru.springframework.petclinic.PetClinic.services.OwnerService;
import guru.springframework.petclinic.PetClinic.services.PetTypeService;
import guru.springframework.petclinic.PetClinic.services.SpecialityService;
import guru.springframework.petclinic.PetClinic.services.VetService;
import guru.springframework.petclinic.PetClinic.services.VisitService;
import guru.springframework.petclinic.PetClinic.services.map.OwnerServiceMap;
import guru.springframework.petclinic.PetClinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
	private OwnerService ownerService;
	private VetService vetService;
	private PetTypeService petTypeService;
	private SpecialityService specialityService;
	private VisitService visitService;
	
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService,
						SpecialityService specialityService,VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	//Spring Context tamamen olustugunda cağirigilir
	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		if(count == 0)
			loadData();
	}
	
	private void loadData() {
		
		/* Pet Types*/
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		/* Owners And Pets */
		Owner owner = new Owner(); /* Owner 1*/
		owner.setFirstName("Hasan");
		owner.setLastName("Cerit");
		owner.setAddress("Fatih Mahallesi");
		owner.setCity("Isparta");
		owner.setTelephone("05453534");
		
		Pet pet1 = new Pet();
		pet1.setPetType(savedDogPetType);
		pet1.setOwner(owner);
		pet1.setBirthDate(LocalDate.now());
		pet1.setName("Agnes");
		owner.getPets().add(pet1);
		ownerService.save(owner);
		
		
		Owner owner2 = new Owner(); /*Owner 2 */
		owner2.setFirstName("Batuhan");
		owner2.setLastName("Cerit");
		owner2.setAddress("Bala Mahallesi");
		owner2.setCity("Denizli");
		owner.setTelephone("0534453252");
		
		Pet pet2 = new Pet();
		pet2.setPetType(savedCatPetType);
		pet2.setOwner(owner2);
		pet2.setBirthDate(LocalDate.now());
		pet2.setName("Boncuk");
		owner2.getPets().add(pet2);
		ownerService.save(owner2);
		
		/* Visit */
		Visit catVisit = new Visit();
		 catVisit.setPet(pet2);
		 catVisit.setDate(LocalDate.now());
		 catVisit.setDescription("Sneezy Kitty");
		
		/* Speciality */
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiolgy = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(radiology);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(radiology); 
		
		/* Vets*/
		Vet vet1 = new Vet();
		vet1.setLastName("İnan");
		vet1.setFirstName("Deniz");
		vet1.getSpecialities().add(savedRadiolgy);
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
 		vet2.setFirstName("Ecrin");
		vet2.setLastName("Naz");
		vet2.getSpecialities().add(savedSurgery);
		vetService.save(vet2);
	}
	
}
