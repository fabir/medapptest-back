package com.jfsd;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jfsd.model.Usuario;
import com.jfsd.repo.IUsuarioRepo;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MediappBackendApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private IUsuarioRepo repo;
	
	@Test
	void crearUsario() {
		Usuario user = new Usuario();
		user.setIdUsuario(4);
		user.setUsename("test");
		user.setPassword(bcrypt.encode("123"));
		user.setEnabled(false);
		
		Usuario retorno = repo.save(user);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(user.getPassword()));
	}

}
