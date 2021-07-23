package com.hardik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hardik.model.SubDistrictMaster;

@Repository
public interface SubDistrictMasterRepository extends JpaRepository<SubDistrictMaster, Integer> {

	public List<SubDistrictMaster> findByDistrictMasterIdAndActive(Integer id, boolean active);

	@Query("SELECT sd FROM SubDistrictMaster sd WHERE sd.SubDistrictCode = :SubDistrictCode")
	SubDistrictMaster getBySubDistrictCode(Integer SubDistrictCode);
}
