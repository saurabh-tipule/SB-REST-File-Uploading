package com.example.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Document {

	@Id
	private String documentId;

	@Lob
	private byte[] adharCard;

	@Lob
	private byte[] panCard;

	@Lob
	private byte[] drivingLicence;

	@Lob
	private byte[] voterCard;

}
