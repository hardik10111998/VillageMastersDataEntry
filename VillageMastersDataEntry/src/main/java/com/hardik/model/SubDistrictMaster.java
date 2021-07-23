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
@Table(schema = "site", name = "subdistrict_master")
public class SubDistrictMaster {

	@Id
	@SequenceGenerator(name = "subdistrict_master_id_seq", sequenceName = "subdistrict_master_id_seq", schema = "site", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subdistrict_master_id_seq")
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "subdistrict_code")
	private Integer SubDistrictCode;

	@Column(name = "subdistrict_version")
	private Integer SubDistrictVersion;

	@Column(name = "subdistrict_name")
	private String subdistrictName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_code", nullable = false, referencedColumnName = "id")
	private DistrictMaster districtMaster;

	@Column(name = "census2001Code")
	private Integer census2001Code;

	@Column(name = "census2011Code")
	private Integer census2011Code;

	@Column(name = "subdist_short_name")
	private String subdistShortName;

	@Column(name = "sub_district_lg")
	private Integer subDistrictLg;

	@Column(name = "active")
	private boolean active;

	public SubDistrictMaster() {
	}
	
	public SubDistrictMaster(Integer subDistrictCode, Integer subDistrictVersion, String subdistrictName,
			DistrictMaster districtMaster, Integer census2001Code, Integer census2011Code, String subdistShortName,
			Integer subDistrictLg, boolean active) {
		super();
		SubDistrictCode = subDistrictCode;
		SubDistrictVersion = subDistrictVersion;
		this.subdistrictName = subdistrictName;
		this.districtMaster = districtMaster;
		this.census2001Code = census2001Code;
		this.census2011Code = census2011Code;
		this.subdistShortName = subdistShortName;
		this.subDistrictLg = subDistrictLg;
		this.active = active;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSubDistrictCode() {
		return SubDistrictCode;
	}

	public void setSubDistrictCode(Integer subDistrictCode) {
		SubDistrictCode = subDistrictCode;
	}

	public Integer getSubDistrictVersion() {
		return SubDistrictVersion;
	}

	public void setSubDistrictVersion(Integer subDistrictVersion) {
		SubDistrictVersion = subDistrictVersion;
	}

	public String getSubdistrictName() {
		return subdistrictName;
	}

	public void setSubdistrictName(String subdistrictName) {
		this.subdistrictName = subdistrictName;
	}

	public DistrictMaster getDistrictMaster() {
		return districtMaster;
	}

	public void setDistrictMaster(DistrictMaster districtMaster) {
		this.districtMaster = districtMaster;
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

	public String getSubdistShortName() {
		return subdistShortName;
	}

	public void setSubdistShortName(String subdistShortName) {
		this.subdistShortName = subdistShortName;
	}

	public Integer getSubDistrictLg() {
		return subDistrictLg;
	}

	public void setSubDistrictLg(Integer subDistrictLg) {
		this.subDistrictLg = subDistrictLg;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
}
