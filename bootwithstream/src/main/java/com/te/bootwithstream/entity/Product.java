package com.te.bootwithstream.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	private Integer id;

	private String name;

	@With
	private Double price;

	@ManyToMany(mappedBy = "products")
	@ToString.Exclude
	private Set<Order> orders;

}
