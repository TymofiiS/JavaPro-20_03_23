/*

1.1 Дан клас Product, який складається з властивостей: 
- тип
- ціна

1.2 Реалізувати метод отримання всіх продуктів у вигляді списку, 
категорія яких еквівалентна “Book” та ціна більш ніж 250.


2.1 Дан клас Product, який складається з властивостей: 
- тип
- ціна
- можливість застосування знижки

2.2 Реалізувати метод отримання всіх продуктів як списку, 
категорія яких еквівалентна “Book” і з можливістю застосування знижки. Фінальний список повинен містити продукти з застосованою знижкою 10%. 

Так, якщо Продукт A був з ціною 1.0 USD, 
то його фінальна ціна залишатиметься 0.9 USD


3.1 Даний клас Product, який складається з властивостей: 
- тип
- ціна
- можливість застосування знижки

3.2 Реалізувати метод отримання найдешевшого продукту з категорії
 “Book”
3.3 У випадку, якщо жоден продукт не знайдено 
(ситуація, коли немає продукту з категорією), 
викинути виняток з повідомленням “Продукт [категорія: ім'я_категорії] не знайдено”.


4.1 Даний клас Product, який складається з властивостей: 
- тип
- ціна
- можливість застосування знижки
- дата додавання (можна використовувати тип даних java.time.LocalDate,
 java.time.LocalDateTime або java.util.Date)

4.2 Реалізувати метод отримання трьох останніх доданих продуктів


5.1 Цей клас Product, який складається з властивостей: 
- тип
- ціна
- можливість застосування знижки
- дата додавання (можна використовувати тип даних java.time.LocalDate,
 java.time.LocalDateTime або java.util.Date)

5.2 Реалізувати метод калькуляції загальної вартості продуктів, 
які відповідають наступним критеріям:

- продукт додано протягом поточного року
- продукт має тип “Book”
- ціна продукту не перевищує 75


** 6.1 Дан клас Product, який складається з властивостей: 
- ідентифікаційний номер
- тип
- ціна
- можливість застосування знижки
– дата додавання (можна використовувати тип даних java.time.LocalDate,
 java.time.LocalDateTime або java.util.Date)

** 6.2 Реалізувати метод групування об'єктів за типом продукту. 
Таким чином результатом виконання методу буде тип даних “Словник”,
що зберігає пару ключ-значення: {тип: список_продуктів}

Наприклад:
{
	“Book”, [
	{type: “Book”, price: 100, discount: false, createDate: 01-01 -2022}, 
	{…}, 
	{…}]
},
{
	“Toy”, [
	{type: “Toy”, price: 100, discount: true, createDate: 10–102022}, 
	{…}]
}

 */

package ua.ithillel.hw15;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import ua.ithillel.hw15.Product.ProductType;

public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw15\n");
			
		// Init list
		List<Product> products = List.of(
				new Product(ProductType.Toy, 300, true, LocalDate.of(2023,5,26)),
				new Product(ProductType.Book, 60, true, LocalDate.of(2023,5,20)),
				new Product(ProductType.Book, 30, false, LocalDate.of(2022,5,23)),
				new Product(ProductType.Book, 50, true, LocalDate.of(2023,5,24)),
				new Product(ProductType.Book, 350, true, LocalDate.of(2023,5,24)),
				new Product(ProductType.Book, 450, false, LocalDate.of(2023,5,24)),
				new Product(ProductType.Toy, 30, true, LocalDate.of(2023,5,20)),
				new Product(ProductType.Toy, 100, true, LocalDate.of(2023,5,16)),
				new Product(ProductType.Book, 40, false, LocalDate.of(2023,5,22)));
		
		
		System.out.println("\nGet Books with high price");
		System.out.println(
				Product.getTypeWithHighPrice(
						products, Product.ProductType.Book, 250));
	
		System.out.println("\nGet Books with applyed discount");
		System.out.println(
				Product.getTypeWithApplyedDiscount(
						products, Product.ProductType.Book, 10));
		
		System.out.println("\nGet Books with min price");
		System.out.println(
				Product.getTypeWithMinPrice(
						products, Product.ProductType.Book));
		
		System.out.println("\nGet Exception with min price");
		try {
			Product.getTypeWithMinPrice(
					products, Product.ProductType.Pen);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nGet recent products");
		System.out.println(
				Product.getRecentTypes(products, 3));
		
		System.out.println("\nGet some Books total price");
		System.out.println(
				Product.getTypesTotalPrice(
						products, 
						LocalDate.of(2023,1,1),
						75,
						Product.ProductType.Book));
		
		System.out.println("\nGroup Products by Type");		
		Map<Product.ProductType, List<Product>> groups = 
				Product.groupProductsByType(products);
		for (var entry : groups.entrySet()) {
		    System.out.print("   " + entry.getKey() + ", " );
		    System.out.println( entry.getValue());
		}

	}
}
