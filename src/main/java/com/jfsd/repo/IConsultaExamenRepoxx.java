package com.jfsd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jfsd.model.Consulta;


public interface IConsultaExamenRepoxx extends JpaRepository<Consulta, Integer>{

	@Modifying //para indicarle que esto no va a devolver un resulset sino una sentencia de modificacion,por jrmplo el numero de filas insertadas en este caso (se recomeintda para insert,update,delete)
	@Query(value="INSERT INTO consulta_examen(id_consulta,id_examen) VALUES (:idConsulta,:idExamen)",nativeQuery=true)
	Integer registrar(@Param("idConsulta") Integer idConsulta,@Param("idExamen") Integer idExamen);
}
