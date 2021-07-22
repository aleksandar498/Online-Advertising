package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="ad")
public class Ad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="dateadded")
	private Date dateAdded;
	
	@Column(name="url")
	private String url;
	
	@Column(name="price")
	private String price;
	
	@Column(name="city")
	private String city;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="AdTypeID")
	private AdType adType;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

}
