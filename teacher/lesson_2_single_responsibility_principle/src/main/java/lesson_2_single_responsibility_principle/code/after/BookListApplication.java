package lesson_2_single_responsibility_principle.code.after;

import java.util.Scanner;

import lesson_2_single_responsibility_principle.code.after.console_ui.AddBookUIAction;
import lesson_2_single_responsibility_principle.code.after.console_ui.ExitUIAction;
import lesson_2_single_responsibility_principle.code.after.console_ui.GetAllBooksUIAction;
import lesson_2_single_responsibility_principle.code.after.console_ui.RemoveBookUIAction;
import lesson_2_single_responsibility_principle.code.after.console_ui.UIAction;
import lesson_2_single_responsibility_principle.code.after.database.Database;
import lesson_2_single_responsibility_principle.code.after.database.InMemoryDatabaseImpl;
import lesson_2_single_responsibility_principle.code.after.services.AddBookService;
import lesson_2_single_responsibility_principle.code.after.services.GetAllBooksService;
import lesson_2_single_responsibility_principle.code.after.services.RemoveBookService;

public class BookListApplication {

	private static Database database = new InMemoryDatabaseImpl();
	private static AddBookService addBookService = new AddBookService(database);
	private static RemoveBookService removeBookService = new RemoveBookService(database);
	private static GetAllBooksService getAllBooksService = new GetAllBooksService(database);
	private static UIAction addBookUIAction = new AddBookUIAction(addBookService);
	private static UIAction removeBookUIAction = new RemoveBookUIAction(removeBookService);
	private static UIAction getAllBooksUIAction = new GetAllBooksUIAction(getAllBooksService);
	private static UIAction exitUIAction = new ExitUIAction();

	public static void main(String[] args) {
		while (true) {
			printProgramMenu();
			int menuNumber = getMenuNumberFromUser();
			executeSelectedMenuItem(menuNumber);
		}
	}

	private static void printProgramMenu() {
		System.out.println();
		System.out.println("Program menu:");
		System.out.println("1. Add book to list");
		System.out.println("2. Delete book from list");
		System.out.println("3. Show all books in the list");
		System.out.println("4. Exit");
		System.out.println();
	}

	private static int getMenuNumberFromUser() {
		System.out.println("Enter menu item number to execute:");
		Scanner scanner = new Scanner(System.in);
		return Integer.parseInt(scanner.nextLine());
	}

	private static void executeSelectedMenuItem(int selectedMenu) {
		switch (selectedMenu) {
			case 1: {
				addBookUIAction.execute();
				break;
			}
			case 2: {
				removeBookUIAction.execute();
				break;
			}
			case 3: {
				getAllBooksUIAction.execute();
				break;
			}
			case 4: {
				exitUIAction.execute();
				break;
			}
		}
	}

}