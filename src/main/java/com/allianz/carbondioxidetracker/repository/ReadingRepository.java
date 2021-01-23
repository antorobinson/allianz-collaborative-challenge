package com.allianz.carbondioxidetracker.repository;

import com.allianz.carbondioxidetracker.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository extends JpaRepository<Reading, Long> {

}
