package com.in28minutes.rest.restfulwebservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  
	@RequestMapping("/test")
	public void demo()
	{
		throw new RuntimeException("data not found");
	}
	
	@RequestMapping("/data")
	public ResponseEntity<String> data()
	{
		int i=1;
		if (i==3)
		{
			return new ResponseEntity<>("data 1",HttpStatus.BAD_REQUEST);
		}
		throw new RuntimeException("data internal server error not found");
	}


	@GetMapping("/hello")
	ResponseEntity<String> hello() {
	    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	@GetMapping("/age/{yearOfBirth}")
	ResponseEntity<String> age(@PathVariable("yearOfBirth") int yearOfBirth) {
	  
	    if (yearOfBirth == 1) {
	        
	    	return new ResponseEntity<>(
	          "Year of birth cannot be in the future" + yearOfBirth, 
	          HttpStatus.BAD_REQUEST);
	    }
	 
	    return new ResponseEntity<>("Your age is " + yearOfBirth,HttpStatus.OK);
	}
}
