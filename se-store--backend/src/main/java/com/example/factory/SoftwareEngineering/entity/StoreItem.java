package com.example.factory.SoftwareEngineering.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "storeItem")

public class StoreItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @Column(name = "item_title")
    private String itemTitle;

    @Column(name = "item_cat")
    private String itemCat;

   @Column(name = "item_specs")
    private String itemSpecs;
    
    @Column(name="item_price")
    private double itemPrice;

    @Column(name= "item_qty")
    private double itemQty;
}
