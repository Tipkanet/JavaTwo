package lesson_1;

import internet_store.domain.Product;
import lesson_1.command_handler.AddProductCommand;
import lesson_1.command_handler.DeleteProductCommand;
import lesson_1.database.InnerDatabase;
import lesson_1.database.InnerDatabaseImpl;
import lesson_1.menu.MainMenu;
import lesson_1.command_handler.UpdateProduct;
import lesson_1.product_find_handler.FindProduct;
import lesson_1.user_handler.UserInputValue;

public interface ProductListApplication {

    static void main(String[] args) {
        InnerDatabase innerDatabase = new InnerDatabaseImpl(new FindProduct());
        MainMenu mainMenu = new MainMenu();

        do {
            mainMenu.showMainMenu();
            UserInputValue<?> userInputValue = mainMenu.getUserInputValue();

            switch ((int) userInputValue.getValue()) {
                case 1 -> {
                    Product newProduct = new AddProductCommand().addTo(new Product());
                    innerDatabase.add(newProduct);
                }
                case 2 -> {
                    long deletedId = new DeleteProductCommand().deleteCommandHandler();
                    innerDatabase.deleteById(deletedId);
                }
                case 3 -> {
                    long updatedId = new UpdateProduct().updateProductCommand();
                    innerDatabase.updateById(updatedId);
                }
                case 4 -> innerDatabase.showReport();
                case 5 -> System.exit(0);
                default -> System.out.println("Wrong input. Try again.");
            }
        } while (true);
    }
}
