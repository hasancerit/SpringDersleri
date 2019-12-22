package guru.springframework.RecipeApp.services.ımp;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.RecipeApp.commands.UnitOfMeasureCommand;
import guru.springframework.RecipeApp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.RecipeApp.repositories.UnitOfMeausureRepository;
import guru.springframework.RecipeApp.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UnıtOfMeasureServiceImp implements UnitOfMeasureService{

	    private final UnitOfMeausureRepository unitOfMeasureRepository;
	    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

	    @Autowired
	    public UnıtOfMeasureServiceImp(UnitOfMeausureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
	        this.unitOfMeasureRepository = unitOfMeasureRepository;
	        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
	    }

	    @Override
	    public Set<UnitOfMeasureCommand> listAllUoms() {

	        return StreamSupport.stream(unitOfMeasureRepository.findAll()
	                .spliterator(), false)
	                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
	                .collect(Collectors.toSet());
	    }
	
}
