package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Patient;
import com.example.demo.model.PatientTO;
import com.example.demo.service.HospitalService;

@RestController
@RequestMapping(value="/patient")
public class PatientController {
	@Autowired
	private HospitalService controller;
	
	@RequestMapping(value="/addPatient",method=RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE)
	public String registerPatient(@RequestBody PatientTO patient) {
		System.out.println(patient.getP_ID());
		System.out.println(patient.getP_Name());
		return controller.registerPatient(patient);
	}
	@RequestMapping(value="/getPatient/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public PatientTO GetPatient(@PathVariable("id") String id) {
		
		return controller.GetPatient(id);
	}
}
