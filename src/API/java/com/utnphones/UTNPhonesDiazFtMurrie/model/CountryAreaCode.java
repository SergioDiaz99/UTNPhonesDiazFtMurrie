package com.utnphones.UTNPhonesDiazFtMurrie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "countryAreaCodes")
public class CountryAreaCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCountryAreaCode")
    private Integer idCountryAreaCode;

    @NotNull
    @Column(name = "code")
    private String code;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idInterAreaCode")
    InterAreaCode interAreaCode;

}


