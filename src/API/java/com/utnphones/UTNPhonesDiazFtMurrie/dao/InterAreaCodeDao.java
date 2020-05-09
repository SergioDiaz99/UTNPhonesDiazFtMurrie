package com.utnphones.UTNPhonesDiazFtMurrie.dao;


import com.utnphones.UTNPhonesDiazFtMurrie.model.InterAreaCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterAreaCodeDao extends JpaRepository<InterAreaCode,Integer> {
    List<InterAreaCode> findByCode(String code);
}
