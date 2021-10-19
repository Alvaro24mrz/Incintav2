package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Eventos;

public interface IEventosService {
	public boolean grabar(Eventos eventos);
	//public boolean modificar(Dueno dueno);
	public void eliminar(int idEventos);
	public Optional<Eventos> listarId(int idEventos);
	public List<Eventos> listar();
}