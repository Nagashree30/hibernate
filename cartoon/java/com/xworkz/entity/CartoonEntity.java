package com.xworkz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "cartoon")
public class CartoonEntity {
	public CartoonEntity() {

	}

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SHOW_NAME")
	private String showName;

	@Column(name = "CHANNEL")
	private ChannelName channel;

	@Column(name = "LANG")
	private String lang;

	public CartoonEntity(String name, String showName, ChannelName channel, String lang) {
		super();
		this.name = name;
		this.showName = showName;
		this.channel = channel;
		this.lang = lang;
	}

	public enum ChannelName {
		POGO, CN, DISNEY;
	}

}
