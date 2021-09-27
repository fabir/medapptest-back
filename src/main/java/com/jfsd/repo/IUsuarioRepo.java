package com.jfsd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfsd.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
     Usuario findOneByUsename(String username);
}
