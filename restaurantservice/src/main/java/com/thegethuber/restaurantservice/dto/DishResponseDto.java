package com.thegethuber.restaurantservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishResponseDto {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
    private Integer restaurantId;
}
