package com.fico.shopping.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="recipes")
public class Recipe {
/**
	 * 
	 */
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
@NotBlank
private String name;
@NotBlank
private String description;
@NotBlank
private String imagepath;

private ArrayList<Ingredient> ingredients;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getImagepath() {
	return imagepath;
}
public void setImagepath(String imagepath) {
	this.imagepath = imagepath;
}
public ArrayList<Ingredient> getIngredients() {
	return ingredients;
}
public void setIngredients(ArrayList<Ingredient> ingredients) {
	this.ingredients = ingredients;
}


}
