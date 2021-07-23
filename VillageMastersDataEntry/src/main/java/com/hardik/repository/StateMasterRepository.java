package com.hardik.repository;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hardik.model.StateMaster;

public interface StateMasterRepository extends JpaRepository<StateMaster, Long>{
	
	public List<StateMaster> findByActive(boolean active,Sort sort);

	public StateMaster findByActiveAndStateNameContainingIgnoreCase(boolean active, String cityName);

	public StateMaster findByStateCode(Integer stateCode);

}
