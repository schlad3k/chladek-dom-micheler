package sectionpark.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import sectionpark.model.TimingstationData;

public interface SectionparkRepository extends MongoRepository<TimingstationData, String> {

    public TimingstationData findByTimingstationID(String timingstationID);
    public List<TimingstationData> findBySectionparkID(String sectionparkID);

 }
