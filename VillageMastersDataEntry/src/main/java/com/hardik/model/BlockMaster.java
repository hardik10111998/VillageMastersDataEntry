package com.hardik.model;

import java.io.Serializable;

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
@Table(schema = "site", name = "block_master")
public class BlockMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "block_master_id_seq", sequenceName = "block_master_id_seq", schema = "site", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "block_master_id_seq")
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "block_code")
	private Integer blockCode;

	@Column(name = "block_name")
	private String blockName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_code_id", referencedColumnName = "id")
	private DistrictMaster districtMaster;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sub_district_code_id", referencedColumnName = "id")
	private SubDistrictMaster subDistrictMaster;

	@Column(name = "active")
	private boolean active;

	@Column(name = "block_version")
	private Integer blockVersion;

	@Column(name = "dtShortName")
	private String dtShortName;

	public BlockMaster() {
	}

	public BlockMaster(Integer blockCode, String blockName, DistrictMaster districtMaster,
			SubDistrictMaster subDistrictMaster, boolean active, Integer blockVersion, String dtShortName) {
		super();
		this.blockCode = blockCode;
		this.blockName = blockName;
		this.districtMaster = districtMaster;
		this.subDistrictMaster = subDistrictMaster;
		this.active = active;
		this.blockVersion = blockVersion;
		this.dtShortName = dtShortName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBlockCode() {
		return blockCode;
	}

	public void setBlockCode(Integer blockCode) {
		this.blockCode = blockCode;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public DistrictMaster getDistrictMaster() {
		return districtMaster;
	}

	public void setDistrictMaster(DistrictMaster districtMaster) {
		this.districtMaster = districtMaster;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public SubDistrictMaster getSubDistrictMaster() {
		return subDistrictMaster;
	}

	public void setSubDistrictMaster(SubDistrictMaster subDistrictMaster) {
		this.subDistrictMaster = subDistrictMaster;
	}

	public Integer getBlockVersion() {
		return blockVersion;
	}

	public void setBlockVersion(Integer blockVersion) {
		this.blockVersion = blockVersion;
	}

	public String getDtShortName() {
		return dtShortName;
	}

	public void setDtShortName(String dtShortName) {
		this.dtShortName = dtShortName;
	}

	@Override
	public String toString() {
		return "BlockMaster [id=" + id + ", blockCode=" + blockCode + ", blockName=" + blockName + ", districtMaster="
				+ districtMaster + ", subDistrictMaster=" + subDistrictMaster + ", active=" + active + ", blockVersion="
				+ blockVersion + ", dtShortName=" + dtShortName + "]";
	}
	
}
