package com.example.app.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Document;
import com.example.app.repository.DocumentRepository;
import com.example.app.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	private DocumentRepository documentrepository;

	@Autowired
	public void setDocumentrepository(DocumentRepository documentrepository) {
		this.documentrepository = documentrepository;
	}

	@Override
	public String saveDocument(Document document) {

		String documentId = UUID.randomUUID().toString().toUpperCase();

		document.setDocumentId(documentId);
		
		documentrepository.save(document);
		return "Documents Uploaded SuccessFully..!" + documentId;
	}

}
