package com.example.demo.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StaffInfo;
import com.example.demo.domain.Staff;
import com.example.demo.model.DoctorTO;
import com.example.demo.service.HospitalService;

@Service
public class HospitalImplementation implements HospitalService {
		@Autowired
		private StaffInfo staff;
		
		private DoctorTO setDoctorTO(Staff s){
			DoctorTO docc=new DoctorTO();
			docc.setS_ID(s.getS_ID());
			docc.setS_NAME(s.getS_name());
			docc.setRole(s.getRole());
			docc.setSpecialist(s.getSpecialist());
			docc.setPassword(s.getPassword());
			return docc;
		}
		
		@Override
		public List<DoctorTO> getDoctorDetails() {
		List<DoctorTO> doc=new ArrayList<DoctorTO>();
		List<Staff> st=(List<Staff>)staff.findAll();
		for(Staff s:st) {
			doc.add(new HospitalImplementation().setDoctorTO(s));
		}
		return doc;
		}
		
		@Override
		public DoctorTO getSingleDetail(String id){
			
			DoctorTO temp=new DoctorTO();
			Staff st=staff.findOne(id);
			if(st!=null){
			temp=new HospitalImplementation().setDoctorTO(st);
			}
			else
			{
			temp.setS_NAME("Not present");	
			}
			return(temp);
		}
}
