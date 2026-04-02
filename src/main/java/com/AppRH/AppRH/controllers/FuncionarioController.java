package com.AppRH.AppRH.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.AppRH.AppRH.models.Dependentes;
import com.AppRH.AppRH.models.Funcionario;
import com.AppRH.AppRH.repository.DependentesRepository;
import com.AppRH.AppRH.repository.FuncionarioRepository;

import jakarta.validation.Valid;


//import com.AppRH.AppRH.repository.CandidatoRepository;
//import com.AppRH.AppRH.repository.VagaRepository;
//import jakarta.validation.Valid;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository fr;
	
	@Autowired
	private DependentesRepository dr;
	
	//CHAMA O FORM DE cadastrar funcionario
	@RequestMapping(value =  "/cadastrarFuncionario", method = RequestMethod.GET)
	public String form() {
		return "funcionario/formFuncionario";
		
	}
	
	//CASDATRAR FUNCIONARIO
	@RequestMapping(value =  "/cadastrarFuncionario", method = RequestMethod.POST)
	public String form(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarFuncionario";
		}
		
		fr.save(funcionario);
		attributes.addFlashAttribute("mensagem", "Funcionário cadastrado com sucesso!");
		return "redirect:/cadastrarFuncionario";
		
	}
	
	//listarFuncionaro
	@RequestMapping("/funcionarios")
	public ModelAndView listarFuncionario() {
		
		ModelAndView mv = new ModelAndView("funcionario/listarFuncionario");
		Iterable<Funcionario> funcionarios = fr.findAll();
		mv.addObject("funcionarios", funcionarios);
		return mv;
		
	}
	
	//Listar dependentes
	@RequestMapping(value = "/dependentes/{id}", method = RequestMethod.GET)
	public ModelAndView dependentes(@PathVariable("id") long id) {
		
		Funcionario funcionario = fr.findById(id);
		ModelAndView mv = new ModelAndView("funcionario/dependente");
		mv.addObject("funcionario", funcionario);
		
		Iterable<Dependentes> dependentes = dr.findByFuncionario(funcionario);
		mv.addObject("dependentes",dependentes);
		
		return mv;
	}
	
	
	//Adiconar dependentes
	@RequestMapping(value = "/dependentes/{id}", method = RequestMethod.POST)
	public String dependetesPost(@PathVariable("id") long id, Dependentes dependentes,BindingResult result, RedirectAttributes attributes ) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/dependentes/{id}";
		}
		
		if(dr.findByCpf(dependentes.getCpf()) !=null) {
			attributes.addFlashAttribute("mensagem", "CPF duplicado!");
			return "redirect:/dependentes/{id}";		
		}
		
		Funcionario funcionario = fr.findById(id);
		dependentes.setFuncionario(funcionario);
		dr.save(dependentes);
		attributes.addFlashAttribute("mensagem", "Adicionado com sucesso!");
		return "redirect:/dependentes/{id}";

	}
	
	//deletar funcionario
	@RequestMapping("/deletarFuncionario")
	public String deletarFuncionario(long id) {
		Funcionario funcionario = fr.findById(id);
		fr.delete(funcionario);
		return "redirect:/funcionarios";
		
	}
	
	//atualizar funcionario
	@RequestMapping(value= "/editar-funcionario", method = RequestMethod.GET)
	public ModelAndView editarFuncionario(long id){
		Funcionario funcionario = fr.findById(id);
		ModelAndView mv = new ModelAndView("funcionario/update-funcionario");
		mv.addObject("funcionario", funcionario);
		return mv;
		
	}
	
	//update funcionario
	@RequestMapping(value ="/editar-funcionario", method = RequestMethod.POST)
	public String updateFuncionario(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes) {
		
		fr.save(funcionario);
		attributes.addFlashAttribute("success", "Alterado com sucesso!");
		
		long idLong = funcionario.getId();
		String id =  "" + idLong;
		return "redirect:/dependentes/" + id;
		
	}
	
	//deletar dependente
	@RequestMapping("/deletarDependente")
	public String deletarDependete(String cpf) {
		Dependentes dependente = dr.findByCpf(cpf);
		
		Funcionario funcionario = dependente.getFuncionario();
		String codigo = "" + funcionario.getId();
		
		dr.delete(dependente);
		return "redirect:/dependentes/" + codigo;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
