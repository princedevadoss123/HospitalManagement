package com.example.demo.service.implementation;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.spi.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.PatientController;
import com.example.demo.dao.PatientInfo;
import com.example.demo.dao.StaffInfo;
import com.example.demo.domain.Patient;
import com.example.demo.domain.Staff;
import com.example.demo.model.DoctorTO;
import com.example.demo.model.PatientTO;
import com.example.demo.service.HospitalService;

@Service
public class HospitalImplementation implements HospitalService {
		@Autowired
		private StaffInfo staff;

		@Autowired
		private PatientInfo patientinfo;

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

		@Override
		public String registerPatient(PatientTO patient) {
			
			System.out.println(patient.getP_ID());
			System.out.println(patient.getP_Name());
			Patient p = patientinfo.findOne(patient.getP_ID());
			
			if(p==null){
				patientinfo.save(setDB(patient.getP_ID(),patient.getP_Name()));
				return "Added";
			}
			else if(patientinfo.exists(p.getP_ID())){
				return "Existing";	
			}
			
			
			
			
				
			return null;
		}

		private Patient setDB(String p_ID, String p_Name) {
		Patient pp = new Patient();
		pp.setP_ID(p_ID);
		pp.setP_Name(p_Name);
			return pp;
		}
}
