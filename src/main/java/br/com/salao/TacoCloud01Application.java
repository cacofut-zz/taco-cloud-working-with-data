package br.com.salao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.salao.entity.Ingredient;
import br.com.salao.entity.Ingredient.Type;
import br.com.salao.repository.IngredientRepository;

@SpringBootApplication
public class TacoCloud01Application implements WebMvcConfigurer, CommandLineRunner{
	
	@Autowired
	private IngredientRepository ingredientRepository;

	public static void main(String[] args) {
		SpringApplication.run(TacoCloud01Application.class, args);
	}
	

	
	@Override
	public void addViewControllers( ViewControllerRegistry registry ) {
		registry.addViewController("/").setViewName("home");
	}



	@Override
	public void run(String... args) throws Exception {
		List<Ingredient> ingredients = Arrays.asList(
			new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
			new Ingredient("COTO", "Corn Tortilla",  Type.WRAP),
			new Ingredient("GRBF", "Ground Beef", 	 Type.PROTEIN),
			new Ingredient("CARN", "Carnitas", 		 Type.PROTEIN),
			new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
			new Ingredient("LETC", "Lettuce", 		 Type.VEGGIES),
			new Ingredient("CHED", "Cheddar", 		 Type.CHEESE),
			new Ingredient("JACK", "Monterrey",		 Type.CHEESE),
			new Ingredient("SLSA", "Salsa", 		 Type.SAUCE),
			new Ingredient("SRCR", "Sour cream", 	 Type.SAUCE)
			
		);
		for (Ingredient ingredient : ingredients) {
			ingredientRepository.save(ingredient);
		}
			
		
	}

}
