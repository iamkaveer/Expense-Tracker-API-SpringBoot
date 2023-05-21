package com.expense.expanseTrackerApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String productName;

    private String description;

    private Double price;

    private Date date;

    @ManyToOne
    @JoinColumn(nullable = false , name = "fk_user_ID")
    private User user;

}
