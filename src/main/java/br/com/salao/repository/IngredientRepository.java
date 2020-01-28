package br.com.salao.repository;

import java.util.List;

import br.com.salao.entity.Ingredient;

public interface IngredientRepository {
	
	List<Ingredient> findAll();
	
	Ingredient findOne(String id);
	
	Ingredient save(Ingredient ingredient);
}
