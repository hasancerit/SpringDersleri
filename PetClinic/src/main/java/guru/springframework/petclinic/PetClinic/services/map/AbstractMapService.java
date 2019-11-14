package guru.springframework.petclinic.PetClinic.services.map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import guru.springframework.petclinic.PetClinic.model.BaseEntity;

//Service imp'lerinde kullanılacak fonksiyonlar.
public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
	
	//Repo ile db yerine burada tuttuk 
	protected Map<Long, T> map = new HashMap<>();
	
	Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	T findById(ID id){
		return map.get(id);
	}
	
	T save(T t) {
		if(t != null) {
			if(t.getId() == null) {
				t.setId(getNextId());
		}else {
			throw new RuntimeException("Object cannot be null");
		}
			map.put(t.getId(),t);
		}
		return t;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	private Long getNextId() {
		Long nextId = null;
		try {
			nextId = Collections.max(map.keySet()) + 1;
		}catch (NoSuchElementException e) {
			nextId = 1L;
		}
		return nextId;
	}
}
