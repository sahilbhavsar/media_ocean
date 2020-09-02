package utils;

import constant.Constant;
import entity.Product;
import enums.CategoryTaxEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsHandler {
    private static List<Product> products = new ArrayList<>();
    private static Map<Long, Product> productMap = new HashMap<>();
    private static Map<String, Integer> categoryDiscountMap = new HashMap<>();


    static {
        products.add(new Product(1L, "Mobile", 10000.0, CategoryTaxEnum.A));
        productMap.put(1L, new Product(1L, "Mobile", 10000.0, CategoryTaxEnum.A));

        products.add(new Product(2L, "Television", 20000.0, CategoryTaxEnum.A));
        productMap.put(2L, new Product(2L, "Television", 20000.0, CategoryTaxEnum.A));

        products.add(new Product(3L, "T Shirt", 20000.0, CategoryTaxEnum.B));
        productMap.put(3L, new Product(3L, "T Shirt", 20000.0, CategoryTaxEnum.B));

        products.add(new Product(4L, "Jeans", 500.0, CategoryTaxEnum.B));
        productMap.put(4L, new Product(4L, "Jeans", 500.0, CategoryTaxEnum.B));


        products.add(new Product(5L, "Maggie", 500.0, CategoryTaxEnum.C));
        productMap.put(5L, new Product(5L, "Maggie", 500.0, CategoryTaxEnum.C));

        products.add(new Product(6L, "Juice", 500.0, CategoryTaxEnum.C));
        productMap.put(6L, new Product(6L, "Juice", 500.0, CategoryTaxEnum.C));

        categoryDiscountMap.put("A", 10);
        categoryDiscountMap.put("B", 20);
        categoryDiscountMap.put("C", 0);


    }


    public static void displayAllProducts() {
        System.out.println(Constant.SELECT_PRODUCT);

        products.forEach(product -> {
            System.out.println("Product id " + product.getId() + ". Product: " + product.getName() + " Price: " + product.getPrice());
        });
        System.out.println("Press 7 to Exit");

    }

    public static Product addProduct() {
        displayAllProducts();
        int option;
        do {
            option = CommonUtils.acceptIntegerInputFromUser();

            switch (option) {

                case 1:
                    return productMap.get(1L);

                case 2:
                    return productMap.get(2L);

                case 3:
                    return productMap.get(3L);

                case 4:
                    return productMap.get(4L);

                case 5:
                    return productMap.get(5L);

                case 6:
                    return productMap.get(6L);

                case 7:
                    return null;

                default:
                    CommonUtils.printString(Constant.INVALID_OPTION);
                    break;
            }
            displayAllProducts();
        } while (option != 7);


        return null;
    }

    public static void calculateFinalAmount(List<Product> finalProducts) {
        Double finalAmount = 0.0;
        Double taxAmount = 0.0;

        for (Product product : finalProducts) {
            taxAmount += product.getPrice() * categoryDiscountMap.get(product.getCategory().name()) / 100;
            finalAmount += product.getPrice() + taxAmount;
        }

        System.out.println("Final Amount " + finalAmount + " Final tax " + taxAmount);

    }
}
