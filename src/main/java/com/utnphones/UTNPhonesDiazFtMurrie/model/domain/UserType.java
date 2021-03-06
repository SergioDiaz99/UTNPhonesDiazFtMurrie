package com.utnphones.UTNPhonesDiazFtMurrie.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.List;

@Entity
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="userTypes")
public class UserType
{
    //region Properties:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUserType")
    private Integer idUserType;

    @Column(name="description",unique = true,nullable = false,length = 100,insertable = false,updatable = false)
    private String description;

    @Transient
    private List<User> userList;
    //endregion
}
