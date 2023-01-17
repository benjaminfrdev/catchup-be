package com.project.be.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
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
    @MapsId(value = "userId")
    @JoinColumn(name = "user_id")
    UserEntity user;

    @ManyToOne
    @MapsId(value = "friendId")
    @JoinColumn(name = "friend_id")
    UserEntity friend;

    String status;

    @JsonIgnore
    private String createdDate;
    @JsonIgnore
    private String updatedDate;

}
