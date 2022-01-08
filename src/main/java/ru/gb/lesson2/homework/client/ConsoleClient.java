package ru.gb.lesson2.homework.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.lesson2.homework.config.Config;
import ru.gb.lesson2.homework.entity.Product;
import ru.gb.lesson2.homework.impl.MainCart;
import ru.gb.lesson2.homework.impl.MainProductRepository;
import ru.gb.lesson2.homework.interfaces.Cart;
import ru.gb.lesson2.homework.interfaces.ProductRepository;

import java.util.List;
import java.util.Scanner;

public class ConsoleClient {
    private static ApplicationContext context;
    private static ProductRepository pr;
    private static Cart cart;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        context = new AnnotationConfigApplicationContext(Config.class);
        pr = context.getBean(MainProductRepository.class);
        cart = context.getBean(MainCart.class);

        showCommands();
        while (true) {
            System.out.println("Введите команду:");
            String str = scanner.nextLine();
            switch (str) {
                case "/cmd":
                    showCommands();
                    break;
                case "/shop":
                    showAllProducts();
                    break;
                case "/add":
                    addToCart();
                    break;
                case "/del":
                    deleteFromCart();
                    break;
                case "/cart":
                    showCart();
                    break;
                case "/newcart":
                    cart = context.getBean(Cart.class);
                    System.out.println("Новая корзина создана.");
                    break;
                case "/exit":
                    return;
            }
        }
    }

    private static void deleteFromCart() {
        while (true) {
            try {
                System.out.println("Введите id товара или /cancel для отмены:");
                String str = scanner.nextLine();
                if ("/cancel".equals(str)) {
                    return;
                }
                int id = Integer.parseInt(str);
                if (cart.showCartList() == null) {
                    System.out.println("Товара с таким id нет в корзине, повторите ввод:");
                } else {
                    cart.deleteProduct(id);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат, повторите процедуру:");
            }
        }

    }

    private static void showCart() {
        List<Product> cartList = cart.showCartList();
        if (cartList.size() == 0) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("В Вашей корзине:");
            for (Product p : cartList) {
                System.out.println(p.getInfo());
            }
        }

    }

    private static void addToCart() {
        while (true) {
            try {
                System.out.println("Введите id товара или /cancel для отмены:");
                String str = scanner.nextLine();
                if ("/cancel".equals(str)) {
                    return;
                }
                int id = Integer.parseInt(str);
                if (pr.getProduct(id) == null) {
                    System.out.println("Такого товара нет, введите заново (или /cancel для отмены");
                } else {
                    System.out.println("Введите количество:");
                    str = scanner.nextLine();
                    if ("/cancel".equals(str)) {
                        return;
                    }
                    int count = Integer.parseInt(str);
                    cart.addProduct(id, count);
                    System.out.println("В корзину добавлен товар: " + pr.getProduct(id).getInfo() + " в количестве " + count + "шт.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат, повторите процедуру:");
            }
        }
    }

    private static void showAllProducts() {
        for (Product p : pr.getAllProducts()) {
            System.out.println(p.getInfo());
        }
    }

    public static void showCommands() {
        System.out.println("Команды: \n" +
                "Показать витрину: /shop\n" +
                "Положить товар в корзину: /add\n" +
                "Удалить товар из корзины: /del\n" +
                "Посмотреть корзину: /cart\n" +
                "Показать список команд: /cmd\n" +
                "Сознать новую корзину: /newcart\n" +
                "Выход: /exit\n");
    }
}
