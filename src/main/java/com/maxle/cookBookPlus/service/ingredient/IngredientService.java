package com.maxle.cookBookPlus.service.ingredient;


import com.maxle.cookBookPlus.models.DTO.user.IngredientInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IngredientService {
    IngredientInfoDTO findInfoById(Long id);
    List<IngredientInfoDTO> findAllInfo();

}
