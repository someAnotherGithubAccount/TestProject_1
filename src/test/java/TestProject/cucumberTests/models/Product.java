package TestProject.cucumberTests.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Product {
    private String name;
    private String currentPrice;
    private String oldPrice;
    private String discount;

    public Product() {
    }

    public Product(String name, String currentPrice, String oldPrice, String discount) {
        this.name = name;
        this.currentPrice = currentPrice;
        this.oldPrice = oldPrice;
        this.discount = discount;
    }

    public static Optional<List<Product>> createListOfProducts(List<String> listOfProducts){
        List<Product> productsList = new ArrayList<>();
        for(String singleProduct:listOfProducts){
            Product product = new Product();
            String[] products = singleProduct.split("\n");
            product.name = products[0];
            String[] prod = products[1].split(" ");
            if(prod.length > 1){
                product.currentPrice = prod[0];
                product.oldPrice = prod[1];
                product.discount = prod[2];
            }else {
                product.currentPrice = prod[0];
                product.oldPrice = "";
                product.discount = "";
            }
            productsList.add(product);
        }
        return Optional.of(productsList);
    }
}
