package com.devsuperior.dsComponentesInjecaoDep;

import com.devsuperior.dsComponentesInjecaoDep.entities.Order;
import com.devsuperior.dsComponentesInjecaoDep.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DsComponentesInjecaoDepApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {

		SpringApplication.run(DsComponentesInjecaoDepApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------- System of Order -------- ");
		System.out.println("Basic value of order (no discount)  | Shipping");
		System.out.println("Below R$100.00                      | R$20.00");
		System.out.println("R$100.00 - R$200.00 exclusive.      | R$10.00");
		System.out.println("R$ 200.00 or more.                  | Free");

		System.out.println("Entrance");
		System.out.print("Code: ");
		Integer code = scan.nextInt();
		System.out.print("Basic value: ");
		Double value = scan.nextDouble();
		System.out.print("Discount percent: ");
		Double discount = scan.nextDouble();

		System.out.println(orderService.total(new Order(code, value, discount)));

		scan.close();
	}
}
