package com.project.be.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_contact")
public class ContactEntity implements Serializable {

    @EmbeddedId
    ContactKey contactId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    UserEntity user;

    @ManyToOne
    @MapsId("friendId")
    @JoinColumn(name = "friend_id")
    UserEntity friend;

    String status;

    @JsonIgnore
    private String createdDate;
    @JsonIgnore
    private String updatedDate;

}
