package com.xworkz.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {
	public ProductEntity() {

	}

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "TYPE")
	private ProductType type;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "QUALITY")
	private boolean quality;

	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "BRAND")
	private String brand;

	public ProductEntity(String name, ProductType type, double price, int quantity, boolean quality,
			String manufacturer, String brand) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.quality = quality;
		this.manufacturer = manufacturer;
		this.brand = brand;
	}

	public enum ProductType {
		HOME_APPLIANCES, ELECTRONIC, COMPUTERS, FASHION
	}

}
