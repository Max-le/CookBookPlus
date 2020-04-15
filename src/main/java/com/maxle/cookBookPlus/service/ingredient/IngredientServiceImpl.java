package com.maxle.cookBookPlus.service.ingredient;

import com.maxle.cookBookPlus.mappers.IngredientMapper;
import com.maxle.cookBookPlus.models.DTO.user.IngredientInfoDTO;
import com.maxle.cookBookPlus.models.entities.Ingredient;
import com.maxle.cookBookPlus.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class IngredientServiceImpl implements IngredientService {


    private final IngredientRepository ingredientRepo;
    private final IngredientMapper  ingredientMapper;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingRepo, IngredientMapper ingMapper){
        ingredientRepo = ingRepo;
        ingredientMapper = ingMapper;
    }

    @Override
    public IngredientInfoDTO findInfoById(Long id) {
        return null;
    }

    @Override
    public List<IngredientInfoDTO> findAllInfo() {
        List<Ingredient> ings = ingredientRepo.findAll();
        return ings.stream().map(ing -> {
            return ingredientMapper.toInfoDTO(ing);
        }).collect(Collectors.toList());
    }
}
