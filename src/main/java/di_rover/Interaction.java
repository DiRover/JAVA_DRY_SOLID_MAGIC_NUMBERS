package di_rover;

import java.util.Scanner;

public class Interaction {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static int YES = 1;
    public static int NO = 2;
    public static int EXIT = 0;

    public static void getGreeting() {
        System.out.println("Hello customer!");
    }

    public static void askAboutOverseeItems() {
        System.out.println("Do you want to see available items?");
        System.out.println("Please enter " + YES + " to say \"YES\" or enter " + NO + " to say \"NO\":");
        int userAnswerAboutOverseeItems = SCANNER.nextInt();
        if (userAnswerAboutOverseeItems != YES) {
            getByeTest();
            System.exit(0);
        }
    }

    public static int askAboutTypeOfItems() {
        System.out.println("What type of items do you what to see? Select the number:");
        System.out.println(Desk.FILTER_TYPE_ELECTRONICS + " - Electronics");
        System.out.println(Desk.FILTER_TYPE_CARS + " - Cars");
        System.out.println(Desk.FILTER_TYPE_ALL + " - All");
        System.out.println(EXIT + " - to exit");
        int answer = SCANNER.nextInt();
        exitProgram(answer);

        return answer;
    }

    public static void getTextAboutIncorrectValue() {
        System.out.println("Entered value is not correct");
    }

    public static void getByeTest() {
        System.out.println("See you later!");
    }

    public static void exitProgram(int exit) {
        if (exit == 0) {
            getByeTest();
            System.exit(0);
        }
    }

    public static int askAboutChooseItem() {
        System.out.println("Enter item's code to add to shop cart. You can only select one item at a time");
        System.out.println(EXIT + " - to exit");
        return SCANNER.nextInt();
    }

    public static void checkCorrectUserItemCode(boolean isCodeCorrect) {
        if (isCodeCorrect) {
            System.out.println("Item is added to cart");
        } else {
            System.out.println("Item is not added to cart. May be you entered invalid item code");
        }
    }

    public static void getTextShowCart() {
        System.out.println("Your cart has:");
    }
}
