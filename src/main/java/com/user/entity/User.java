package com.user.entity;

import com.general.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@Entity
@Table(name = "USER")
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name = "User" , sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "User")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Column(name = "PASSWORD", nullable = false)
    @Min(value = 3, message = "Password must be at least 3 characters long")
    private String password;

}
