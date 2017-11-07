package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DoctorTO;
import com.example.demo.service.HospitalService;

@RestController
@RequestMapping(value="/hospital")
public class HospitalController {
	@Autowired
	private HospitalService controller;
	
	@RequestMapping(value="/view",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<DoctorTO> getDoctorDetails() {
		return controller.getDoctorDetails();
	}
	
}
