package com.project.be.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ContactKey implements Serializable {
    @Column(name = "user_id")
    String userId;

    @Column(name = "friend_id")
    String friendId;

    //standard constructors,getters, and setters
    // hashcode and equals implementation

}
