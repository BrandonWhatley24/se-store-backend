package com.example.factory.SoftwareEngineering.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String user;
    private String itemTitle;
    private String itemId;
    private String itemPrice;
    private String itemCat;
    private String itemSpecs;
    private String Date;
    private String result;
}
