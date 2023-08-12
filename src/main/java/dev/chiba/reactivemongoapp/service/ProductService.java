package dev.chiba.reactivemongoapp.service;


import dev.chiba.reactivemongoapp.dto.ProductDto;
import dev.chiba.reactivemongoapp.repo.ProductRepo;
import dev.chiba.reactivemongoapp.utility.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;


    public Flux<ProductDto> findAll(){
        return productRepo.findAll().map(ProductMapper::mapToProductDto);
    }

    public Mono<ProductDto> findById(String id){
        return productRepo.findById(id).map(ProductMapper::mapToProductDto);
    }

    public Flux<ProductDto> findByPrice(Double min,Double max){
        return productRepo.findByPriceBetween(Range.closed(min,max)).map(ProductMapper::mapToProductDto);
    }

    public Mono<ProductDto> save(Mono<ProductDto> productDto){
        return productDto.map(ProductMapper::mapToProduct)
                .flatMap(productRepo::insert)
                .map(ProductMapper::mapToProductDto);
    }

    public Mono<ProductDto> update(Mono<ProductDto> productDto,String id){
        return productRepo.findById(id)
                .flatMap(p -> productDto.map(ProductMapper::mapToProduct))
                .doOnNext(entity -> entity.setId(id))
                .flatMap(productRepo::save)
                .map(ProductMapper::mapToProductDto);
    }

    public void delete(String id){
        productRepo.deleteById(id);
    }



}
