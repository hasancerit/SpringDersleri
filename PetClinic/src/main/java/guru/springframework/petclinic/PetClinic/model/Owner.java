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
		this.address = address;
		this.telephone = telephone;
		this.city = city;

        if(pets != null) {
            this.pets = pets;
        }
	}
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
	private Set<Pet> pets = new HashSet<Pet>();
	private String address;
	private String telephone;
	private String city;
	
	  /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name) {
        return getPet(name, false);
    }
    
    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Pet pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }
}
