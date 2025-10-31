package de.jan.czok.superdupermarkt.respository;

import de.jan.czok.superdupermarkt.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
