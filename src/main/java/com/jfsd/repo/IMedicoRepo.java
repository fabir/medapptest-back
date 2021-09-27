package com.jfsd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfsd.model.Medico;

public interface IMedicoRepo extends JpaRepository<Medico,Integer>{

}
