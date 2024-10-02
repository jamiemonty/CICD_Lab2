package ie.atu.lab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

    @RestController
    public class ProductController {
        private List<Product> products = new ArrayList<>();

        public ProductController(){
            products.add(new Product("Tv", "Made by Sony", 899, 100));
            products.add(new Product("Radio", "Made by Samsung", 99, 101));
        }

        @GetMapping("/getProducts")
        public List<Product> getProducts(){
            return products;
        }

        @PostMapping("addProduct")
        public ResponseEntity<List> addProduct(@RequestBody Product product)
        {
            products.add(product);
            return ResponseEntity.ok(products);
        }
    }
