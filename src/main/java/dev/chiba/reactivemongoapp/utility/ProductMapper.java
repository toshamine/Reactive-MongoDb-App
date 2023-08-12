package dev.chiba.reactivemongoapp.utility;

import com.fasterxml.jackson.databind.util.BeanUtil;
import dev.chiba.reactivemongoapp.dto.ProductDto;
import dev.chiba.reactivemongoapp.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

public class ProductMapper {

    public static Product mapToProduct(ProductDto productDto){
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        return product;
    }

    public static ProductDto mapToProductDto(Product product){
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        return productDto;
    }
}
