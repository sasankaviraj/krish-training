public class Application {

    public static void main(String[] args) {

        Meal.Builder builder = new Meal.Builder();
        Meal meal = builder.refreshment("Coca-cola").shortEat("Fish Bun").dessert("Fruit Salad").build();
        System.out.println(meal);

        Meal meal1 = builder.refreshment("Pepsi").dessert("Ice-Cream").shortEat("Fish-Burger").rice("Fried Rice").build();
        System.out.println(meal1);
    }
}
