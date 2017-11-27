package com.example.demo.service;

import java.util.List;

import com.example.demo.model.DoctorTO;
import com.example.demo.model.PatientTO;

public interface HospitalService {
		List<DoctorTO> getDoctorDetails();
		DoctorTO getSingleDetail(String id);
		String registerPatient(PatientTO patient);
		DoctorTO login(String id,String password);
		String add(String id,String name,String specialist,String password);
		String delete(String id);
		String update(String id,String name,String password);
	   PatientTO GetPatient(String id);
}
