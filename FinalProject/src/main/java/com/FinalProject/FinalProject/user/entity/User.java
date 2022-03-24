package com.FinalProject.FinalProject.user.entity;

import com.FinalProject.FinalProject.general.annotation.UniqueKey;
import com.FinalProject.FinalProject.general.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@UniqueKey(columnNames={"USER_NAME"})
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name = "Users" , sequenceName = "USR_USERS_ID_SEQ")
    @GeneratedValue(generator = "Users")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Column(name = "USER_NAME", length = 100, nullable = false)
    private String userName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

}
