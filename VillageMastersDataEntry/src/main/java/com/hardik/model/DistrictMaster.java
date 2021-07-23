package com.hardik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "site", name = "district_master")
public class DistrictMaster {

	@Id
	@SequenceGenerator(name = "district_master_id_seq", sequenceName = "district_master_id_seq", schema = "site", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "district_master_id_seq")
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "district_name")
	private String districtName;

	@Column(name = "district_code")
	private Long districtCode;

	@Column(name = "dist_short_name")
	private String distShortName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "state_code_id", nullable = false, referencedColumnName = "id")
	private StateMaster stateMaster;

	@Column(name = "Census2001Code")
	private Long census2001Code;

	@Column(name = "Census2011Code")
	private Long census2011Code;

	@Column(name = "District_Code_LG")
	private Long districtCodeLG;

	@Column(name = "ABA_Flag")
	private Integer ABAFlag;

	@Column(name = "NITI_Ayog_Aspirational")
	private Integer NITIAyogAspirational;

	@Column(name = "active")
	private boolean active;

	public DistrictMaster() {
	}

	public DistrictMaster(String districtName, Long districtCode, String distShortName, StateMaster stateMaster,
			Long census2001Code, Long census2011Code, Long districtCodeLG, Integer aBAFlag, Integer nITIAyogAspirational,
			boolean active) {
		super();
		this.districtName = districtName;
		this.districtCode = districtCode;
		this.distShortName = distShortName;
		this.stateMaster = stateMaster;
		this.census2001Code = census2001Code;
		this.census2011Code = census2011Code;
		this.districtCodeLG = districtCodeLG;
		this.ABAFlag = aBAFlag;
		this.NITIAyogAspirational = nITIAyogAspirational;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistShortName() {
		return distShortName;
	}

	public void setDistShortName(String distShortName) {
		this.distShortName = distShortName;
	}

	public StateMaster getStateMaster() {
		return stateMaster;
	}

	public void setStateMaster(StateMaster stateMaster) {
		this.stateMaster = stateMaster;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(Long districtCode) {
		this.districtCode = districtCode;
	}

	public Long getCensus2001Code() {
		return census2001Code;
	}

	public void setCensus2001Code(Long census2001Code) {
		this.census2001Code = census2001Code;
	}

	public Long getCensus2011Code() {
		return census2011Code;
	}

	public void setCensus2011Code(Long census2011Code) {
		this.census2011Code = census2011Code;
	}

	public Long getDistrictCodeLG() {
		return districtCodeLG;
	}

	public void setDistrictCodeLG(Long districtCodeLG) {
		this.districtCodeLG = districtCodeLG;
	}

	public Integer getABAFlag() {
		return ABAFlag;
	}

	public void setABAFlag(Integer aBAFlag) {
		ABAFlag = aBAFlag;
	}

	public Integer getNITIAyogAspirational() {
		return NITIAyogAspirational;
	}

	public void setNITIAyogAspirational(Integer nITIAyogAspirational) {
		NITIAyogAspirational = nITIAyogAspirational;
	}

	@Override
	public String toString() {
		return "DistrictMaster [id=" + id + ", districtName=" + districtName + ", districtCode=" + districtCode
				+ ", distShortName=" + distShortName + ", stateMaster=" + stateMaster + ", census2001Code="
				+ census2001Code + ", Census2011Code=" + census2011Code + ", districtCodeLG=" + districtCodeLG
				+ ", ABAFlag=" + ABAFlag + ", NITIAyogAspirational=" + NITIAyogAspirational + ", active=" + active
				+ "]";
	}

}
