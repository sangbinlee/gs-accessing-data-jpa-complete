package com.example.accessingdatajpa;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

	@Id
//	@GeneratedValue
//	(strategy=GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "menu_id")
	private Long id;
	private String name;

    @ManyToOne
//    (fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
    private Category category;

}
