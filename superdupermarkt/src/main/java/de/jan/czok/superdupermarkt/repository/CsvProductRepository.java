package de.jan.czok.superdupermarkt.respository;

import de.jan.czok.superdupermarkt.model.Cheese;
import de.jan.czok.superdupermarkt.model.Fruit;
import de.jan.czok.superdupermarkt.model.Product;
import de.jan.czok.superdupermarkt.model.Wine;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CsvProductRepository implements ProductRepository{
    @Value("classpath:products.csv")
    private Resource csvFile;

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            LocalDate today = LocalDate.now();

            for (CSVRecord record : csvParser) {
                String type = record.get("type").trim().toLowerCase();
                String name = record.get("name");
                int quality = Integer.parseInt(record.get("quality"));
                double basePrice = Double.parseDouble(record.get("basePrice"));

                LocalDate expiry = null;
                if (!record.get("expiryDate").isBlank()) {
                    expiry = LocalDate.parse(record.get("expiryDate"));
                }

                Product product;
                switch (type) {
                    case "cheese" -> product = new Cheese(name, quality, expiry, basePrice, today);
                    case "wine" -> product = new Wine(name, quality, expiry, basePrice, today);
                    case "fruit" -> product = new Fruit(name, quality, expiry, basePrice, today);
                    default -> throw new IllegalArgumentException("Unknown product type: " + type);
                }
                products.add(product);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file", e);
        }

        return products;
    }
}
