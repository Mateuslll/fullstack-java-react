package com.dev.mateuslll.cardapio.controller;

import com.dev.mateuslll.cardapio.entity.Food;
import com.dev.mateuslll.cardapio.entity.FoodRequestDTO;
import com.dev.mateuslll.cardapio.entity.FoodResponseDTO;
import com.dev.mateuslll.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;
   @CrossOrigin(origins = "*" , allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<Food> foodList = foodRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
        List<FoodResponseDTO> foodResponseDTOList = foodList.stream()
                .map(FoodResponseDTO::new)
                .collect(Collectors.toList());
        return foodResponseDTOList;
    }
    @CrossOrigin(origins = "*" , allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        foodRepository.save(foodData);
        return;
    }
}
