package com.example.demo.dao;
import javax.transaction.*;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Patient;

@Transactional
public interface PatientInfo extends CrudRepository<Patient,String>{
		
}
