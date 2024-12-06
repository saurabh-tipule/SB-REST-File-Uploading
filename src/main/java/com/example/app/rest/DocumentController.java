package com.example.app.rest;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.model.Document;
import com.example.app.service.DocumentService;

@RestController
@RequestMapping(value = "/doc-api/")
public class DocumentController {

	private DocumentService documentservice;

	public DocumentController(DocumentService documentservice) {
		super();
		this.documentservice = documentservice;
	}

	@PostMapping(value = "/documents")
	public ResponseEntity<String> uploadDocuments(
			@RequestPart MultipartFile file1, @RequestPart MultipartFile file2,
			@RequestPart MultipartFile file3, @RequestPart MultipartFile file4) {

		Document document = new Document();

		try {
			document.setAdharCard(file1.getBytes());
			document.setPanCard(file2.getBytes());
			document.setDrivingLicence(file3.getBytes());
			document.setVoterCard(file4.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		String msg = documentservice.saveDocument(document);

		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

}
