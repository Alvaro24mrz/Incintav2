package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.PeriodoGestacion;

public interface IPeriodoGestacionService {
	public boolean grabar(PeriodoGestacion periodo);
	public void eliminar(int idPeriodoGestacion);
	public Optional<PeriodoGestacion> listarId(int idPeriodoGestacion);
	public List<PeriodoGestacion> listar();
}
