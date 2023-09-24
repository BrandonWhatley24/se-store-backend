package com.example.factory.SoftwareEngineering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.factory.SoftwareEngineering.entity.StoreItem;

public interface StoreItemRepository extends JpaRepository<StoreItem, Long> {
    
}
