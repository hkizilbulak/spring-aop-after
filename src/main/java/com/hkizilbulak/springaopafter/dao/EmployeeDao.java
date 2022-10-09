package com.hkizilbulak.springaopafter.dao;

import com.hkizilbulak.springaopafter.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    private static final String HASH_KEY = "HASH_KEY";
    @Autowired
    private RedisTemplate redisTemplate;

    public Employee save(Employee employee) {
        redisTemplate.opsForHash().put(HASH_KEY, employee.getId(), employee);
        return employee;
    }
}
