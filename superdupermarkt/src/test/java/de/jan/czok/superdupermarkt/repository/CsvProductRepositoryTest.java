package de.jan.czok.superdupermarkt.repository;

import de.jan.czok.superdupermarkt.model.Product;
import de.jan.czok.superdupermarkt.respository.CsvProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CsvProductRepositoryTest {
    @Autowired
    private CsvProductRepository repository;

    @Test
    void csvShouldLoadProductsSuccessfully() {
        List<Product> products = repository.findAll();
        assertFalse(products.isEmpty());
        assertEquals(4, products.size());
    }
}
