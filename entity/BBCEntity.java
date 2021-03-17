package com.xworkz.bbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "bbc")
public class BBCEntity {

	@Id
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(generator="auto")
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SEASON_NO")
	private int seasonNo;

	@Column(name = "CONTESTANT_TYPE")
	private String contestantType;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "NO_OF_TASK")
	private int noOfTask;

	@Column(name = "DAYS_IN")
	private int daysIn;

}
