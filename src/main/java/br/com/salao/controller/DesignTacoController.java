package br.com.salao.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.salao.entity.Ingredient;
import br.com.salao.entity.Ingredient.Type;
import br.com.salao.entity.Taco;
import br.com.salao.repository.IngredientRepository;
import br.com.salao.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	private TacoRepository tacoRepository;
	
	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {	
		this.ingredientRepository = ingredientRepository;
		this.tacoRepository = tacoRepository;
	}

	@GetMapping
	public String showDesignForm(Model model) {
		
		List<Ingredient> ingredients = ingredientRepository.findAll();
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			List<Ingredient> list =	ingredients.stream()
				.filter( i -> i.getType().equals(type)).collect(Collectors.toList());
			model.addAttribute(type.toString().toLowerCase(), list);			
		}
					
		model.addAttribute("taco", new Taco());
		return "design";
	}
	
	@PostMapping
	public String processTaco(@Valid Taco taco, Errors errors) {
		if( errors.hasErrors() ) {
			log.info("processing design: " + errors);
			return "design";
		}
		// Save the taco design
		tacoRepository.save(taco);
		// We'll do this in chapter 33
		
		log.info("processing design: " + taco);
		return "redirect:/orders/current";
	}
}
