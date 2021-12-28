package machine;
import java.util.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int cash = 550;
        int[] data;

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String choice = scanner.next();
            switch (choice) {
                case "buy":
                    data = buy(scanner, water, milk, beans, cups, cash);
                    water = data[0];
                    milk = data[1];
                    beans = data[2];
                    cups = data[3];
                    cash = data[4];
                    break;
                case "fill":
                    data = fill(scanner, water, milk, beans, cups, cash);
                    water = data[0];
                    milk = data[1];
                    beans = data[2];
                    cups = data[3];
                    cash = data[4];
                    break;
                case "take":
                    cash = 0;
                    break;
                case "remaining":
                    displayStats(water, milk, beans, cups, cash);
                    break;
                case "exit":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }

    private static int[] fill(Scanner scanner, int water, int milk, int beans, int cups, int cash) {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += scanner.nextInt();

        return new int[] {water, milk, beans, cups, cash};
    }

    private static int[] buy(Scanner scanner, int water, int milk, int beans, int cups, int cash) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - return to menu:");
        String coffeeType = scanner.next();
        switch (coffeeType) {
            case "1":
                if (water >= 250 && beans >= 16 && cups >= 1) {
                    water -= 250;
                    beans -= 16;
                    cups -= 1;
                    cash += 4;
                } else {
                    System.out.println("Out of resources, sorry ...");
                }
                break;
            case "2":
                if (water >= 350 && milk >= 75 && beans >= 20 && cups >= 1) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups -= 1;
                    cash += 7;
                } else {
                    System.out.println("Out of resources, sorry ...");
                }
                break;
            case "3":
                if (water >= 200 && milk >= 100 && beans >= 12 && cups >= 1) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups -= 1;
                    cash += 6;
                } else {
                    System.out.println("Out of resources, sorry ...");
                }
                break;
            case "back":
                break;
            default:
                System.out.println("Not a valid option");
                break;
        }

        return new int[] {water, milk, beans, cups, cash};
    }

    public static void displayStats(int water, int milk, int beans, int cups, int cash) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", beans);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n", cash);
    }
}
