package internet_store.services.product;

import internet_store.database.product.ProductDatabase;
import internet_store.domain.Product;

import java.util.List;

public class FindAllByTitleService {

    private final ProductDatabase productDatabase;

    public FindAllByTitleService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public List<Product> execute(String title){
        return productDatabase.findAllByTitle(title);
    }
}
