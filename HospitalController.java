package com.example.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;


    @GetMapping(value = "test/hospitals/{id}", headers = "Accept=application/json",produces = "application/json")
public @ResponseBody Hospital getHospital(@PathVariable("id") int id) throws Exception {
    	System.out.println("CONTROLLER ---getHospital");
    	 Hospital hospital = this.hospitalService.getHospital(id);
         return hospital;
    }

    @GetMapping(value = "test/hospitals/",headers = "Accept=application/json",produces = "application/json")
public @ResponseBody List<Hospital> getAllHospitals() throws Exception {
    	System.out.println("CONTROLLER ---getAllHospitals");
    	return this.hospitalService.getAllHospitals();
    }


    @PostMapping(value = "test/hospitals/",headers = "Accept=application/json",produces = "application/json")
public ResponseEntity<String> addHospital(@RequestBody Hospital hospital  ) {
    	System.out.println("CONTROLLER ---addHospital");
   hospitalService.addHospital(hospital);
   return new ResponseEntity<String>(HttpStatus.OK);
   
}

    @PostMapping(value = "test/hospitals/",headers = "Accept=application/json",produces = "application/json")
public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital) {
    	System.out.println("CONTROLLER ---updateHospital");
	hospitalService.updateHospital(hospital);
	return new ResponseEntity<String>(HttpStatus.OK);
}

    @DeleteMapping(value = "test/hospitals/",headers = "Accept=application/json",produces = "application/json")
public ResponseEntity<String> deleteHospital(@RequestBody Hospital hospital) {
    	System.out.println("CONTROLLER ---deleteHospital");	
hospitalService.deleteHospital(hospital);
	return new ResponseEntity<String>(HttpStatus.OK);
}

}
