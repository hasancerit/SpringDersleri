package guru.springframework.petclinic.PetClinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person{
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialites",joinColumns = @JoinColumn(name = "vet_id"),
				inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> specialities = new HashSet<Speciality>();

	
	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}
	
	
}
