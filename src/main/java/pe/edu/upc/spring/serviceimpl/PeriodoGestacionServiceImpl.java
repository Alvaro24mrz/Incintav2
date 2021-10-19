package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.PeriodoGestacion;
import pe.edu.upc.spring.repository.IPeriodoGestacionRepository;
import pe.edu.upc.spring.service.IPeriodoGestacionService;

@Service
public class PeriodoGestacionServiceImpl implements IPeriodoGestacionService {

	@Autowired
	private IPeriodoGestacionRepository dPeriodoGestacion;
	
	@Override
	@Transactional
	public boolean grabar(PeriodoGestacion periodo) {
		PeriodoGestacion objPeriodoGestacion = dPeriodoGestacion.save(periodo);
		if (objPeriodoGestacion == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idPeriodoGestacion) {
		dPeriodoGestacion.deleteById(idPeriodoGestacion);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PeriodoGestacion> listarId(int idPeriodoGestacion) {
		return dPeriodoGestacion.findById(idPeriodoGestacion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PeriodoGestacion> listar() {
		return dPeriodoGestacion.findAll();
	}

	

}
