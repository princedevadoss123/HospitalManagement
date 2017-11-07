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
		
		@Override
		public List<DoctorTO> getDoctorDetails() {
		List<DoctorTO> doc=new ArrayList<DoctorTO>();
		List<Staff> st=(List<Staff>)staff.findAll();
		for(Staff s:st) {
			DoctorTO docc=new DoctorTO();
			docc.setS_ID(s.getS_ID());
			docc.setS_NAME(s.getS_name());
			docc.setRole(s.getRole());
			docc.setSpecialist(s.getSpecialist());
			docc.setPassword(s.getPassword());
			doc.add(docc);
		}
		return doc;
		}
		
		@Override
		public DoctorTO getSingleDetail(String id){
			
			DoctorTO temp=new DoctorTO();
			Staff st=staff.findOne(id);
			if(st!=null){
			temp.setRole(st.getRole());
			temp.setS_ID(st.getS_ID());
			temp.setS_NAME(st.getS_name());
			temp.setSpecialist(st.getSpecialist());
			temp.setPassword(st.getPassword());
			}
			else
			{
			temp.setS_NAME("Not present");	
			}
			return(temp);
		}
}
