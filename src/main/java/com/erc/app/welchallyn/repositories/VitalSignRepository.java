package com.erc.app.welchallyn.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erc.app.welchallyn.entities.WelchAllynObservationDTO;

/**
 * 
 * @author Harun ERGUL
 * @date 2020-01-28
 * @note
 */
@Repository
public interface VitalSignRepository extends CrudRepository<WelchAllynObservationDTO, Long>{

}
