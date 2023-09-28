package com.example.factory.SoftwareEngineering.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")

public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "item_title")
    private String itemTitle;

    @Column(name = "item_cat")
    private String itemCat;

    @Column(name = "item_specs")
    private String itemSpecs;
    
    @Column(name = "purchase_date", nullable = false)
    private String purchaseDate;

    @Column(name = "item_result")
    private boolean itemResult;
    
    @Column(name = "item_price")
    private double itemPrice;

    @Column(name = "item_qty")
    private String qty;    

}