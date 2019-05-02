import java.util.*;

public class Interface {
    private Depot depot1;
    private Depot depot2;

    public static void main(String[] args) {
        Interface intFace = new Interface();
        intFace.run();
    }

    private void run() {
        depot1 = new Depot();
        depot2 = new Depot();
        interfaceMenu();
    }

    private void interfaceMenu() {
        Scanner interfaceInput = new Scanner(System.in);
        int option;

        System.out.println("ALCOLWORTHS SUPERMARKETS PRODUCT DEPOT \n");
        System.out.println("Type a number (1-8) and press Enter to access the following options: \n");
        System.out.println("To add a depot, press 1  \n");
        System.out.println("To remove a depot, press 2 \n");
        System.out.println("To add a product to a depot, press 3 \n");
        System.out.println("To remove an item of a product from a depot, press 4 \n");
        System.out.println("To list the depots, press 5 \n");
        System.out.println("To list the products in a depot, press 6 \n");
        System.out.println("To search for a product in the depots, press 7 \n");
        System.out.println("To sum up the values of all products inside a depot, press 8 \n");
        System.out.println("To exit the program, press 0 \n");
        option = interfaceInput.nextInt();
        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                addDepot();
                break;
            case 2:
                deleteDepot();
                break;
            case 3:
                addProductToDepot();
                break;
            case 4:
                removeProductFromDepot();
                break;
            case 5:
                listDepots();
                break;
            case 6:
                listProductsInDepot();
                break;
            default:
                System.out.println("Please enter a number from 0 to 8.\n");
                interfaceMenu();
        }
        interfaceInput.close();
    }

    //  Creates new instances of Depot
    private void addDepot() {
        Scanner keyboard = new Scanner(System.in);
        String depot1Name = depot1.getName();
        String depot2Name = depot2.getName();
        String depotNameInput;

//      Check if any there are any empty depot slots
        if (depot1Name == null) {
            System.out.println("Enter name for depot 1:  ");
            depotNameInput = keyboard.nextLine();
//          Check for existing depot names
            if (depotNameInput.equals(depot2Name)) {
                System.out.println("Depot Already exist.\n");
                interfaceMenu();
            }
            depot1.setName(depotNameInput);
            System.out.println("Depot 1 name is " + depotNameInput + "\n");
            interfaceMenu();
        } else if (depot2Name == null) {
            System.out.println("Enter name for depot 2:  ");
            depotNameInput = keyboard.nextLine();
//          Check for existing depot names
            if (depotNameInput.equals(depot1Name)) {
                System.out.println("Depot already exist.\n");
                interfaceMenu();
            }
            depot2.setName(depotNameInput);
            System.out.println("Depot 2 name is " + depotNameInput + "\n");
            interfaceMenu();
        } else {
            System.out.println("Unable to add more depot as there can only be 2 depots.");
            interfaceMenu();
        }
        keyboard.close();
    }

    private void deleteDepot() {
        Scanner keyboard = new Scanner(System.in);

        String deleteInput;
        String depot1Name = depot1.getName();
        String depot2Name = depot2.getName();

        System.out.println("Enter name of depot to be removed: ");
        deleteInput = keyboard.nextLine();

        if (deleteInput.equals(depot1Name)) {
            depot1 = null;
            keyboard.close();
        } else if (deleteInput.equals(depot2Name)) {
            depot2 = null;
            keyboard.close();
        } else
            System.out.println("Unable to find the depot entered.");
        interfaceMenu();
    }

    private void addProductToDepot() {
        Scanner keyboard = new Scanner(System.in);
        String depot1Name = depot1.getName();
        String depot2Name = depot2.getName();
        String depotNameInput, productName, output;
        double price, weight;
        int quantity;

//      assign depotname variable something to avoid nullpointerexception later
        if (depot1Name == null)
            depot1Name = "empty";
        if (depot2Name == null)
            depot2Name = "empty";

        System.out.println("Specify product name: ");
        productName = keyboard.nextLine();

        if (depot1.searchExistingProduct(productName) != null) {
            System.out.println(depot1.searchExistingProduct(productName));
            System.out.println("Please enter quantity of product to be added: ");
            quantity = keyboard.nextInt();
            while (quantity <= 0){
                System.out.println("Quantity cannot be less than equal to zero. Please re-enter product quantity:");
                quantity = keyboard.nextInt();
            }
            depot1.updateProduct(productName,quantity);
            System.out.println("Product " + productName + " updated. \n");
            interfaceMenu();
        } else if (depot2.searchExistingProduct(productName) != null) {
            System.out.println(depot2.searchExistingProduct(productName));
            System.out.println("Please enter quantity of product to be added: ");
            quantity = keyboard.nextInt();
            while (quantity <= 0){
                System.out.println("Quantity cannot be less than equal to zero. Please re-enter product quantity:");
                quantity = keyboard.nextInt();
            }
            depot2.updateProduct(productName,quantity);
            System.out.println("Product " + productName + " updated. \n");
            interfaceMenu();
        }
        else {
            System.out.println("Which depot will this product be entered?: ");
            depotNameInput = keyboard.nextLine();
            while (!depot1Name.equals(depotNameInput) && !depot2Name.equals(depotNameInput)) {
                System.out.println("Unable to find depot. Please re-enter the product depot:");
                depotNameInput = keyboard.nextLine();
            }
            System.out.println("Specify price: ");
            price = keyboard.nextDouble();
            while( price <= 0 ) {
                System.out.println("Price cannot be less than or equal to zero. Please re-enter product price:");
                price = keyboard.nextDouble();
            }
            System.out.println("Specify  its weight: ");
            weight = keyboard.nextDouble();
            while (weight <= 0) {
                System.out.println("Weight cannot be less than or equal to zero. Please re-enter product weight:");
                weight = keyboard.nextDouble();
            }
            System.out.println("Specify the quantity in the inventory: ");
            quantity = keyboard.nextInt();
            while (quantity <= 0){
                System.out.println("Quantity cannot be less than equal to zero. Please re-enter product quantity:");
                quantity = keyboard.nextInt();
            }
            if (depotNameInput.equals(depot1Name)) {
                output = depot1.addProduct(productName, price, weight, quantity);
                System.out.println(output);
                interfaceMenu();
            }
            if (depotNameInput.equals(depot2Name)) {
                output = depot2.addProduct(productName, price, weight, quantity);
                System.out.println(output);
                interfaceMenu();
            }
        }
    }

    private void removeProductFromDepot(){
        Scanner keyboard = new Scanner(System.in);

        String depot1Name = depot1.getName();
        String depot2Name = depot2.getName();
        String productNameInput, depotNameInput, output;

//      assign depotname variable something to avoid nullpointerexception later
        if (depot1Name == null)
            depot1Name = "empty";
        if (depot2Name == null)
            depot2Name = "empty";

        System.out.println("Specify product name: ");
        productNameInput = keyboard.nextLine();
        while (depot1.searchExistingProduct(productNameInput) == null && depot2.searchExistingProduct(productNameInput) == null) {
            System.out.println("Unable to find product on the depots. Please re-enter the product name: ");
            productNameInput = keyboard.nextLine();
        }
        System.out.println("Specify depot name: ");
        depotNameInput = keyboard.nextLine();
        while (!depot1Name.equals(depotNameInput) && !depot2Name.equals(depotNameInput)) {
            System.out.println("Unable to find depot. Please re-enter the product depot:");
            depotNameInput = keyboard.nextLine();
        }

        if (depotNameInput.equals(depot1Name)) {
            output = depot1.deleteProduct(productNameInput);
            System.out.println(output);
            interfaceMenu();
        } else {
            output = depot2.deleteProduct(productNameInput);
            System.out.println(output);
            interfaceMenu();
        }
    }

    private void listDepots() {
        if (depot1 == null && depot2 == null) {
            System.out.println("No depots exist");
            interfaceMenu();
        }
//      List the depot names and the quantity of products stored inside
        if (depot1 != null)
            System.out.println("Depot " + depot1.getName() + " has " + depot1.getNumberOfProductsStored() + " products.\n");
        if (depot2 != null)
            System.out.println("Depot " + depot2.getName() + " has " + depot2.getNumberOfProductsStored() + " products.\n");
        interfaceMenu();
    }

    private void listProductsInDepot() {
        Scanner keyboard = new Scanner(System.in);
        String depot1Name = depot1.getName();
        String depot2Name = depot2.getName();
        String depotNameInput, output;

//      assign depotname variable something to avoid nullpointerexception later
        if (depot1Name == null)
            depot1Name = "empty";
        if (depot2Name == null)
            depot2Name = "empty";

        System.out.println("Specify depot name: ");
        depotNameInput = keyboard.nextLine();
        if (!depot1Name.equals(depotNameInput) && !depot2Name.equals(depotNameInput)) {
            System.out.println("Unable to find depot.");
            interfaceMenu();
        }

        if (depotNameInput.equals(depot1Name)) {
            if (depot1.getProduct1() != null)
                System.out.println(depot1.getProduct1());
            else if (depot1.getProduct2() != null)
                System.out.println(depot1.getProduct2());
            else if (depot1.getProduct3() != null)
                System.out.println(depot1.getProduct3());
            else
                System.out.println("No products in depot \n");
            interfaceMenu();
        }

        if (depotNameInput.equals(depot2Name)) {
            if (depot2.getProduct1() != null)
                System.out.println(depot2.getProduct1());
            else if (depot2.getProduct2() != null)
                System.out.println(depot2.getProduct2());
            else if (depot2.getProduct3() != null)
                System.out.println(depot2.getProduct3());
            else
                System.out.println("No products in depot \n");
            interfaceMenu();
        }
    }
}
