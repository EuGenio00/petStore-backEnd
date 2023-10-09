package com.senai.pets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

import com.senai.pets.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
