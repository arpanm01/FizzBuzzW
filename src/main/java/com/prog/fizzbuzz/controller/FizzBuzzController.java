package com.prog.fizzbuzz.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prog.fizzbuzz.creators.FizzBuzzCreator;
import com.prog.fizzbuzz.model.ErrorVO;
import com.prog.fizzbuzz.model.FizzBuzzVO;        

@RestController
public class FizzBuzzController {

	@RequestMapping(value="/fizzbuzz/{cap}", method=RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String dofizzbuzz(@PathVariable("cap") String cap) throws JsonProcessingException {

		
		FizzBuzzVO fbVO;
		ObjectMapper mapper = new ObjectMapper();
		
		try{
			if(Integer.parseInt(cap)>2)
			{
				FizzBuzzCreator fc = new FizzBuzzCreator();
				fbVO=(fc.logicCreator(Integer.valueOf(cap)));
				return mapper.writeValueAsString(fbVO);

			}
			else 
			{
				
				ErrorVO err = new ErrorVO();
				err.setErrorCode("ERR-001");
				err.setErrorMessage("Error: A value equal to or greater than 3 is expected.");
				return mapper.writeValueAsString(err);

			}
		}
		catch(Exception e)
		{	
			ErrorVO err = new ErrorVO();
			err.setErrorCode("ERR-002");
			err.setErrorMessage("Error: Incorrect value of variable.Please request with a numeric value.");
			return mapper.writeValueAsString(err);

		}
		
		
		}
	}