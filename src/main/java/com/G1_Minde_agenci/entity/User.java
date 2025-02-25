package com.G1_Minde_agenci.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@Component
@Document(collection = "users")
@Data

public class User {

    @Id
    private ObjectId id;
     @Indexed(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private  String email;

}
