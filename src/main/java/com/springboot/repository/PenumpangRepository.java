package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.PenumpangModel;

public interface PenumpangRepository extends JpaRepository<PenumpangModel, String>{
	
	List<PenumpangModel> getByNik(String nik);
	List<PenumpangModel> findByNik(String nik);

}
