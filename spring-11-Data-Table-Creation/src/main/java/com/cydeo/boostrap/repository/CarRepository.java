package com.cydeo.boostrap.repository;

import com.cydeo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


}
