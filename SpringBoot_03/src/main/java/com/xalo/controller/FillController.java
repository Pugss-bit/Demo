package com.xalo.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FillController {

	@GetMapping("filePage")
	public String fileJsp() {
		return "file";
	}

	// 文件下载
	@GetMapping("/download")
	public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName) throws IOException {
		String savePath = "/Users/yubei/yuhan/SpringBoot_03/src/main/resources/static/img/";
		String filePath = savePath + fileName;
		File file = new File(filePath);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		byte[] fileByte = FileUtils.readFileToByteArray(file);
		ResponseEntity<byte[]> re = new ResponseEntity<>(fileByte, headers, HttpStatus.CREATED);
		return re;
	}

	// 上传文件
	@PostMapping("/upload")
	@ResponseBody
	public String uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		String fileName = file.getOriginalFilename();
		System.out.println("fileName=" + fileName);
		long size = file.getSize();
		System.out.println("size=" + size);
		String str = file.getContentType();
		System.out.println("contentType=" + str);
		String savePath = "/Users/yubei/yuhan/SpringBoot_03/src/main/resources/static/img/";
		String filePath = savePath + fileName;
		file.transferTo(new File(filePath));
		return "成功";
	}
}
