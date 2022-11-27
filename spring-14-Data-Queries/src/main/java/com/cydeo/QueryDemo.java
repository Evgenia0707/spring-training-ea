package com.cydeo;

import com.cydeo.repository.DepartmentRepository;


import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {//created for testing

    private final RegionRepository regionRepository; //inject
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("--------------REGIONS-----inject first-------------------------");

        System.out.println("findByCountry:" + regionRepository.findByCountry("Canada"));//return from method in repository
        System.out.println("findByCountryContaining:" + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByRegionDesc:" + regionRepository.findByCountryContainsOrderByRegionDesc("United"));
        System.out.println("findTop2ByCountry:" + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTopByCountryContainsOrderByRegion:" + regionRepository.findTopByCountryContainsOrderByRegion("United States"));


        System.out.println("-------------DEPARTMENT---inject first-------------------------");

        System.out.println("findByDepartment:" + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision:" + departmentRepository.findByDivision("Health"));
        System.out.println("findByDivisionEndsWith:" + departmentRepository.findByDivisionEndsWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContaining:" + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));

        System.out.println("-------------EMPLOYEES---inject first-------------------------");

//        System.out.println(employeeRepository.retrieveEmployeeDetail());


    }


}
