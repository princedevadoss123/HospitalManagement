package com.example.demo.service;

import java.util.List;

import com.example.demo.model.DoctorTO;
import com.example.demo.model.PatientTO;

public interface HospitalService {
		List<DoctorTO> getDoctorDetails();
		DoctorTO getSingleDetail(String id);
		String registerPatient(PatientTO patient);
}
