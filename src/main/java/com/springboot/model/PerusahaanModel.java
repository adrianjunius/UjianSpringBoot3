package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="perusahaan")
public class PerusahaanModel {
	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
//	private long id;
//	@Column(name="nama", unique = true, nullable = false)
	@Column(length = 30)
	private String namaPerusahaan;
	private String alamat;
}
