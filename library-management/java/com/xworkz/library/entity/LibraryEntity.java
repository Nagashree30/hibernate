package com.xworkz.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "Library")


public class LibraryEntity {
	public LibraryEntity() {
	}
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ID")
	private int id;

	@Column(name = "LIBRARIAN")
	private String librarian;

	@Column(name = "TYPE_OF_LIBRARY")
	private String typeOfLibrary;

	@Column(name = "NO_OF_BOOKS")
	private int noOfBooks;

	@Column(name = "DIVISION_NAME")
	private String divisionName;

	public LibraryEntity(String librarian, String typeOfLibrary, int noOfBooks, String divisionName) {
		super();
		this.librarian = librarian;
		this.typeOfLibrary = typeOfLibrary;
		this.noOfBooks = noOfBooks;
		this.divisionName = divisionName;
	}

}
