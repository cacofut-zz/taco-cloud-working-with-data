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
import br.com.salao.repository.IngredientRepositorySpringData;

@SpringBootApplication
public class TacoCloud01Application implements WebMvcConfigurer, CommandLineRunner{
	
	@Autowired
	//private IngredientRepository ingredientRepository;
	private IngredientRepositorySpringData ingredientRepository;
	

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
			new Ingredient(null, "FLTO", "Flour Tortilla", Type.WRAP),
			new Ingredient(null, "COTO", "Corn Tortilla",  Type.WRAP),
			new Ingredient(null, "GRBF", "Ground Beef", 	 Type.PROTEIN),
			new Ingredient(null, "CARN", "Carnitas", 		 Type.PROTEIN),
			new Ingredient(null, "TMTO", "Diced Tomatoes", Type.VEGGIES),
			new Ingredient(null, "LETC", "Lettuce", 		 Type.VEGGIES),
			new Ingredient(null, "CHED", "Cheddar", 		 Type.CHEESE),
			new Ingredient(null, "JACK", "Monterrey",		 Type.CHEESE),
			new Ingredient(null, "SLSA", "Salsa", 		 Type.SAUCE),
			new Ingredient(null, "SRCR", "Sour cream", 	 Type.SAUCE)
			  
		);
		for (Ingredient ingredient : ingredients) {
			ingredientRepository.save(ingredient);
		}
			
		
	}

}
