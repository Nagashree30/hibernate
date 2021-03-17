package com.xworkz.icecream.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="ice_cream")
@NamedQueries({
	@NamedQuery(name = "deleteByName", query = "delete IceCreamEntity ice where ice.name=:name"),
//	@NamedQuery(name = "updatePriceByName", query="update  IceCreamEntity ice set ice.price=:price where ice.name=:name"),
//	@NamedQuery(name = "getAll",query = "select ice from IceCreamEntity ice"),
//	@NamedQuery(name = "findByNameAndPrice",query = "select ice from  IceCreamEntity ice where ice.price=:price and ice.name=:name"),
//	@NamedQuery(name = "getByMaxPrice",query = "Select max(price) from IceCreamEntity"),
//	@NamedQuery(name = "getByMinPrice",query = "Select min(price) from IceCreamEntity"),
//	@NamedQuery(name = "getPriceByName",query = "SELECT ice.price FROM IceCreamEntity ice where ice.name=:name"),
//	@NamedQuery(name = "getBySumPrice",query = "Select sum(price) from IceCreamEntity"),
//	@NamedQuery(name = "getNameAndFlavourByPrice",query = "Select ice.name,ice.flavour  from IceCreamEntity ice where ice.price=:price"),
//	@NamedQuery(name = "findByNameAndPrice",query = "Select ice from IceCreamEntity ice where ice.name=:name and ice.price=:price")
})
public class IceCreamEntity {
	

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="COMPANY")
	private String company;
	
	@Column(name="PRICE")
	private double price;
	
	@Enumerated(EnumType.STRING)
	@Column(name="FLAVOUR")
	private Flavour flavour;
	
	@Enumerated(EnumType.STRING)
	@Column(name="COLOR")
	private Color color;
	

	public enum Flavour{
		VANILLA, BUTTERSCOTCH, CHACOLATE, BLACKCURRANT,PISTHA,MIXED , KULFI
	}
	
	public enum Color{
		BLUE, WHITE, YELLOW, MIX, GREEN,BLACK
	}

	public IceCreamEntity(int id,String name, String company, double price, Flavour flavour, Color color) {
		super();
		this.id=id;
		this.name = name;
		this.company = company;
		this.price = price;
		this.flavour = flavour;
		this.color = color;
	}
}
