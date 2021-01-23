package com.allianz.carbondioxidetracker.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.allianz.carbondioxidetracker.entity.Reading;



public interface ReadingRepository extends JpaRepository<Reading, Long> {

}
