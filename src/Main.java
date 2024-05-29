import products.Cathegory;
import products.Customer;
import products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<Product> productList =
                generateProduct();
        System.out.println(productList);
        Customer customer1 = new Customer(170L, "Mario", 1);
        Customer customer2 = new Customer(180L, "Claudia", 2);
        List<Product> productsfilter = productList.stream().filter(product -> product.getCathegory().equals("BOOKS") && product.getPrice() > 100.00).toList();
        System.out.println(productsfilter);
        List<Product> babyfilter = productList.stream().filter(product -> product.getCathegory().equals("BABY")).toList();
        System.out.println(babyfilter);
        List<Product> productsoff = productList.stream().filter(product -> product.getCathegory().equals("BOYS")).map(product -> {
            product.setPrice(product.getPrice() * 0.9);
            return product;
        }).toList();
        System.out.println(productsoff);
        
    }

    public static List<Product> generateProduct() {
        List<Product> prodotti = new ArrayList<Product>();

        Random rdmn = new Random();
        Supplier<Long> randomId = () -> rdmn.nextLong(10000, 60000);
        Supplier<Double> randomprice = () -> rdmn.nextDouble(0, 200);
        Supplier<Product> randomProduct = () -> new Product("prodotto", randomcathegory().name(), randomprice.get(), randomId.get());
        for (int i = 0; i < 200; i++) {
            Product generateProduct = randomProduct.get();
            prodotti.add(generateProduct);

        }
        return prodotti;
    }

    public static Cathegory randomcathegory() {
        Random rdm = new Random();
        int num = rdm.nextInt(1, 4);
        Cathegory defaultCathegory = Cathegory.BABY;
        switch (num) {
            case 1: {
                defaultCathegory = Cathegory.BABY;
                break;
            }
            case 2: {
                defaultCathegory = Cathegory.BOOKS;
                break;
            }
            case 3: {
                defaultCathegory = Cathegory.BOYS;
                break;
            }

        }
        return defaultCathegory;
    }
}