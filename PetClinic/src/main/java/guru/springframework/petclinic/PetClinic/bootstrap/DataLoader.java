package guru.springframework.petclinic.PetClinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.petclinic.PetClinic.model.Owner;
import guru.springframework.petclinic.PetClinic.model.Vet;
import guru.springframework.petclinic.PetClinic.services.OwnerService;
import guru.springframework.petclinic.PetClinic.services.VetService;
import guru.springframework.petclinic.PetClinic.services.map.OwnerServiceMap;
import guru.springframework.petclinic.PetClinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
	private OwnerService ownerService;
	private VetService vetService;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	//Spring Context tamamen olustugunda cağirigilir
	@Override
	public void run(String... args) throws Exception {
		Owner owner = new Owner();
		owner.setFirstName("Hasan");
		owner.setLastName("Cerit");
		ownerService.save(owner);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Batuhan");
		owner2.setLastName("Cerit");
		ownerService.save(owner2);
		
		Vet vet1 = new Vet();
		vet1.setLastName("İnan");
		vet1.setFirstName("Deniz");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
 		vet2.setFirstName("Ecrin");
		vet2.setLastName("Naz");
		vetService.save(vet2);
	}
	
}
