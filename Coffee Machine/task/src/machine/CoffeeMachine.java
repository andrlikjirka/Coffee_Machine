package machine;

/* Imports */
import enums.State;

import model.CoffeeMachineModel;

import java.util.Scanner;

/**
 * Main class
 */
public class CoffeeMachine {
    /** Scanner for user input */
    public static Scanner scanner = new Scanner(System.in);
    /** Coffe Machine Model */
    private static CoffeeMachineModel coffeeMachine;
    /** Current State of Coffee Machine */
    private static State state;

    /* Constants for supplies of different coffee types */
    private static final int ESPRESSO_WATER = 250;
    private static final int ESPRESSO_BEANS = 16;
    private static final int ESPRESSO_MONEY = 4;

    private static final int LATTE_WATER = 350;
    private static final int LATTE_MILK = 75;
    private static final int LATTE_BEANS = 20;
    private static final int LATTE_MONEY = 7;

    private static final int CAPPUCCINO_WATER = 200;
    private static final int CAPPUCCINO_MILK = 100;
    private static final int CAPPUCCINO_BEANS = 12;
    private static final int CAPPUCCINO_MONEY = 6;

    /** Method for choosing action based on user input */
    private static void choosingAction(){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String inputAction = scanner.next().toLowerCase();
        switch (inputAction) {
            case "buy":
                state = State.BUY;
                break;

            case "fill":
                state = State.FILL;
                break;

            case "take":
                state = State.TAKE;
                break;

            case "remaining":
                state = State.REMAINING;
                break;

            case "exit":
                state = State.EXIT;
                break;

            default:
                state = State.INVALID_ACTION;
        }
    }

    /** Invalid Action Method, invoked when user inputs unsupported action */
    private static void invalidAction() {
        System.out.println("Invalid Action!");
        state = State.CHOOSING_ACTION;
    }

    /** Methods for taking all money from the coffee machine */
    private static void take() {
        System.out.printf("I gave you $%d\n\n", coffeeMachine.getMoney());
        coffeeMachine.setMoney(0);

        state = State.CHOOSING_ACTION;
    }

    /** Method for filling supplies */
    private static void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        int water = scanner.nextInt();
        coffeeMachine.setWaterSupply(coffeeMachine.getWaterSupply() + water);
        System.out.println("Write how many ml of milk you want to add: ");
        int milk = scanner.nextInt();
        coffeeMachine.setMilkSupply(coffeeMachine.getMilkSupply() + milk);
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int beans = scanner.nextInt();
        coffeeMachine.setBeansSupply(coffeeMachine.getBeansSupply() + beans);
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int cups = scanner.nextInt();
        coffeeMachine.setDisposableCups(coffeeMachine.getDisposableCups() + cups);
        System.out.println();

        state = State.CHOOSING_ACTION;
    }

    /** Method for buying a coffee */
    private static void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back - to main menu: ");
        String buy = scanner.next().toLowerCase();
        switch (buy) {
            case "1":
            case "espresso":
                buyEspresso();
                break;

            case "2":
            case "latte":
                buyLatte();
                break;

            case "3":
            case "cappuccino":
                buyCappuccino();
                break;

            case "4":
            case "break":
                System.out.println();
                break;

            default:
                System.out.println("Not available");
        }
        state = State.CHOOSING_ACTION;
    }

    /** Method for making cappuccino */
    private static void buyCappuccino() {
        if (coffeeMachine.getWaterSupply() < CAPPUCCINO_WATER) {
            System.out.println("Sorry, not enough water!\n");
        } else if (coffeeMachine.getMilkSupply() < CAPPUCCINO_MILK) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (coffeeMachine.getBeansSupply() < CAPPUCCINO_BEANS) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (coffeeMachine.getDisposableCups() < 1) {
            System.out.println("Sorry, not enough disposable cups!\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            coffeeMachine.setWaterSupply(coffeeMachine.getWaterSupply() - CAPPUCCINO_WATER);
            coffeeMachine.setMilkSupply(coffeeMachine.getMilkSupply() - CAPPUCCINO_MILK);
            coffeeMachine.setBeansSupply(coffeeMachine.getBeansSupply() - CAPPUCCINO_BEANS);
            coffeeMachine.setMoney(coffeeMachine.getMoney() + CAPPUCCINO_MONEY);
            coffeeMachine.setDisposableCups(coffeeMachine.getDisposableCups() - 1);
        }
    }

    /** Method for making latte */
    private static void buyLatte() {
        if (coffeeMachine.getWaterSupply() < LATTE_WATER) {
            System.out.println("Sorry, not enough water!\n");
        } else if (coffeeMachine.getMilkSupply() < LATTE_MILK) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (coffeeMachine.getBeansSupply() < LATTE_BEANS) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (coffeeMachine.getDisposableCups() < 1) {
            System.out.println("Sorry, not enough disposable cups!\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            coffeeMachine.setWaterSupply(coffeeMachine.getWaterSupply() - LATTE_WATER);
            coffeeMachine.setMilkSupply(coffeeMachine.getMilkSupply() - LATTE_MILK);
            coffeeMachine.setBeansSupply(coffeeMachine.getBeansSupply() - LATTE_BEANS);
            coffeeMachine.setMoney(coffeeMachine.getMoney() + LATTE_MONEY);
            coffeeMachine.setDisposableCups(coffeeMachine.getDisposableCups() - 1);
        }
    }

    /** Method for making espresso */
    private static void buyEspresso() {
        if (coffeeMachine.getWaterSupply() < ESPRESSO_WATER) {
            System.out.println("Sorry, not enough water!\n");
        } else if (coffeeMachine.getBeansSupply() < ESPRESSO_BEANS) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (coffeeMachine.getDisposableCups() < 1) {
            System.out.println("Sorry, not enough disposable cups!\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            coffeeMachine.setWaterSupply(coffeeMachine.getWaterSupply() - ESPRESSO_WATER);
            coffeeMachine.setBeansSupply(coffeeMachine.getBeansSupply() - ESPRESSO_BEANS);
            coffeeMachine.setMoney(coffeeMachine.getMoney() + ESPRESSO_MONEY);
            coffeeMachine.setDisposableCups(coffeeMachine.getDisposableCups() - 1);
        }
    }

    /** Method for printing out remainig supplies of the coffee machine */
    public static void remaining(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", coffeeMachine.getWaterSupply());
        System.out.printf("%d ml of milk\n", coffeeMachine.getMilkSupply());
        System.out.printf("%d g of coffee beans\n", coffeeMachine.getBeansSupply());
        System.out.printf("%d disposable cups\n", coffeeMachine.getDisposableCups());
        System.out.printf("$%d  of money\n", coffeeMachine.getMoney());
        System.out.println();

        state = State.CHOOSING_ACTION;
    }

    /** Initialization method for coffee machine */
    public static void init() {
        coffeeMachine = new CoffeeMachineModel(400, 540, 120, 9, 550);
        state = State.CHOOSING_ACTION;
    }

    /**
     * Main method, entry point
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        init();

        while (state != State.EXIT) {
            switch (state) {
                case CHOOSING_ACTION:
                    choosingAction();
                    break;

                case BUY:
                    buy();
                    break;

                case FILL:
                    fill();
                    break;

                case TAKE:
                    take();
                    break;

                case REMAINING:
                    remaining();
                    break;

                case INVALID_ACTION:
                    invalidAction();
                    break;
            }
        }
    }
}
