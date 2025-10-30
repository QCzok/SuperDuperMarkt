package de.jan.czok.superdupermarkt.respository;

import de.jan.czok.superdupermarkt.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class CompositeProductRepository implements ProductRepository {
    private final CsvProductRepository csvRepo;
    private final InMemoryProductRepository memoryRepo;

    public CompositeProductRepository(CsvProductRepository csvRepo, InMemoryProductRepository memoryRepo) {
        this.csvRepo = csvRepo;
        this.memoryRepo = memoryRepo;
    }

    @Override
    public List<Product> findAll() {
        try {
            List<Product> fromCsv = csvRepo.findAll();
            if (fromCsv != null && !fromCsv.isEmpty()) {
                System.out.println("CSV-Datei erfolgreich geladen: " + fromCsv.size() + " Produkte.\n");
                return fromCsv;
            }
        } catch (Exception e) {
            System.err.println("CSV konnte nicht gelesen werden: " + e.getMessage());
        }
        System.out.println("Fallback auf InMemoryProductRepository.\n");
        return memoryRepo.findAll();
    }
}
