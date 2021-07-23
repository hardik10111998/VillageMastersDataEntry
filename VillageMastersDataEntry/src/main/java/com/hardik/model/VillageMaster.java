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
@Table(schema="site",name="village_master")
public class VillageMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="village_master_id_seq",sequenceName="village_master_id_seq",schema = "site",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="village_master_id_seq")
	@Column(name="id",unique=true,nullable=false)
	private Long id;
	
	@Column(name="village_name")
	private String villageName;
	
	@Column(name="village_code")
	private Integer  villageCode;
	
	@Column(name="village_code_lg")
	private Integer  villageCodeLg;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="state_code_id", referencedColumnName = "id")
	private StateMaster stateMaster;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="district_code_id",referencedColumnName = "id")
	private DistrictMaster districtMaster;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sub_district_code_id",referencedColumnName = "id")
	private SubDistrictMaster subDistrictMaster;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="block_code_id",referencedColumnName = "id")
	private BlockMaster blockMaster;
	
	@Column(name="panchayat_name")
	private String panchayatName;
	
	@Column(name="panchayat_code")
	private Integer  panchayatCode;
	
	@Column(name="active")
	private boolean active;

	public VillageMaster() {
	}


	public VillageMaster(Long id, String villageName, Integer villageCode, Integer villageCodeLg,
			StateMaster stateMaster, DistrictMaster districtMaster, SubDistrictMaster subDistrictMaster,
			BlockMaster blockMaster, String panchayatName, Integer panchayatCode, boolean active) {
		super();
		this.id = id;
		this.villageName = villageName;
		this.villageCode = villageCode;
		this.villageCodeLg = villageCodeLg;
		this.stateMaster = stateMaster;
		this.districtMaster = districtMaster;
		this.subDistrictMaster = subDistrictMaster;
		this.blockMaster = blockMaster;
		this.panchayatName = panchayatName;
		this.panchayatCode = panchayatCode;
		this.active = active;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public Integer getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(Integer villageCode) {
		this.villageCode = villageCode;
	}

	public Integer getVillageCodeLg() {
		return villageCodeLg;
	}

	public void setVillageCodeLg(Integer villageCodeLg) {
		this.villageCodeLg = villageCodeLg;
	}

	public StateMaster getStateMaster() {
		return stateMaster;
	}

	public void setStateMaster(StateMaster stateMaster) {
		this.stateMaster = stateMaster;
	}

	public DistrictMaster getDistrictMaster() {
		return districtMaster;
	}

	public void setDistrictMaster(DistrictMaster districtMaster) {
		this.districtMaster = districtMaster;
	}

	public SubDistrictMaster getSubDistrictMaster() {
		return subDistrictMaster;
	}

	public void setSubDistrictMaster(SubDistrictMaster subDistrictMaster) {
		this.subDistrictMaster = subDistrictMaster;
	}

	public BlockMaster getBlockMaster() {
		return blockMaster;
	}

	public void setBlockMaster(BlockMaster blockMaster) {
		this.blockMaster = blockMaster;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public String getPanchayatName() {
		return panchayatName;
	}


	public void setPanchayatName(String panchayatName) {
		this.panchayatName = panchayatName;
	}


	public Integer getPanchayatCode() {
		return panchayatCode;
	}


	public void setPanchayatCode(Integer panchayatCode) {
		this.panchayatCode = panchayatCode;
	}


	@Override
	public String toString() {
		return "VillageMaster [id=" + id + ", villageName=" + villageName + ", villageCode=" + villageCode
				+ ", villageCodeLg=" + villageCodeLg + ", stateMaster=" + stateMaster + ", districtMaster="
				+ districtMaster + ", subDistrictMaster=" + subDistrictMaster + ", blockMaster=" + blockMaster
				+ ", panchayatName=" + panchayatName + ", panchayatCode=" + panchayatCode + ", active=" + active + "]";
	}

	

	

	
	
}
