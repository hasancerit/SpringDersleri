package guru.springframework.petclinic.PetClinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Maps;

import guru.springframework.petclinic.PetClinic.model.Owner;

class OwnerServiceMapTest {
	
	OwnerServiceMap ownerServiceMap;
	final Long ownerId = 1L;
	final String lastname = "Hasan";
	
	@BeforeEach
	void setUp() throws Exception {
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastname).build());
	}

	@Test
	void testFindAll() {
		Set<Owner> owners =  ownerServiceMap.findAll();
		
		assertEquals(1,owners.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerServiceMap.findById(ownerId);
		
		assertEquals(ownerId,owner.getId());
	}

	@Test
	void testSaveExistingIdOwner() {
		Long id = 2L;
		Owner owner2 = Owner.builder().id(id).build();
		
		Owner savedOwner = ownerServiceMap.save(owner2);
		
		assertEquals(id, savedOwner.getId());
	}
	

	@Test
	void testSaveNoIdOwner() {
		Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
		
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}


	@Test
	void testDeleteOwner() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		ownerServiceMap.deleteById(ownerId);
		
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner hasan = ownerServiceMap.findByLastName(lastname);
		
		assertNotNull(hasan);
		assertEquals(ownerId,hasan.getId());
	}

}
