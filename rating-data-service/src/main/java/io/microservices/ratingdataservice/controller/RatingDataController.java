package io.microservices.ratingdataservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.microservices.ratingdataservice.model.RatingInfo;

@RestController
@RequestMapping("/rating")
public class RatingDataController {

	@GetMapping("/{id}")
	public RatingInfo getRatingInfoList(@PathVariable("id") int id){		
		if(id%2==0)
		return new RatingInfo(id,4);
		else
		return new RatingInfo(id,3);
		
	}
}
