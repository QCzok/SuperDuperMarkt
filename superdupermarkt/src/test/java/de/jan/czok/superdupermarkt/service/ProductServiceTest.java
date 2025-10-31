package de.jan.czok.superdupermarkt.service;

import de.jan.czok.superdupermarkt.respository.ProductRepository;
import de.jan.czok.superdupermarkt.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

public class ProductServiceTest {
    @Test
    void simulateDaysShouldRunWithoutErrors() {
        ProductRepository mockRepo = Mockito.mock(ProductRepository.class);
        Mockito.when(mockRepo.findAll()).thenReturn(Collections.emptyList());

        ProductService service = new ProductService(mockRepo);
        service.simulateDays(3);
    }
}
