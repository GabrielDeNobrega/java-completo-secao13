package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birth = sdf.parse(sc.next());

		Client cli = new Client(name, email, birth);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		sc.nextLine();
		OrderStatus status = OrderStatus.valueOf(sc.next());
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();

		Order ord = new Order(new Date(), status, cli);

		for (int i = 1; i <= n; i++) {

			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String prodName = sc.nextLine();
			System.out.print("Product price: ");
			double prodPrice = sc.nextDouble();

			Product prod = new Product(prodName, prodPrice);

			System.out.print("Quantity: ");
			int prodQuantity = sc.nextInt();

			ord.addItem(new OrderItem(prodQuantity, prodPrice, prod));

		}
		
		System.out.println();
		System.out.println(ord);

		sc.close();

	}

}
