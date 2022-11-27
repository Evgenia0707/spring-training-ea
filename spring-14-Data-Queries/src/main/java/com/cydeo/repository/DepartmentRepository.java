package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

//display all departments in the Furniture Department
    List<Department> findByDepartment(String department);

//display all departments in the Health Division (3 -all same)
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

//display all Departments with Division name ends with 'isc'

    List<Department> findByDivisionEndsWith(String pattern);

//display top 3 departments with division name includes 'Hea' without duplicates (dist)
    List<Department> findDistinctTop3ByDivisionContaining(String pattern);

//"****************************************************************"
    //if not drive query

    //JPQL - need to write class name

//departments belongs differ division
    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> retrieveDepartmentDivision(List<String> division);

}
