package com.dev.mateuslll.cardapio.repository;

import com.dev.mateuslll.cardapio.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
