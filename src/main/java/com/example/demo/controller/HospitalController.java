package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/viewdetail/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public DoctorTO getSingleDoctor(@PathVariable("id") String id){
		return controller.getSingleDetail(id);
	}
//	
//	@RequestMapping(value="/login/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
//	public DoctorTO getLogin(@PathVariable("id") Long id){
//		return controller.getSingleDetail(id);
//	}
	
}
