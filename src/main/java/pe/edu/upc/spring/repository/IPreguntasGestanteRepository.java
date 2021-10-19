package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.PreguntasGestante;

@Repository
public interface IPreguntasGestanteRepository extends JpaRepository<PreguntasGestante, Integer>{
	@Query("from PreguntasGestante r where r.titulo like %:titulo%")
	List<PreguntasGestante> buscarNombre(@Param("titulo") String titulo);
}