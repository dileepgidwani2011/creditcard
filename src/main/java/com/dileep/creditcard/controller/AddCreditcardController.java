package com.dileep.creditcard.controller;

import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dileep.creditcard.model.CacheManagement;
import com.dileep.creditcard.model.Creditcard;
import com.dileep.creditcard.utilities.Validator;

/**
 * AddCreditcardController is for adding the new creditcard
 * @author dileep
 *
 */
@RestController
@RequestMapping("/creditcard/")
public class AddCreditcardController 
{
	/**
	 * This method receives the creditcard details and add it to cache if the cardnumber is valid
	 * @param reqCreditcard
	 * @return
	 */
	@PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addCreditCard(@RequestBody Map<String, String> reqCreditcard)
	{
		String response = "Success";
		
		String cardnumber = StringEscapeUtils.escapeSql(reqCreditcard.get("cardnumber"));
		String name = StringEscapeUtils.escapeSql(reqCreditcard.get("name"));
		String limit = StringEscapeUtils.escapeSql(reqCreditcard.get("limit"));
		
		if (!Validator.isExists(cardnumber) || !Validator.verifyRegex(cardnumber)
				|| !Validator.validateCardNumber(cardnumber)) 
		{
			System.out.println("cardnumber is invalid" + cardnumber);
			response = "Failed";
		}
		
		if (response.equals("Success"))
		{
			Creditcard creditcard = new Creditcard(name, cardnumber, limit);
			CacheManagement.addCreditcard(creditcard);
		}
		
		return response;
	}

}
