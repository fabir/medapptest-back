package com.jfsd.service;

import java.util.List;

import com.jfsd.model.Menu;

public interface IMenuService extends ICRUD<Menu,Integer>{
 List<Menu> listarMenuPorUsuario(String nombre);
}
