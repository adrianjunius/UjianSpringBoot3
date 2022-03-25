package com.springboot.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="booking")
public class BookingModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="id_keberangkatan" , referencedColumnName = "id",unique = true)
	private KeberangkatanModel id_keberangkatan;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "nik", referencedColumnName = "nik", unique = true)
	private PenumpangModel nik;
	
	private String tanggal;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "jurusanId", referencedColumnName = "jurusanId", unique = true)
	private JurusanModel jurusanId;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "noPolisi", referencedColumnName = "noPolisi", unique = true)
	private BusModel noPolisi;
	
}
