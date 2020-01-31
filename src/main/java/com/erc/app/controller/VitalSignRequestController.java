package com.erc.app.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erc.app.welchallyn.entities.PatientVitalSignDTO;
import com.erc.app.welchallyn.entities.WelchAllynObservationDTO;
import com.erc.app.welchallyn.repositories.VitalSignRepository;

/**
 * 
 * @author HARUN ERGUL
 * @date 26 Oca 2020
 * @note
 */

@RestController
public class VitalSignRequestController {

	@Autowired
	private VitalSignRepository repository;

	public VitalSignRepository getRepository() {
		return repository;
	}

	public void setRepository(VitalSignRepository repository) {
		this.repository = repository;
	}

	@PostMapping(path = "/add-vital-sign", consumes = MediaType.APPLICATION_XML_VALUE)
	public boolean addVitalSign(@RequestBody PatientVitalSignDTO dto) {

		WelchAllynObservationDTO observationDTO = new WelchAllynObservationDTO();

		if (dto.getInsertDateTime() != null && dto.getInsertDateTime().length() != 0) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(Long.parseLong(dto.getInsertDateTime()));
			observationDTO.setInsertDateTime(calendar.getTime());
		}
		
		observationDTO.setUniquePatientId(dto.getUniquePatientId());
		observationDTO.setPatientName(dto.getPatientName());
		observationDTO.setPatientLastName(dto.getPatientLastName());
		observationDTO.setPatientSecondLastName(dto.getPatientSecondLastName());
		observationDTO.setPatientRoom(dto.getPatientRoom());
		observationDTO.setPatientBed(dto.getPatientBed());
		observationDTO.setDeviceLocationId(dto.getDeviceLocationId());
		if (dto.getClinicianID() != null && dto.getClinicianID().length() > 0) {
			observationDTO.setClinicianID(Long.parseLong(dto.getClinicianID()));
		}
		if (dto.getClinicianID2() != null && dto.getClinicianID2().length() > 0) {
			observationDTO.setClinicianID2(Long.parseLong(dto.getClinicianID2()));
		}

		observationDTO.setClinicianFirstName(dto.getClinicianFirstName());
		observationDTO.setClinicianLastName(dto.getClinicianLastName());
		observationDTO.setTemperature(dto.getTemperature());
		observationDTO.setTemperatureMode(dto.getTemperatureMode());
		observationDTO.setHeartRate(dto.getHeartRate());
		observationDTO.setSo2(dto.getSo2());
		observationDTO.setDiastolic(dto.getDiastolic());
		observationDTO.setSystolic(dto.getSystolic());
		observationDTO.setRespiratoryRate(dto.getRespiratoryRate());
		observationDTO.setPatientHeight(dto.getPatientHeight());
		observationDTO.setPatientWeight(dto.getPatientWeight());
		observationDTO.setPatientBMI(dto.getPatientBMI());
		observationDTO.setPatientPain(dto.getPatientPain());
		observationDTO.setO2FlowRate(dto.getO2FlowRate());
		observationDTO.setO2Concentration(dto.getO2Concentration());
		observationDTO.setO2Method(dto.getO2Method());
		observationDTO.setO2Location(dto.getO2Location());
		observationDTO.setNibppatientposition(dto.getNibppatientposition());
		observationDTO.setNibpcuffsize(dto.getNibpcuffsize());
		observationDTO.setNibpcuffsite(dto.getNibpcuffsite());
		observationDTO.setDeviceID(dto.getDeviceID());
		observationDTO.setDeviceModel(dto.getDeviceModel());
		observationDTO.setStatus("0");
		
		repository.save(observationDTO);
		return true;
	}

}
