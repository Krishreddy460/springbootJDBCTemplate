package com.springboot.workers1.jdbcexample.repository;

import java.util.List;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers1.jdbcexample.dao.WorkerDAO;
import com.springboot.workers1.jdbcexample.model.Worker;
import com.springboot.workers1.jdbcexample.Mapper.WorkerMapper;

@Repository
public class WorkerRepository implements WorkerDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplateObj;

	@Override 
	public void add(Worker worker) throws SQLException {
		String sql = "insert into worker values ("+
				"?,?,?,?,?,?,?"+
				")";
		
		jdbcTemplateObj.update(
				sql,
				worker.getWorkerId(),
				worker.getFirstName(),
				worker.getLastName(),
				worker.getSalary(),
				worker.getJoiningDate(),
				worker.getDepartment(),
				worker.getEmail()
				);
			
		System.out.println("Worker "+worker.getFirstName()+" added successfully");
	}
	
	@Override
	public void delete(int workerId) throws SQLException {
		String sql = "delete from worker where worker_id=?";
		jdbcTemplateObj.update(sql, workerId);
		System.out.println("Record #"+workerId+" deleted successfully");
	}
	
	public Worker getWorker(int workerId) throws SQLException {
		String sql = "select * from worker where worker_id=?";
		Worker worker = jdbcTemplateObj.queryForObject(
				sql,
				new Object[] {workerId},
				new WorkerMapper()
				);
				
		return worker;
	}

	public List<Worker> getWorkers() throws SQLException {
		String sql = "select * from worker";
		List<Worker> workers = jdbcTemplateObj.query(
				sql,
				new WorkerMapper()
				);
		
		return workers;
	}

	public void update(Worker worker) throws SQLException {
        String sql = "update worker "+
                "set first_name=?,"+
                "last_name=?,"+
                "salary=?,"+
                "joining_date=?,"+
                "department=?,"+
                "mmmail=?"+
                "where worker_id=?";
        
        jdbcTemplateObj.update(
				sql,
				worker.getFirstName(),
				worker.getLastName(),
				worker.getSalary(),
				worker.getJoiningDate(),
				worker.getDepartment(),
				worker.getEmail(),
				worker.getWorkerId()
				);
        
        System.out.println("Record #"+worker.getWorkerId()+" updated successfully");
	}
}  	
