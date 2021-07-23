package com.hardik.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hardik.model.VillageMaster;

@Repository
public interface VillageMasterRepository extends JpaRepository<VillageMaster, Long>{

	public List<VillageMaster> findByDistrictMasterIdAndActive(Long id, boolean active);

	public List<VillageMaster> findBySubDistrictMasterIdAndActive(Integer subDistrictId, boolean active);
	
	@Query(value="select f.id,f.village_name from site.village_master f where f.block_code_id = :blockId AND f.active = true",nativeQuery = true)
	public List<Object[]> findDataById(Integer blockId);
	
	
}
