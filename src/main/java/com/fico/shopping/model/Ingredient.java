package com.fico.shopping.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name="ingredients")
public class Ingredient implements Serializable {
	
	/**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ingid;
	@NotBlank
	private String name;
	@Positive
	private int amount;

	public int getIngid() {
		return ingid;
	}
	/*public void setIngid(int ingid) {
		this.ingid = ingid;
	}*/
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public int getAmount() {
	return amount;
	}
	public void setAmount(int amount) {
	this.amount = amount;
	}

}
