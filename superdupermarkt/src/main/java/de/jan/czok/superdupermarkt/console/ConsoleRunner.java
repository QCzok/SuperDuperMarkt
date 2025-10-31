package de.jan.czok.superdupermarkt.console;

import de.jan.czok.superdupermarkt.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final ProductService productService;

    public ConsoleRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        int days = 10;
        if (args.length > 0) {
            try { days = Integer.parseInt(args[0]); } catch (NumberFormatException ignored) {}
        }

        System.out.println("Starting SuperDuperMarkt simulation for " + days + " days.\n");
        productService.simulateDays(days);
        System.out.println("\nSimulation finished.");
    }
}
