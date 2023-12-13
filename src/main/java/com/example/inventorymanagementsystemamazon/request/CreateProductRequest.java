package com.example.inventorymanagementsystemamazon.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    @NotBlank(message = "Product Name can't be Blank!")
    String name;

    @Positive(message = "Price Can't be Negative!")
    Integer price;
    String brand;
    String category;

    @PositiveOrZero(message = "Price Can't be Negative!")
    Integer quantity;

}
