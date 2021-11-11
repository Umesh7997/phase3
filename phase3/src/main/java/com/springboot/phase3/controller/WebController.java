package com.springboot.phase3.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.phase3.model.Buynow;
import com.springboot.phase3.model.Student;
import com.springboot.phase3.repo.BuynowRepository;
import com.springboot.phase3.repo.StudentRepository;
import com.springboot.phase3.rnf.ResourceNotFound;

@RestController
@CrossOrigin(origins = "http://localhost:4200")                

@RequestMapping("/api")
public class WebController {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private BuynowRepository buynowRepository;
	
	
	// get all students
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}		
	
	// create student rest api
	
	@PostMapping("/save-student")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	
	// get all buynows
	
	@GetMapping("/buynow")
	public List<Buynow> getAllBuynows(){
		return buynowRepository.findAll();
	}		
	
	// create buynow rest api
	@PostMapping("/save-buynow")
	public Buynow createBuynow(@RequestBody Buynow buynow) {
	
		return buynowRepository.save(buynow);
	}
	
	
	
	// get student by id rest api
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Student not exist with id :" + id));
		return ResponseEntity.ok(student);
	}
	
	// get buynow by id rest api
	
		@GetMapping("/buynow/{id}")
		public ResponseEntity<Buynow> getBuynowById(@PathVariable Long id) {
			Buynow buynow = buynowRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFound("Buynow not exist with id :" + id));
			return ResponseEntity.ok(buynow);
		}
		
	

	
	// update student rest api
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails){
		Student student = studentRepository.findById(id)
				.orElseThrow();
		
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setGender(studentDetails.getGender());
		student.setEmailId(studentDetails.getEmailId());
		
		Student updatedStudent = studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	//update buynow rest api
	
	@PutMapping("/buynow/{id}")
	public ResponseEntity<Buynow> createBuyer(@PathVariable Long id, @RequestBody Buynow buynowDetails){
		Buynow buynow = buynowRepository.findById(id)
				.orElseThrow();
		
		buynow.setBookName(buynowDetails.getBookName());
		buynow.setUserName(buynowDetails.getUserName());
		buynow.setEmailId(buynowDetails.getEmailId());
		buynow.setPhoneNumber(buynowDetails.getPhoneNumber());
		buynow.setAddress(buynowDetails.getAddress());
		buynow.setOrderDate(buynowDetails.getOrderDate());
		buynow.setState(buynowDetails.getState());
		buynow.setCity(buynowDetails.getCity());
		buynow.setZipCode(buynowDetails.getZipCode());
		
		Buynow updatedBuynow = buynowRepository.save(buynow);
		return ResponseEntity.ok(updatedBuynow);
	}
	
	
	
	
	
	// delete student rest api
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){
		Student student = studentRepository.findById(id)
				.orElseThrow();
		
		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	// delete buynow rest api
	
	@DeleteMapping("/buynow/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBuynow(@PathVariable Long id){
		Buynow buynow = buynowRepository.findById(id)
				.orElseThrow();
		
		buynowRepository.delete(buynow);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}






