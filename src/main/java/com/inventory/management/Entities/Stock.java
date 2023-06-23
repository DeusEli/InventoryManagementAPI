package com.inventory.management.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "stock_in_units", nullable = false)
	private int stockInUnits;

	@OneToOne(optional = false, orphanRemoval = true)
	@JoinColumn(name = "product_id", nullable = false, unique = true)
	private Product product;

}
