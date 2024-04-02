package com.example.accessingdatajpa;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue
//	(strategy=GenerationType.AUTO)
//    @Column(name = "category_id")
	private Long id;
	private String name;

//	https://vladmihalcea.com/recursive-associations-jpa-hibernate/

//    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "c_id")
//    private Category parent;

//	@OneToMany(mappedBy = "category")
//	private List<Menu> menus ;

//	  @OneToMany
//	  @JoinColumn(name = "category_id")
//	  private List<Menu> menus = new ArrayList<>();

//    @OneToMany(fetch = FetchType.LAZY)
//    private Category children;
}
