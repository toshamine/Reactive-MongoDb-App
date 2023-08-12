package dev.chiba.reactivemongoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductDto {

    private String id;
    private String name;
    private String category;
    private Double price;
}
