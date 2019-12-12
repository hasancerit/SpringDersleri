package guru.springframework.petclinic.PetClinic.services.springdatajpa;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import guru.springframework.petclinic.PetClinic.model.Owner;
import guru.springframework.petclinic.PetClinic.repository.OwnerRepository;
import guru.springframework.petclinic.PetClinic.repository.PetRepository;
import guru.springframework.petclinic.PetClinic.repository.PetTypeRepository;
import guru.springframework.petclinic.PetClinic.services.Factory;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
	
	private String lastname = "Hasan";
	
	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerSDJpaService service;
	
	Owner returnOwner;

	@BeforeEach
	void setUp() throws Exception {
		returnOwner = Owner.builder().id(1L).lastName(lastname).build();
	}
	
	@Test
	void testFindAll() {
		Set<Owner> returnOwnerSet = new HashSet<Owner>();
		returnOwnerSet.add(Owner.builder().id(1L).build());
		returnOwnerSet.add(Owner.builder().id(2L).build());
		
		Mockito.when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
		
		Set<Owner> owners = service.findAll();
		
		assertNotNull(owners);
		
		assertEquals(2,owners.size());
	}
	
	@Test
	void testFindById() {
		Mockito.when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		
		Owner owner = service.findById(1L);
		assertNotNull(owner);
	}
	
	@Test
	void testFindByIdNotFound() {
		Mockito.when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		
		Owner owner = service.findById(1L);
		assertNull(owner);
	}

	@Test
	void testSave() {
		Owner ownerToSave = Owner.builder().id(1L).build();
		Mockito.when(ownerRepository.save(any())).thenReturn(returnOwner);
		
		Owner savedOwner = service.save(ownerToSave);
		assertNotNull(savedOwner);
		
		verify(ownerRepository).save(any());
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);
		
		verify(ownerRepository,times(1)).delete(any());
	}

	@Test
	void testDeleteById() {
		service.deleteById(1L);
		
		verify(ownerRepository,times(1)).deleteById(any());
	}

	@Test
	void testFindByLastName() {
		Owner returnOwner = Owner.builder().id(1L).lastName(lastname).build();
		
		Mockito.when(service.findByLastName(any())).thenReturn(returnOwner);
		
		Owner hasan = service.findByLastName(lastname);
		
		assertEquals(lastname,hasan.getLastName());
		verify(ownerRepository,times(1)).findByLastName(any()); 	
	}

}
