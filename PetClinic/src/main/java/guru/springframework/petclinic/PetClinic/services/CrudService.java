package guru.springframework.petclinic.PetClinic.services;

import java.util.Set;

//Bu interfacede, diğer service interface'lerinde sık kullanılan metodlar tanımlanacak.
//Diğer interfaceler bunu extends edecek. ve kod tekrarı engellenecek
//CommonInterface
public interface CrudService<T,ID> {
	Set<T> findAll();
	
	T findById(ID Id);
	
	T save(T object);
	
	void delete(T object);
	
	void deleteById(ID Id);
	
}
