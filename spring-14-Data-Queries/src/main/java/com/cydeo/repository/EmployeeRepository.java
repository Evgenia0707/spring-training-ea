package com.cydeo.repository;

import com.cydeo.entity.Course;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//display all employees with email address "" //when email equal email
    List<Employee> findByEmail(String email);

//display all employees with firstname "" and last name""
//also show all employees with an email address // OR

    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname,String lastname,String email);

    //display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstname);

    //display all employees where last name start with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //display all employees with salary higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //display all employees with salary less than ""
    List<Employee> findBySalaryLessThan(Integer salary);

    //display all employees that has been hired between "" an ""
    List<Employee> findByHireDateBetween(LocalDate startDate,LocalDate endDate);

    //display all employees where salaries greater and equal to "" in order-salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //display top unique 3 employees that is making less than ""  DISTINCT
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //display all employees that do not have email address
    List<Employee> findByEmailIsNull();

//"****************************************************************"
    //if not drive query

    //JPQL - need to write class name - name does not matter

    @Query("SELECT employee FROM Employee employee WHERE employee.email='amcnee1@google.es'")
//empl obj created from Empl class  (email hardcoded -need be changeable)
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email='amcnee1@google.es'")
    Integer retrieveEmployeeSalary();//empl obj fill salary - on=bj define form empl

//not equal (salary)
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1 ") //<> not equal ; ?1 first parameter
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

//LIKE / CONTAINS / Startswith / Endswith
    @Query("SELECT e FROM Employee  e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

//Less than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);
//First name
    @Query("SELECT e.firstName FROM Employee e WHERE e.salary < ?1")
    List<String> retrieveEmployeeFirstNameSalaryLessThan(int salary);

//greater than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> retrieveEmployeeSalaryGreaterThan(int salary);

//between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

//before date
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

//Null (email)
    @Query("select e FROM Employee e WHERE e.email IS NULL")
    List<Employee> retrieveEmployeeIsNull();

//is not null
    @Query("select e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> retrieveEmployeeIsNotNull();

//sorting is asc order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

//sorting is Desc order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //"****************************************************************"
//Native = pure query  --- write against Table
// ->  add @Query + value = "SELECT * FROM employees WHERE salary = ?1", nativeQuery = true

//positional param

    @Query(value = "SELECT * FROM employees WHERE salary = ?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);


//"****************************************************************"

 //Named param
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);

    //named param
//    @Query("SELECT c FROM Course c WHERE c.category = : category AND c.rating > : rating")
//    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);
    //Param (must match with category) assign - to str category





}
