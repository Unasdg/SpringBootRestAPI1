package com.example.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	


public List<Hospital> getAllHospitals(){
	System.out.println("INSIDE getAllHospitals");

	List<Hospital> hospitalList= new ArrayList<Hospital>();
	hospitalRepository.findAll().forEach(hospitalList::add);
	return hospitalList;


}

public Hospital getHospital(int id){
	System.out.println("INSIDE getHospital");
    
   return hospitalRepository.findOne(id);
}

public void addHospital(Hospital hospital){
	System.out.println("INSIDE addHospital");
  hospitalRepository.save(hospital);
}

public void updateHospital(Hospital hospital){
Hospital hospitalDetails = hospitalRepository.findOne(hospital.getId());
System.out.println("INSIDE updateHospital");
        hospitalRepository.save(hospitalDetails);

}

public void deleteHospital(Hospital hospital) {
	System.out.println("INSIDE deleteHospital");
Hospital hospitalDetails = hospitalRepository.findOne(hospital.getId());
hospitalRepository.delete(hospitalDetails);
}
}
