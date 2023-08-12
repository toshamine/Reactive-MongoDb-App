package dev.chiba.reactivemongoapp.controller;

import dev.chiba.reactivemongoapp.dto.ProductDto;
import dev.chiba.reactivemongoapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Flux<ProductDto> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> findById(@PathVariable String id){
        return productService.findById(id);
    }

    @GetMapping("/range")
    public Flux<ProductDto> findByRange(@RequestParam("min") Double min, @RequestParam("max") Double max){
        return productService.findByPrice(min,max);
    }

    @PostMapping
    public Mono<ProductDto> save(@RequestBody Mono<ProductDto> productDto){
        return productService.save(productDto);
    }

    @PutMapping("/{id}")
    public Mono<ProductDto> update(@RequestBody Mono<ProductDto> productDto,@PathVariable String id){
        return productService.update(productDto,id);
    }

    @DeleteMapping
    public void delete(@PathVariable String id){
        productService.delete(id);
    }
}
