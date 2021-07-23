package com.hardik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.model.BlockMaster;

@Repository
public interface BlockMasterRepository extends JpaRepository<BlockMaster, Integer>{

	public BlockMaster findByBlockCode(Integer blockCode);
}
