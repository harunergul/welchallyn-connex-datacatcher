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
@XmlType(name = "Score", propOrder = { "name", "type", "hisid", "unit", "value", "paramName", "formula",
		"unitHisid", "showColor", "showValue", "rank", "rankHisid", "color", "colorHisid", "calcName" })
public class Score {

	@XmlAttribute(name = "Name")
	protected String name;
	@XmlAttribute(name = "Type")
	protected String type;
	@XmlAttribute(name = "HISId")
	protected String hisid;
	@XmlAttribute(name = "Unit")
	protected String unit;
	@XmlAttribute(name = "ParamName")
	protected String paramName;
	@XmlAttribute(name = "Formula")
	protected String formula;
	@XmlAttribute(name = "UnitHISId")
	protected String unitHisid;
	@XmlAttribute(name = "ShowColor")
	protected String showColor;
	@XmlAttribute(name = "ShowValue")
	protected String showValue;
	@XmlAttribute(name = "Rank")
	protected String rank;
	@XmlAttribute(name = "RankHISId")
	protected String rankHisid;
	@XmlAttribute(name = "Color")
	protected String color;
	@XmlAttribute(name = "ColorHISId")
	protected String colorHisid;
	@XmlAttribute(name = "CalcName")
	protected String calcName;

	@XmlElement(name = "Value")
	protected String value;

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

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getUnitHisid() {
		return unitHisid;
	}

	public void setUnitHisid(String unitHisid) {
		this.unitHisid = unitHisid;
	}

	public String getShowColor() {
		return showColor;
	}

	public void setShowColor(String showColor) {
		this.showColor = showColor;
	}

	public String getShowValue() {
		return showValue;
	}

	public void setShowValue(String showValue) {
		this.showValue = showValue;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getRankHisid() {
		return rankHisid;
	}

	public void setRankHisid(String rankHisid) {
		this.rankHisid = rankHisid;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColorHisid() {
		return colorHisid;
	}

	public void setColorHisid(String colorHisid) {
		this.colorHisid = colorHisid;
	}

	public String getCalcName() {
		return calcName;
	}

	public void setCalcName(String calcName) {
		this.calcName = calcName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}