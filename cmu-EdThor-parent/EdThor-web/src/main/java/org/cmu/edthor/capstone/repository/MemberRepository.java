package org.cmu.edthor.capstone.repository;

import org.bson.types.ObjectId;
import org.cmu.edthor.capstone.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, ObjectId> {
	
	public Member findByName(String name);
}
