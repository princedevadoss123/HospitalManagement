package com.example.demo.dao;
import javax.transaction.*;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Staff;

@Transactional
public interface StaffInfo extends CrudRepository<Staff,String>{
		
}
