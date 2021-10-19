package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.PeriodoGestacion;
import pe.edu.upc.spring.service.IPeriodoGestacionService;

@Controller
@RequestMapping("/periodo")
public class PeriodoGestacionController {
	@Autowired
	private IPeriodoGestacionService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; 
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPeriodos(Map<String, Object> model) {
		model.put("listaPeriodos", rService.listar());
		return "listPeriodoGestacion";  
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("periodo", new PeriodoGestacion());
		return "periodo"; 
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute PeriodoGestacion objPeriodoGestacion, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "periodo";
		else {
			boolean flag = rService.grabar(objPeriodoGestacion);
			if (flag)
				return "redirect:/periodo/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un rochezaso, LUZ ROJA");
				return "redirect:/periodo/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<PeriodoGestacion> objPeriodoGestacion = rService.listarId(id);
		if (objPeriodoGestacion == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche, LUZ ROJA");
			return "redirect:/periodo/listar";
		}
		else {
			model.addAttribute("periodo",objPeriodoGestacion);
			return "periodo";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaPeriodos", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaPeriodos", rService.listar());
		}
		return "listPeriodoGestacion";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaPeriodos", rService.listar());
		return "listPeriodoGestacion";
	}
	
}
