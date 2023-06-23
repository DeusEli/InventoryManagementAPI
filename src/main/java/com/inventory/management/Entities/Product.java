package com.inventory.management.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;

	@Column(name = "name", nullable = false, unique = true, length = 50)
	private String name;

	@Column(name = "description", nullable = false, length = 200)
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "retail_price", nullable = false)
	private double retailPrice;

	@Column(name = "wholesale_price", nullable = false)
	private double wholesalePrice;

	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true, optional = false)
	private Stock stock;

}
