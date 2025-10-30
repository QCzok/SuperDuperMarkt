package de.jan.czok.superdupermarkt.services;

import de.jan.czok.superdupermarkt.model.Product;
import de.jan.czok.superdupermarkt.respository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void simulateDays(int days) {
        List<Product> products = repository.findAll();
        LocalDate current = LocalDate.now();

        printDayHeader(0, current);
        printProducts(products, current);

        for (int day = 1; day <= days; day++) {
            current = current.plusDays(1);

            for (Product p : products) {
                p.updateDaily(current);
            }

            printDayHeader(day, current);
            printProducts(products, current);

            // products.removeIf(p -> p.shouldBeRemoved(current));
        }
    }

    private void printDayHeader(int day, LocalDate date) {
        System.out.printf("==== Tag %d — %s ====\n", day, date);
    }

    private void printProducts(List<Product> products, LocalDate currentDate) {
        for (Product p : products) {
            boolean remove = p.shouldBeRemoved(currentDate);
            System.out.printf("%s | Preis: %.2f€ | Qualität: %d | Entfernen: %s\n",
                    p.getName(), p.getCurrentPrice(currentDate), p.getQuality(), remove ? "JA" : "NEIN");
        }
        System.out.println();
    }
}
