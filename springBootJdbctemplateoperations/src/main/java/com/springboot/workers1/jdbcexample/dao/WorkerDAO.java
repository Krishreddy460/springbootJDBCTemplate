package com.springboot.workers1.jdbcexample.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers1.jdbcexample.model.Worker;

public interface WorkerDAO {
        public void add(Worker worker)
                        throws SQLException;

        public void delete(int workerId)
                        throws SQLException;

        public Worker getWorker(int workerId)
                        throws SQLException;

        public List<Worker> getWorkers()
                        throws SQLException;

        public void update(Worker emp)
                        throws SQLException;

}
