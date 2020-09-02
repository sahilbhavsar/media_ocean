import constant.Constant;
import entity.Product;
import utils.CommonUtils;
import utils.ProductsHandler;

import java.util.ArrayList;
import java.util.List;

public class RunApplication {
    public static void main(String[] args) {
        CommonUtils.printOptionsForUsers();
        List<Product> finalProducts = new ArrayList<>();
        int option;
        do {
            option = CommonUtils.acceptIntegerInputFromUser();


            switch (option) {
                case 1:
                    Product addedProduct = ProductsHandler.addProduct();
                    if (addedProduct != null) {
                        finalProducts.add(addedProduct);
                    }
                    CommonUtils.printOptionsForUsers();
                    break;

                case 2:
                    ProductsHandler.calculateFinalAmount(finalProducts);
                    CommonUtils.printOptionsForUsers();
                    break;

                case 3:
                    CommonUtils.printString(Constant.THANK_YOU);
                    System.exit(0);
                default:
                    CommonUtils.printString(Constant.INVALID_OPTION);
                    CommonUtils.printOptionsForUsers();
                    break;
            }
        } while (option != 0);
    }
}
