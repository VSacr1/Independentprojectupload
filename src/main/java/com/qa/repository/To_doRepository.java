package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.model.ToDo;

public interface To_doRepository extends JpaRepository<ToDo, Long>  {

}
