package com.jfsd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfsd.model.Examen;

public interface IExamenRepo extends JpaRepository<Examen, Integer>{

}
