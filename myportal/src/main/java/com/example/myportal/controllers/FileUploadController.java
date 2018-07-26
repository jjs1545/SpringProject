package com.example.myportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.myportal.service.FileUploadService;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/form")
	public String form() {
		return "fileupload/form";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(@RequestParam("file1") MultipartFile file1, Model model) {
		if(file1 == null) {
			return "redirect:/fileupload/form";
		}
		
		// 파일 업로드 수행
		String saveFilename = fileUploadService.store(file1);
		String urlImage = "upload-images/" + saveFilename;
		model.addAttribute("urlImage", urlImage);
		
		return "fileupload/result";
	}
}
