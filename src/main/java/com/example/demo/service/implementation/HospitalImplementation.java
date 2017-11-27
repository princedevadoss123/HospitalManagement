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
		private PatientInfo patientinfo ;
		
	
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
		
		@Override
		public DoctorTO login(String id,String password){
			DoctorTO temp=new DoctorTO();
			Staff st=staff.findOne(id);
			if(st!=null && password.equals(st.getPassword()))
			{
				temp.setRole(st.getRole());
				temp.setS_ID(st.getS_ID());
				temp.setS_NAME(st.getS_name());
				temp.setSpecialist(st.getSpecialist());
			}
			else{
				temp.setS_NAME("LOGIN FAILED");
			}
			return(temp);
		}
		
		@Override
		public String add(String id,String name,String specialist,String password){
			
			DoctorTO doc=getSingleDetail(id);
			if(doc.getS_ID()==null){
				Staff st=new Staff();
				st.setRole(1);
				st.setPassword(password);
				st.setS_ID(id);
				st.setS_name(name);
				st.setSpecialist(specialist);
				staff.save(st);
				return "done";
			}
			else{
				return "Already present";
			}
		}
		
		@Override
		public String delete(String id){
			
			DoctorTO doc=getSingleDetail(id);
			if(doc.getS_ID()!=null){
				staff.delete(id);
				return("done");
			}
			else{
				return("Not Present");
			}
			
		}
		
		@Override
		public String update(String id,String name,String password){
			
			DoctorTO doc=getSingleDetail(id);
			if(doc.getS_ID()!=null){
				Staff st=new Staff();
				st.setRole(doc.getRole());
				st.setPassword(password);
				st.setS_ID(doc.getS_ID());
				st.setS_name(name);
				st.setSpecialist(doc.getSpecialist());
				staff.save(st);
				return "done";
			}
			else{
				return "failed";
			}
		}
		
		@Override
		public PatientTO GetPatient(String id) {
			PatientTO pt=new PatientTO();
			Patient p = patientinfo.findOne(id);
			if(p!=null){
			pt.setP_ID(p.getP_ID());
			pt.setP_Name(p.getP_Name());
			return(pt);
			
		
			}
			else {
				pt.setP_Name("not found");
		
			}
			return pt;
		}
}

