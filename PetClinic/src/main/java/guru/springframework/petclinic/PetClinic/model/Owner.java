package guru.springframework.petclinic.PetClinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person{
	
	@Builder
	public Owner(Long id,String firstName, String lastName, Set<Pet> pets, String address, String telephone, String city) {
		super(id,firstName, lastName);
		this.pets = pets;
		this.address = address;
		this.telephone = telephone;
		this.city = city;
	}
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
	private Set<Pet> pets = new HashSet<Pet>();
	private String address;
	private String telephone;
	private String city;
}
