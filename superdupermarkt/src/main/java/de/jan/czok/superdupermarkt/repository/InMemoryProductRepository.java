package de.jan.czok.superdupermarkt.respository;

import de.jan.czok.superdupermarkt.model.Cheese;
import de.jan.czok.superdupermarkt.model.Product;
import de.jan.czok.superdupermarkt.model.Wine;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public InMemoryProductRepository() {
        LocalDate today = LocalDate.now();

        products.add(new Cheese("Emmentaler", 33, today.plusDays(70), 2.00, today));
        products.add(new Cheese("Camembert", 45, today.plusDays(55), 1.50, today));
        products.add(new Cheese("Old Gouda", 29, today.plusDays(60), 3.00, today));

        products.add(new Wine("Bordeaux", 21, null, 10.00, today));
        products.add(new Wine("Chianti", 49, null, 12.00, today));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }
}
