package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.model.BookingCustomerGetNameModel;
import com.springboot.model.KeberangkatanModel;

public interface KeberangkatanRepository extends JpaRepository<KeberangkatanModel, Long>{

	@Query(value="SELECT `keberangkatan`.`id_keberangkatan` as id,`jurusan`.`deskripsi` ,`keberangkatan`.`tanggal`,`perusahaan`.`nama_perusahaan`,`keberangkatan`.`kelas`,`keberangkatan`.`harga` FROM `keberangkatan`\r\n"
			+ "INNER JOIN `bus` on `keberangkatan`.`no_polisi`= `bus`.`nomor_polisi`\r\n"
			+ "INNER JOIN `perusahaan` ON `bus`.`nama_perusahaan` = `perusahaan`.`nama_perusahaan`\r\n"
			+ "INNER JOIN `jurusan` ON `keberangkatan`.`jurusan_id` = `jurusan`.`jurusan_id`\r\n"
			+ "WHERE `jurusan`.`terminal_awal` = ?1 "
			+ "AND `tanggal` LIKE ?2% ", nativeQuery = true)
	List<BookingCustomerGetNameModel> getAllDataTerminalTanggal(String terminal, String tanggal);	
}
