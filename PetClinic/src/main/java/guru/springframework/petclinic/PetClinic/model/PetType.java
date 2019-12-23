package guru.springframework.petclinic.PetClinic.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import guru.springframework.petclinic.PetClinic.model.Pet.PetBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {
	@Builder
	public PetType(Long id,String name) {
		super(id);
		this.name = name;
	}
	
	private String name;

	@Override
	public String toString() {
		return name;
	}
	
	
}
