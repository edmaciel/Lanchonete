package com.br.snackbar.model;

import java.io.Serializable;
import java.util.List;

public class Snack implements Serializable {

    public Snack() {
    }

    public Snack(int id, String name, String image, List<Integer> ingredients) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
    }

    private int id;
    private String name;
    private String image;
    private List<Integer> ingredients;
    private List<Ingreditent> ingredientsFull;
    private String ingredientsString;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Integer> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public List<Ingreditent> getIngredientsFull() {
        return ingredientsFull;
    }

    public void setIngredientsFull(List<Ingreditent> ingredientsFull) {
        this.ingredientsFull = ingredientsFull;
    }

    public String getIngredientsString() {
        return ingredientsString;
    }

    public void setIngredientsString(String ingredientsString) {
        this.ingredientsString = ingredientsString;
    }
}
