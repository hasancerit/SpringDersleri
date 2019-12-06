package guru.springframework.RecipeApp.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import javax.swing.Spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.RecipeApp.model.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeausureRepositoryIT {

	@Autowired
	UnitOfMeausureRepository unitOfMeausureRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	@DirtiesContext
	public void findByDescription() throws Exception{
		Optional<UnitOfMeasure> uomOptional = unitOfMeausureRepository.findByDescription("Teaspoon");
		assertEquals("Teaspoon",uomOptional.get().getDescription());
	}
	
	@Test
	public void findByDescriptionCup() throws Exception{
		Optional<UnitOfMeasure> uomOptional = unitOfMeausureRepository.findByDescription("Cup");
		assertEquals("Cup",uomOptional.get().getDescription());
	}
}
