package com.G1_Minde_agenci.Repository;

import com.G1_Minde_agenci.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepo extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);
}
