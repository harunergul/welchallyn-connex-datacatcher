package com.erc.app.welchallyn.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Harun ERGUL
 * @date 2020-01-28
 * @note
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parameter", propOrder = { "name", "type", "hisid", "unit", "value", "score" })
public class Parameter {

	@XmlAttribute(name = "Name")
	protected String name;
	@XmlAttribute(name = "Type")
	protected String type;
	@XmlAttribute(name = "HISId")
	protected String hisid;
	@XmlAttribute(name = "Unit")
	protected String unit;

	@XmlElement(name = "Value")
	protected String value;

	@XmlElement(name = "Score")
	protected Score score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHisid() {
		return hisid;
	}

	public void setHisid(String hisid) {
		this.hisid = hisid;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

