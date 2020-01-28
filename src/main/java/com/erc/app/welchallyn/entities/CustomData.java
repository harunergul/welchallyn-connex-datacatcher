package com.erc.app.welchallyn.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Harun ERGUL
 * @date 2020-01-28
 * @note
 */
@XmlRootElement(name = "customDatam" )
@XmlType(propOrder = {"parameter","score","calculation"})
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomData {

	@XmlElement(name = "Parameter")
	protected List<Parameter> parameter;

	@XmlElement(name = "Score")
	protected List<Score> score;

	@XmlElement(name = "Calculation")
	protected List<Calculation> calculation;

	public List<Parameter> getParameter() {
		return parameter;
	}

	public void setParameter(List<Parameter> parameter) {
		this.parameter = parameter;
	}

	public List<Score> getScore() {
		return score;
	}

	public void setScore(List<Score> score) {
		this.score = score;
	}

	public List<Calculation> getCalculation() {
		return calculation;
	}

	public void setCalculation(List<Calculation> calculation) {
		this.calculation = calculation;
	}

}

