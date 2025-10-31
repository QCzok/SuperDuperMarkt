package de.jan.czok.superdupermarkt.service;

import de.jan.czok.superdupermarkt.repository.ProductRepository;
import de.jan.czok.superdupermarkt.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository repository;

    @Test
    void simulateDaysShouldRunWithRealRepositories() {
        // ensures the Spring context loads and the service runs end-to-end
        productService.simulateDays(2);
    }
}
