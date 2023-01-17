package com.project.be.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@Entity(name = "user")
@NoArgsConstructor
public class UserEntity implements Serializable{

    @Id
    @Column(name = "uuid",unique = true)
    private String uuid;

    private String phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar")
    private String avatar;

    private String status;

    @JsonIgnore
    private String createdDate;
    @JsonIgnore
    private String updatedDate;


}
