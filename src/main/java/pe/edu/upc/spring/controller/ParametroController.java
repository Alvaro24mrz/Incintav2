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

import pe.edu.upc.spring.model.Parametro;
import pe.edu.upc.spring.service.IParametroService;

@Controller
@RequestMapping("/parametro")
public class ParametroController {
	@Autowired
	private IParametroService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; 
	}
	
	@RequestMapping("/")
	public String irPaginaListadoParametros(Map<String, Object> model) {
		model.put("listaParametros", rService.listar());
		return "listParametro";  
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("parametro", new Parametro());
		return "parametro"; 
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Parametro objParametro, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "parametro";
		else {
			boolean flag = rService.grabar(objParametro);
			if (flag)
				return "redirect:/parametro/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un rochezaso, LUZ ROJA");
				return "redirect:/parametro/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Parametro> objParametro = rService.listarId(id);
		if (objParametro == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche, LUZ ROJA");
			return "redirect:/parametro/listar";
		}
		else {
			model.addAttribute("parametro",objParametro);
			return "parametro";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaParametros", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaParametros", rService.listar());
		}
		return "listParametro";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaParametros", rService.listar());
		return "listParametro";
	}
	
}
