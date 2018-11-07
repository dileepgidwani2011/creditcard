package com.dileep.creditcard.controller;

import org.springframework.http.MediaType;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dileep.creditcard.model.CacheManagement;
import com.dileep.creditcard.model.Creditcard;

/**
 * QueryAllCreditcardsController is to return all the creditcards detail as a json array object
 * @author dileep
 *
 */
@RestController
@RequestMapping("/creditcard/")
public class QueryAllCreditcardsController 
{
	/**
	 * This method returns the all creditcards details from cache.
	 * @return
	 */
	@GetMapping(value="/query", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Creditcard> qeryCreditcards()
	{
		ArrayList<Creditcard> list = new ArrayList(CacheManagement.getMap().values());
		return list;
	}

}
