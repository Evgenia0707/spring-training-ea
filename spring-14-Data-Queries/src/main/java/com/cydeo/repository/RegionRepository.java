package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer> {
//find, get = SELECT
//findAllByCountry(someCountry) -> In SQL -> select * from region where country = someCountry

//display all regions in Canada( build inside repository - rec from DB)
    List<Region> findByCountry(String country);//List = regions
    List<Region> getByCountry(String country);

//display all regions with country name includes 'United'
    List<Region> findByCountryContaining(String country);

//display all regions with country name includes 'United' in order(region)
    List<Region> findByCountryContainsOrderByRegionDesc(String country);

//display top 2 regions in United States
    List<Region> findTopByCountry(String country);//show 1
    List<Region> findTop2ByCountry(String country);//show 2

    List<Region> findTopByCountryContainsOrderByRegion(String country);

    }
