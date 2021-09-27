package com.jfsd.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Menu;
import com.jfsd.repo.IMenuRepo;
import com.jfsd.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService{

	@Autowired
	private IMenuRepo repo;
	
	@Override
	public Menu registrar(Menu obj) {
		return repo.save(obj);
	}

	@Override
	public Menu modificar(Menu obj) {
		return repo.save(obj);
	}

	@Override
	public List<Menu> listar() {
		return repo.findAll();
	}

	@Override
	public Menu listarPorId(Integer id) {
		Optional<Menu> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Menu();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		List<Menu> menus = new ArrayList<>();
		repo.listarMenuPorUsuario(nombre).forEach(x -> {
			Menu m = new Menu();
			m.setIdMenu((Integer.parseInt(String.valueOf(x[0]))));
			m.setNombre(String.valueOf(x[1]));
			m.setUrl(String.valueOf(x[2]));		
			
			menus.add(m);
		});
		return menus;
	}

}

