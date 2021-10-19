package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.PreguntasGestante;

public interface IPreguntasGestanteService {
	public boolean grabar(PreguntasGestante preguntasGestante);
	//public boolean modificar(Dueno dueno);
	public void eliminar(int idPreguntasGestante);
	public Optional<PreguntasGestante> listarId(int idPreguntasGestante);
	public List<PreguntasGestante> listar();
}
