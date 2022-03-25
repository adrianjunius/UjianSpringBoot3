package com.springboot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bus")
public class BusModel {
	@Id
	@Column(length = 10)
	private String noPolisi;
	private int kapasitas;
	private String nama_supir;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "namaPerusahaan", referencedColumnName = "namaPerusahaan", unique = true)
	private PerusahaanModel namaPerusahaan;
}
