package com.erc.app.welchallyn.entities;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Harun ERGUL
 * @date 2020-01-28
 * @note
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "InsertPatientVitals", namespace = "http://tempuri.org/")
@XmlType(name = "InsertPatientVitals", propOrder = { "insertDateTime", "uniquePatientId", "patientName",
		"patientLastName", "patientSecondLastName", "patientRoom", "patientBed", "deviceLocationId", "clinicianID",
		"clinicianID2", "clinicianFirstName", "clinicianLastName", "temperature", "temperatureMode", "heartRate", "so2",
		"diastolic", "systolic", "respiratoryRate", "patientHeight", "patientWeight", "patientBMI", "patientPain",
		"o2FlowRate", "o2Concentration", "o2Method", "o2Location", "nibppatientposition", "nibpcuffsize",
		"nibpcuffsite", "deviceID", "deviceModel", "customData" })

public class PatientVitalSignDTO implements Serializable {
	private static final long serialVersionUID = -3122933111998175122L;
	private String insertDateTime = "";
	private String uniquePatientId = "";
	private String patientName = "";
	private String patientLastName = "";
	private String patientSecondLastName = "";
	private String patientRoom = "";
	private String patientBed = "";
	private String deviceLocationId = "";
	private String clinicianID = "";
	private String clinicianID2 = "";
	private String clinicianFirstName = "";
	private String clinicianLastName = "";
	private String temperature = "";
	private String temperatureMode = "";
	private String heartRate = "";
	private String so2 = "";
	private String diastolic = "";
	private String systolic = "";
	private String respiratoryRate = "";
	private String patientHeight = "";
	private String patientWeight = "";
	private String patientBMI = "";
	private String patientPain = "";
	private String o2FlowRate = "";
	private String o2Concentration = "";
	private String o2Method = "";
	private String o2Location = "";
	private String nibppatientposition = "";
	private String nibpcuffsize = "";
	private String nibpcuffsite = "";
	private String deviceID = "";
	private String deviceModel = "";

	@Transient
	private CustomData customData;

	public void setUniquePatientId(String uniquePatientId) {
		this.uniquePatientId = uniquePatientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getPatientSecondLastName() {
		return patientSecondLastName;
	}

	public void setPatientSecondLastName(String patientSecondLastName) {
		this.patientSecondLastName = patientSecondLastName;
	}

	public String getPatientRoom() {
		return patientRoom;
	}

	public void setPatientRoom(String patientRoom) {
		this.patientRoom = patientRoom;
	}

	public String getPatientBed() {
		return patientBed;
	}

	public void setPatientBed(String patientBed) {
		this.patientBed = patientBed;
	}

	public String getDeviceLocationId() {
		return deviceLocationId;
	}

	public void setDeviceLocationId(String deviceLocationId) {
		this.deviceLocationId = deviceLocationId;
	}

	public String getClinicianID() {
		return clinicianID;
	}

	public void setClinicianID(String clinicianID) {
		this.clinicianID = clinicianID;
	}

	public String getClinicianID2() {
		return clinicianID2;
	}

	public void setClinicianID2(String clinicianID2) {
		this.clinicianID2 = clinicianID2;
	}

	public String getClinicianFirstName() {
		return clinicianFirstName;
	}

	public void setClinicianFirstName(String clinicianFirstName) {
		this.clinicianFirstName = clinicianFirstName;
	}

	public String getClinicianLastName() {
		return clinicianLastName;
	}

	public void setClinicianLastName(String clinicianLastName) {
		this.clinicianLastName = clinicianLastName;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getTemperatureMode() {
		return temperatureMode;
	}

	public void setTemperatureMode(String temperatureMode) {
		this.temperatureMode = temperatureMode;
	}

	public String getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public String getSo2() {
		return so2;
	}

	public void setSo2(String so2) {
		this.so2 = so2;
	}

	public String getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(String diastolic) {
		this.diastolic = diastolic;
	}

	public String getSystolic() {
		return systolic;
	}

	public void setSystolic(String systolic) {
		this.systolic = systolic;
	}

	public String getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public String getPatientHeight() {
		return patientHeight;
	}

	public void setPatientHeight(String patientHeight) {
		this.patientHeight = patientHeight;
	}

	public String getPatientWeight() {
		return patientWeight;
	}

	public void setPatientWeight(String patientWeight) {
		this.patientWeight = patientWeight;
	}

	public String getPatientBMI() {
		return patientBMI;
	}

	public void setPatientBMI(String patientBMI) {
		this.patientBMI = patientBMI;
	}

	public String getPatientPain() {
		return patientPain;
	}

	public void setPatientPain(String patientPain) {
		this.patientPain = patientPain;
	}

	public String getO2FlowRate() {
		return o2FlowRate;
	}

	public void setO2FlowRate(String o2FlowRate) {
		this.o2FlowRate = o2FlowRate;
	}

	public String getO2Concentration() {
		return o2Concentration;
	}

	public void setO2Concentration(String o2Concentration) {
		this.o2Concentration = o2Concentration;
	}

	public String getO2Method() {
		return o2Method;
	}

	public void setO2Method(String o2Method) {
		this.o2Method = o2Method;
	}

	public String getO2Location() {
		return o2Location;
	}

	public void setO2Location(String o2Location) {
		this.o2Location = o2Location;
	}

	public String getNibppatientposition() {
		return nibppatientposition;
	}

	public void setNibppatientposition(String nibppatientposition) {
		this.nibppatientposition = nibppatientposition;
	}

	public String getNibpcuffsize() {
		return nibpcuffsize;
	}

	public void setNibpcuffsize(String nibpcuffsize) {
		this.nibpcuffsize = nibpcuffsize;
	}

	public String getNibpcuffsite() {
		return nibpcuffsite;
	}

	public void setNibpcuffsite(String nibpcuffsite) {
		this.nibpcuffsite = nibpcuffsite;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getInsertDateTime() {
		return insertDateTime;
	}

	public void setInsertDateTime(String insertDateTime) {
		this.insertDateTime = insertDateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUniquePatientId() {
		return uniquePatientId;
	}

	public CustomData getCustomData() {
		return customData;
	}

	public void setCustomData(CustomData customData) {
		this.customData = customData;
	}

}
