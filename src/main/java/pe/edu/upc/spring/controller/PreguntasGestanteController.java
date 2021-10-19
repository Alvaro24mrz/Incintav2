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

import pe.edu.upc.spring.model.PreguntasGestante;
import pe.edu.upc.spring.service.IPreguntasGestanteService;

@Controller
@RequestMapping("/preguntasGestante")
public class PreguntasGestanteController {
	@Autowired
	private IPreguntasGestanteService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEventos(Map<String, Object> model) {
		model.put("listaGestantes", rService.listar());
		return "listGestante"; // "listGestante" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("preguntasGestante", new PreguntasGestante());
		return "preguntasGestante"; // "race" es una pagina del frontEnd para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute PreguntasGestante objRace, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "preguntasGestante";
		else {
			boolean flag = rService.grabar(objRace);
			if (flag)
				return "redirect:/preguntasGestante/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un rochezaso, LUZ ROJA");
				return "redirect:/preguntasGestante/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<PreguntasGestante> objPreguntasGestante = rService.listarId(id);
		if (objPreguntasGestante == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche, LUZ ROJA");
			return "redirect:/preguntasGestante/listar";
		}
		else {
			model.addAttribute("preguntasGestante",objPreguntasGestante);
			return "preguntasGestante";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaGestantes", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaGestantes", rService.listar());
		}
		return "listGestante";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaGestantes", rService.listar());
		return "listGestante";
	}
	
}
