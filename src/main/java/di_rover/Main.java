package di_rover;

public class Main {

    public static void main(String[] args) {
        Interaction.getGreeting();
        Interaction.askAboutOverseeItems();

        Desk desk = Desk.getDesk();

        boolean isFilterCorrect = false;

        while (!isFilterCorrect) {
            int typeOfFilter = Interaction.askAboutTypeOfItems();

            if (typeOfFilter == Interaction.EXIT) {
                Interaction.getByeTest();
                Interaction.exitProgram(typeOfFilter);
            }

            isFilterCorrect = desk.setFilterType(typeOfFilter);
            if (!isFilterCorrect) {
                Interaction.getTextAboutIncorrectValue();
            }
        }

        desk.showItems();

        Cart cart = new Cart();

        int answer = 1;

        while (answer != 0) {
            answer = Interaction.askAboutChooseItem();
            boolean isItemAdded = cart.addItem(answer, desk.filteredItems);
            Interaction.checkCorrectUserItemCode(isItemAdded);
        }

        Interaction.getTextShowCart();

        cart.showItems();
    }
}