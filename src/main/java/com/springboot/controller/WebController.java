package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.model.PenumpangModel;
import com.springboot.model.TitleModel;
import com.springboot.repository.PenumpangRepository;

@Controller
public class WebController {

	@Autowired
	PenumpangRepository penumpangRepo;

	TitleModel title = new TitleModel(" BEKEN", "Trans");

	@GetMapping("/")
	private String index(Model model) {
		model.addAttribute("titleModel", title);
		return "index";
	}

	@GetMapping("/about")
	private String about(Model model) {
		model.addAttribute("titleModel", title);
		return "about";
	}

	@GetMapping("/service")
	private String service(Model model) {
		model.addAttribute("titleModel", title);
		return "service";
	}

	@GetMapping("/project")
	private String project(Model model) {
		model.addAttribute("titleModel", title);
		return "project";
	}

	@GetMapping("/contact")
	private String contact(Model model) {
		model.addAttribute("titleModel", title);
		return "contact";
	}

	@GetMapping("/daftar")
	private String daftar(Model model) {
		model.addAttribute("titleModel", title);
		return "daftar";
	}

	@GetMapping("/penumpang")
	private String penumpang(Model model) {
		model.addAttribute("titleModel", title);
		model.addAttribute("listPenumpang", penumpangRepo.findAll());
		return "penumpang";
	}
	
	@GetMapping("/penumpang/formpenumpangbaru")
	private String penumpangDaftar(Model model) {
		model.addAttribute("penumpangModel", new PenumpangModel());
		return "formpenumpangbaru";
	}
	
//	@PostMapping("/penumpang/formpenumpangbaru/detailpenumpang")
//	private String savePenumpang(@ModelAttribute PenumpangModel data) {
//		penumpangRepo.save(data);
//		return "detailpenumpang";
//	}
	
//	@GetMapping("/penumpang/detailpenumpang")
//	private String detailpenumpang(Model model) {
//		model.addAttribute("titleModel", title);
//		model.addAttribute("listPenumpang", penumpangRepo.findAll());
//		return "detailpenumpang";
//	}
	
	@GetMapping("/register")
	private String formpenumpangbaru(Model model) {
		model.addAttribute("titleModel", title);
		model.addAttribute("PenumpangModel", new PenumpangModel());
		return "formpenumpangbaru";
	}
	
	@GetMapping("/formpenumpangbaru/detailpenumpang")
	private String detailPenumpang(Model model) {
		model.addAttribute("penumpangModel", new PenumpangModel());
		return "redirect:/detailpenumpang";
	}
	
	@PostMapping("/formpenumpangbaru/detailpenumpang")
	private String tambahPenumpang(@ModelAttribute PenumpangModel penumpang) {
		penumpangRepo.save(penumpang);
		return "redirect:/detailpenumpang";
	}
	
	@GetMapping("/formlogin")
	private String masuk(Model model) {
		model.addAttribute("PenumpangModel", new PenumpangModel());
		return "formlogin";
	}
	
	@GetMapping("/formlogin/detailpenumpang")
	private String loginNik2(@PathVariable(value="nik")String nik) {
		if(penumpangRepo.findByNik(nik).isEmpty()) {
			return "redirect:/kenihilan";
		}
		return "redirect:/detailpenumpang";
		
	}
	
//	@PostMapping("/formlogin")
//	private S
	
	@GetMapping("/detailpenumpang")
	private String detailLogin(@PathVariable(value="nik")String nik) {
		penumpangRepo.findByNik(nik);
		return "redirect:/detailpenumpang";
	}
	
	//@GetMapping("/cariKeberangkatan")
//	private List<BookingCustomeGetNameModel> getAllDataTerminalAwalTanggal(
//			@RequestParam(name = "terminal") String terminal, @RequestParam(name = "tanggal") String tanggal) {
//		return keberangkatanRepo.getAllDataTerminalTanggal(terminal, tanggal);
}
