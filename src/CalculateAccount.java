import java.util.*;

public class CalculateAccount {
    static Scanner scanner = new Scanner(System.in);
    static float totalPrice = 0;
    static void calculate(){
        while (true){
            try {
                scanner.useLocale(Locale.US);

                System.out.println("На скольких людей нужно разделить счет?");
                int numberOfPeople = scanner.nextInt();

                if (numberOfPeople == 1){
                    System.err.println("Количество пользователей равно одному! Нет никого смысла для того, чтобы делить счет!");
                }
                else if (numberOfPeople < 1){
                    System.err.println("Некорректно введено количество людей. Отрицательное значение!");
                }
                else {
                    if (totalPrice > 0){
                        float separateAccount = totalPrice / numberOfPeople;
                        System.out.printf("Каждый из %d человек должен заплатить по %.2f рублей%n", numberOfPeople, separateAccount);
                        break;
                    }
                }
            }
            catch (Exception e){
                System.err.println("Возникла ошибка!");
            }
        }

    }

    static void addingAProduct() {
        Map<String, Float> dishesAndPrice = new HashMap<>();
        while (true) {
            try {
                scanner.useLocale(Locale.US);

                System.out.println("Введите название товара (Для завершения 'Завершить'): ");
                String productName = scanner.next();

                if (productName.equalsIgnoreCase("Завершить")){
                    if (dishesAndPrice.size() >= 1){
                        System.out.println("Добавленные товары: ");
                        for (Map.Entry<String, Float> entry : dishesAndPrice.entrySet()) {
                            System.out.println("Блюдо: " + entry.getKey() + ", Стоимость: " + entry.getValue() + " руб.");
                        }
                        for (Map.Entry<String, Float> entry : dishesAndPrice.entrySet()) {
                            totalPrice += entry.getValue();
                        }
                        System.out.printf("Итоговая сумма товаров: %.2f\n", totalPrice);
                    }
                    break;
                }
                System.out.println("Введите цену товара: ");
                float productPrice = scanner.nextFloat();

                dishesAndPrice.put(productName, productPrice);

                System.out.println("Товар успешно добавлен!");
            } catch (Exception e) {
                System.err.println("Возникла ошибка!");
            }
        }
    }
}
