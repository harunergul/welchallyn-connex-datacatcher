package com.erc.app;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.erc.app.welchallyn.entities.PatientVitalSignDTO;

import simplexml.SimpleXml;
import simplexml.model.Element;

public class XmlConverter {

	private String testString = "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
			"<soap:Body>\r\n" + 
			"<InsertPatientVitals xmlns=\"http://tempuri.org/\">\r\n" + 
			"<insertDateTime>20200128104538</insertDateTime>\r\n" + 
			"<uniquePatientId>test12254</uniquePatientId>\r\n" + 
			"<patientName></patientName>\r\n" + 
			"<patientLastName></patientLastName>\r\n" + 
			"<patientSecondLastName></patientSecondLastName>\r\n" + 
			"<patientRoom></patientRoom>\r\n" + 
			"<patientBed></patientBed>\r\n" + 
			"<deviceLocationID>598</deviceLocationID>\r\n" + 
			"<clinicianID></clinicianID>\r\n" + 
			"<clinicianID2></clinicianID2>\r\n" + 
			"<clinicianFirstName></clinicianFirstName>\r\n" + 
			"<clinicianLastName></clinicianLastName>\r\n" + 
			"<temperature></temperature>\r\n" + 
			"<temperatureMode></temperatureMode>\r\n" + 
			"<heartRate></heartRate>\r\n" + 
			"<so2>0</so2>\r\n" + 
			"<diastolic></diastolic>\r\n" + 
			"<systolic></systolic>\r\n" + 
			"<respiratoryRate>54</respiratoryRate>\r\n" + 
			"<patientHeight></patientHeight>\r\n" + 
			"<patientWeight></patientWeight>\r\n" + 
			"<patientBMI></patientBMI>\r\n" + 
			"<patientPain>5</patientPain>\r\n" + 
			"<o2FlowRate>0</o2FlowRate>\r\n" + 
			"<o2Concentration>0</o2Concentration>\r\n" + 
			"<o2Method>0</o2Method>\r\n" + 
			"<o2Location>0</o2Location>\r\n" + 
			"<nibppatientposition></nibppatientposition>\r\n" + 
			"<nibpcuffsize></nibpcuffsize>\r\n" + 
			"<nibpcuffsite></nibpcuffsite>\r\n" + 
			"<deviceID>100047961819</deviceID>\r\n" + 
			"<deviceModel>75ME</deviceModel>\r\n" + 
			"<customData><Parameter Name=\"BOY\" Type=\"Decimal\" HISId=\"\" Unit=\"CM\" UnitHISId=\"\"><Value>52.00</Value></Parameter><Parameter Name=\"AGIRLIK\" Type=\"Decimal\" HISId=\"\" Unit=\"KG\" UnitHISId=\"\"><Value>54.00</Value></Parameter><Parameter Name=\"AVPU\" Type=\"List\" HISId=\"\" ItemHISId=\"\"><Value>Pain</Value><Score Name=\"AVPUScore4\" ParamName=\"AVPU\" Type=\"Integer\" Formula=\"RANK\" Unit=\"\" HISId=\"\" UnitHISId=\"\" ShowColor=\"true\" ShowValue=\"true\" Rank=\"Medium\" RankHISId=\"\" Color=\"Orange\" ColorHISId=\"\" CalcName=\"BURSAS\"><Value>2</Value></Score></Parameter><Score Name=\"Respiration RateScore3\" ParamName=\"Respiration Rate\" Type=\"Integer\" Formula=\"RANK\" Unit=\"\" HISId=\"\" UnitHISId=\"\" ShowColor=\"true\" ShowValue=\"true\" Rank=\"High\" RankHISId=\"\" Color=\"Red\" ColorHISId=\"\" CalcName=\"BURSAS\"><Value>3</Value></Score></customData>\r\n" + 
			"</InsertPatientVitals>\r\n" + 
			"</soap:Body>\r\n" + 
			"</soap:Envelope>";

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public static void main(String... args) {
		XmlConverter converter = new XmlConverter();
		
		try {
			SimpleXml simpleXML = new SimpleXml();
			Element element = simpleXML.fromXml(converter.getTestString());
			System.out.println(simpleXML.domToXml(element.children.get(0).children.get(0)));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		JAXBContext jaxbContext;
//		try {
//			jaxbContext = JAXBContext.newInstance(PatientVitalSignDTO.class);
//			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//			PatientVitalSignDTO employee = (PatientVitalSignDTO) jaxbUnmarshaller
//					.unmarshal(new StringReader(converter.getTestString()));
//			System.out.println(employee.getDeviceID());
//			System.out.println(employee.getCustomData().getParameter());
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}
	}

	public static PatientVitalSignDTO convertToVitalSign(String xmlString) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(PatientVitalSignDTO.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			PatientVitalSignDTO vitalSignDTO = (PatientVitalSignDTO) jaxbUnmarshaller
					.unmarshal(new StringReader(xmlString));
			return vitalSignDTO;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

}
