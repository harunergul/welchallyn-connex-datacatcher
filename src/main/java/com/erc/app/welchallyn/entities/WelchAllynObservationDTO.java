package com.erc.app.welchallyn.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author Harun ERGUL
 * @date 2020-01-28
 * @note
 */
@Entity
@SequenceGenerator(name = "seqGen", sequenceName = "BAYEK.seqbar", initialValue = 5, allocationSize = 1)
@Table(name = "WELCHALLYNOBSERVATION")
public class WelchAllynObservationDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
	@Column(name = "WELCHALLYNOBSERVATIONID")
	private Long welchallynObservationId;

	@Column(name = "INSERTDATETIME")
	private Date insertDateTime;

	@Column(name = "UNIQUEPATIENTID")
	private String uniquePatientId;

	@Column(name = "PATIENTNAME")
	private String patientName;

	@Column(name = "PATIENTLASTNAME")
	private String patientLastName;

	@Column(name = "PATIENTSECONDLASTNAME")
	private String patientSecondLastName;

	@Column(name = "PATIENTROOM")
	private String patientRoom;

	@Column(name = "PATIENTBED")
	private String patientBed;

	@Column(name = "DEVICELOCATIONID")
	private String deviceLocationId;

	@Column(name = "CLINICIANID")
	private Long clinicianID;

	@Column(name = "CLINICIANID2")
	private Long clinicianID2;

	@Column(name = "CLINICIANFIRSTNAME")
	private String clinicianFirstName;

	@Column(name = "CLINICIANLASTNAME")
	private String clinicianLastName;

	@Column(name = "TEMPERATURE")
	private String temperature;

	@Column(name = "TEMPERATUREMODE")
	private String temperatureMode;

	@Column(name = "HEARTRATE")
	private String heartRate;

	@Column(name = "SO2")
	private String so2;

	@Column(name = "DIASTOLIC")
	private String diastolic;

	@Column(name = "SYSTOLIC")
	private String systolic;

	@Column(name = "RESPIRATORYRATE")
	private String respiratoryRate;

	@Column(name = "PATIENTHEIGHT")
	private String patientHeight;

	@Column(name = "PATIENTWEIGHT")
	private String patientWeight;

	@Column(name = "PATIENTBMI")
	private String patientBMI;

	@Column(name = "PATIENTPAIN")
	private String patientPain;

	@Column(name = "O2FLOWRATE")
	private String o2FlowRate;

	@Column(name = "O2CONCENTRATION")
	private String o2Concentration;

	@Column(name = "O2METHOD")
	private String o2Method;

	@Column(name = "O2LOCATION")
	private String o2Location;

	@Column(name = "NIBPPATIENTPOSITION")
	private String nibppatientposition;

	@Column(name = "NIBPCUFFSIZE")
	private String nibpcuffsize;

	@Column(name = "NIBPCUFFSITE")
	private String nibpcuffsite;

	@Column(name = "DEVICEID")
	private String deviceID;

	@Column(name = "DEVICEMODEL")
	private String deviceModel;

	@Column(name = "STATUS")
	private String status;

	@Transient
	private CustomData customData;

	public Date getInsertDateTime() {
		return insertDateTime;
	}

	public void setInsertDateTime(Date insertDateTime) {
		this.insertDateTime = insertDateTime;
	}

	public String getUniquePatientId() {
		return uniquePatientId;
	}

	public void setUniquePatientId(String uniquePatientId) {
		this.uniquePatientId = uniquePatientId;
	}

	public Long getWelchallynObservationId() {
		return welchallynObservationId;
	}

	public void setWelchallynObservationId(Long welchallynObservationId) {
		this.welchallynObservationId = welchallynObservationId;
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

	public CustomData getCustomData() {
		return customData;
	}

	public void setCustomData(CustomData customData) {
		this.customData = customData;
	}

	public Long getClinicianID() {
		return clinicianID;
	}

	public void setClinicianID(Long clinicianID) {
		this.clinicianID = clinicianID;
	}

	public Long getClinicianID2() {
		return clinicianID2;
	}

	public void setClinicianID2(Long clinicianID2) {
		this.clinicianID2 = clinicianID2;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
