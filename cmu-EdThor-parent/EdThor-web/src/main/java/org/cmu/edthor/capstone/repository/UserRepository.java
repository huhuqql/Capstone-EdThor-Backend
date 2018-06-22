package org.cmu.edthor.capstone.repository;

import org.bson.types.ObjectId;
import org.cmu.edthor.capstone.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
	
	public User findByUsername(String userName);
}
