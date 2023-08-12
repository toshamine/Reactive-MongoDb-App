package dev.chiba.reactivemongoapp.repo;

import dev.chiba.reactivemongoapp.model.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepo extends ReactiveMongoRepository<Product,String> {

    Flux<Product> findByPriceBetween(Range<Double> priceRange);
}
