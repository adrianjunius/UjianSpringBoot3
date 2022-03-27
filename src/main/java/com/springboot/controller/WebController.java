package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.model.PenumpangModel;
import com.springboot.model.TitleModel;
import com.springboot.repository.BookingRepository;
import com.springboot.repository.KeberangkatanRepository;
import com.springboot.repository.PenumpangRepository;

@Controller
public class WebController {

	@Autowired
	PenumpangRepository penumpangRepo;
	
	@Autowired
	KeberangkatanRepository keberangkatanRepo; 

	@Autowired
	BookingRepository bookingRepo;

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
	
	@GetMapping("/bookingdetail")
	private String detailbooking(Model model, @RequestParam(value="id", defaultValue = "")Long id_keberangkatan,
		@RequestParam(value="nik", defaultValue = "")String nik) {
		model.addAttribute("ListBooking", bookingRepo.getAllDataIdNik(id_keberangkatan, nik));
		return "bookingdetail";
	}
	
	@GetMapping("/kenihilankeberangkatan")
	private String kenihilankeberangkatan(Model model) {
		return "kenihilankeberangkatan";
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
	private String inputPenumpang(Model model) {
		model.addAttribute("titleModel", title);
		model.addAttribute("penumpangModel", new PenumpangModel());
		return "formpenumpangbaru";
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
<<<<<<< HEAD
//	@GetMapping("/penumpang/formpenumpang/detailpenumpang")
//    public PenumpangModel tampilFormDetail(@RequestParam(required = false, value = "id") PenumpangModel penumpang) {
//        if (penumpang == null) {
//        	
//            PenumpangModel penumpangModel = new PenumpangModel();
//        }
//        return new PenumpangModel().addAttribute("penumpangModel", penumpang);
//    }

	@GetMapping("/cariKeberangkatan")
	private String  cariKeberangkatan(Model model, @RequestParam(value="terminal", defaultValue = "")String terminal,
			@RequestParam(value="tanggal", defaultValue = "")String tanggal) {
		if (terminal.isEmpty()&& tanggal.isEmpty()) {
			model.addAttribute("kenihilankeberangkatan");
			return "kenihilankeberangkatan";
		}else {
			model.addAttribute("ListContent",keberangkatanRepo.getAllDataTerminalTanggal(terminal, tanggal));
		}
		return "cariKeberangkatan";
	}
	@PostMapping("/formcancel/cancelmessage")
	private String deleteByBookingId(@RequestParam(name="id")long id) {
		bookingRepo.deleteById(id);
		return "cancelmessage";
	}
	@GetMapping("/booking/cancel")
	private String cancel(Model model) {
		return "formcancel";
	}
	

=======
	
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
>>>>>>> 97bb5caac0ef407e3f3b567e5b8cd367024bfe8e
	
	//@GetMapping("/cariKeberangkatan")
//	private List<BookingCustomeGetNameModel> getAllDataTerminalAwalTanggal(
//			@RequestParam(name = "terminal") String terminal, @RequestParam(name = "tanggal") String tanggal) {
//		return keberangkatanRepo.getAllDataTerminalTanggal(terminal, tanggal);
}
