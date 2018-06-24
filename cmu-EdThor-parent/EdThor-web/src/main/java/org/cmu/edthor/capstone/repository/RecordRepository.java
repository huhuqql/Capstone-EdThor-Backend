package org.cmu.edthor.capstone.repository;

import java.util.List;
import org.bson.types.ObjectId;
import org.cmu.edthor.capstone.model.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecordRepository extends MongoRepository<Record, ObjectId> {
	
	public List<Record> findByStudentId(int studentId);
}
