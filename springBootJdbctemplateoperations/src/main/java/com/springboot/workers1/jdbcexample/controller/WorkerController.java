package com.springboot.workers1.jdbcexample.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers1.jdbcexample.model.Worker;
import com.springboot.workers1.jdbcexample.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	
	@Autowired
	WorkerRepository workerRepo;
	static
	{
		System.out.print("vamsi reddy");
	}
	
	
	@GetMapping("/showWorker")
	public Worker showWorker() {
		try {
			return workerRepo.getWorker(1);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showWorkers() {
		try{
			return workerRepo.getWorkers();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/create")
	public String create() {
		try{
			Worker worker = new Worker(1, "gopika", "reddy",100,Date.valueOf("2022-03-15"), "SD", "krishna@org.in");
			workerRepo.add(worker);
			return worker.getFirstName()+" Added Successfully";
		} catch(SQLException e) {
			e.printStackTrace();
			return "Error while adding new record";
		}		
	}
	
	@GetMapping("/update")
	public String update() {
		try {
			Worker worker = new Worker(9, "gopika", "reddy",100,Date.valueOf("2022-03-15"), "SD", "krishna@org.in");
			workerRepo.update(worker);
			return "Email updated successfully";
		} catch(SQLException e) {
			e.printStackTrace();
			return "Error while updating the record";
		}
	}
	
	@GetMapping("/deleted")
	public String delete() {
		try {
			workerRepo.delete(1);
			return "Record deleted successfully";
		} catch(SQLException e) {
			e.printStackTrace();
			return "Error while deleting the record";
		}
	}
}
