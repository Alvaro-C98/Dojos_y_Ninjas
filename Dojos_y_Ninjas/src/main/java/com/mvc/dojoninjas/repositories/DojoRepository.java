package com.mvc.dojoninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.dojoninjas.models.Dojos;

@Repository
public interface DojoRepository extends CrudRepository<Dojos,Long>{
	List<Dojos> findAll();
	
}
