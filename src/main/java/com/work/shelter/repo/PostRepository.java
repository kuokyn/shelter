package com.work.shelter.repo;

import com.work.shelter.entity.Animal;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * Repository for animal cards.
 * Contains basic CRUD methods from CrudRepository interface.
 *
 */
public interface PostRepository extends CrudRepository<Animal, Long> {

}
