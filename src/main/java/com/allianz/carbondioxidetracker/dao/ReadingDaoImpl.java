package com.allianz.carbondioxidetracker.dao;

import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ReadingDaoImpl implements ReadingDao {

    private ReadingRepository readingRepository ;


    @Override
    public Reading save(Reading entity) {

        return readingRepository.save(entity);
    }

    @Autowired
    void setReadingRepository(ReadingRepository repository) {
        this.readingRepository = repository;
    }
}
