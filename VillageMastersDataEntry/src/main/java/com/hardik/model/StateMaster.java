package com.hardik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="site",name="state_master")
public class StateMaster {
	
	@Id
	@SequenceGenerator(name="state_master_id_seq",sequenceName="state_master_id_seq",schema = "site",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="state_master_id_seq")
	@Column(name="id",unique=true,nullable=false)
	private Long id;
	
	@Column(name="state_code")
	private Integer stateCode;
	
	@Column(name="state_version")
	private Integer stateVersion;

	@Column(name="state_name")
	private String stateName;
	
	@Column(name="state_name_in_local")
	private String stateNameInLocal;
	
	@Column(name="census2001Code")
	private Integer census2001Code;
	
	@Column(name="census2011Code")
	private Integer census2011Code;
	
	@Column(name="state_or_ut")
	private String stateOrUt;
	
	@Column(name="state_short_name")
	private String stateShortName;
	
	@Column(name="language_code")
	private Integer languageId;
	
	@Column(name="active")
	private boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public Integer getStateVersion() {
		return stateVersion;
	}

	public void setStateVersion(Integer stateVersion) {
		this.stateVersion = stateVersion;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateNameInLocal() {
		return stateNameInLocal;
	}

	public void setStateNameInLocal(String stateNameInLocal) {
		this.stateNameInLocal = stateNameInLocal;
	}

	public Integer getCensus2001Code() {
		return census2001Code;
	}

	public void setCensus2001Code(Integer census2001Code) {
		this.census2001Code = census2001Code;
	}

	public Integer getCensus2011Code() {
		return census2011Code;
	}

	public void setCensus2011Code(Integer census2011Code) {
		this.census2011Code = census2011Code;
	}

	public String getStateOrUt() {
		return stateOrUt;
	}

	public void setStateOrUt(String stateOrUt) {
		this.stateOrUt = stateOrUt;
	}

	public String getStateShortName() {
		return stateShortName;
	}

	public void setStateShortName(String stateShortName) {
		this.stateShortName = stateShortName;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "StateMaster [id=" + id + ", stateCode=" + stateCode + ", stateVersion=" + stateVersion + ", stateName="
				+ stateName + ", stateNameInLocal=" + stateNameInLocal + ", census2001Code=" + census2001Code
				+ ", census2011Code=" + census2011Code + ", stateOrUt=" + stateOrUt + ", stateShortName="
				+ stateShortName + ", languageId=" + languageId + ", active=" + active + "]";
	}

	
	
	
	
	
	
}
