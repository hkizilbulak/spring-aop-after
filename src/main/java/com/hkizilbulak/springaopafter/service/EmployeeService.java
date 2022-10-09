package com.hkizilbulak.springaopafter.service;

import com.hkizilbulak.springaopafter.dao.EmployeeDao;
import com.hkizilbulak.springaopafter.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    public void throwException() throws Exception {
        throw new Exception("Exception occured");
    }
}
