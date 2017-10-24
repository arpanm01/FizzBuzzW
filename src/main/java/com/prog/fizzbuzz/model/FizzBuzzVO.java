package com.prog.fizzbuzz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreType
public class FizzBuzzVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty
	List<Integer> fizz;
	
	@JsonProperty
	List<Integer> buzz;

	@JsonProperty
	List<Integer> fizzbuzz;

	
	public FizzBuzzVO() {
		super();
		this.fizz = new ArrayList<Integer>();
		this.buzz = new ArrayList<Integer>();
		this.fizzbuzz = new ArrayList<Integer>();
	}

	
	public List<Integer> getFizz() {
		return fizz;
	}

	public void setFizz(List<Integer> fizz) {
		this.fizz = fizz;
	}

	public List<Integer> getBuzz() {
		return buzz;
	}

	public void setBuzz(List<Integer> buzz) {
		this.buzz = buzz;
	}

	public List<Integer> getFizzbuzz() {
		return fizzbuzz;
	}

	public void setFizzbuzz(List<Integer> fizzbuzz) {
		this.fizzbuzz = fizzbuzz;
	}
	

}