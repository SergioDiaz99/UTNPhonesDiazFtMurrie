package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "localAreaCodes")
public class LocalAreaCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLocalAreaCode")
    private Integer idCountryAreaCode;

    @NotNull
    @Column(unique = true, name = "code")
    private String code;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idInterAreaCode")
    InterAreaCode interAreaCode;

}