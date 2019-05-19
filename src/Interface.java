import java.util.*;

public class Interface {
    private Depot depot1;
    private Depot depot2;
    private Depot[] depotArr = new Depot[4];

    public static void main(String[] args) {
        Interface intFace = new Interface();
        intFace.run();
    }

    private void run() {
        for (int i = 0; i < depotArr.length; i++) {
            depotArr[i] = new Depot();
            depotArr[i].initializeProductArr();
        }

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
                addDepotArr();
                break;
            case 2:
                deleteDepotArr();
                break;
            case 3:
                addProductToDepotArr();
                break;
            case 4:
                removeProductFromDepotArr();
                break;
            case 5:
                listDepots();
                break;
            case 6:
                listProductsInDepot();
                break;
            case 7:
                searchProductInDepot();
                break;
            case 8:
                cumulativeValueInDepot();
                break;
            default:
                System.out.println("Please enter a number from 0 to 8.\n");
                interfaceMenu();
        }
        interfaceInput.close();
    }

    private void addDepotArr() {
        Scanner keyboard = new Scanner(System.in);
        String depotNameInput;

        System.out.println("Enter name for new depot: ");
        depotNameInput = keyboard.nextLine();
        for (int i = 0; i < depotArr.length; i++) {
            if (depotArr[i].getName() == null) {
                depotArr[i].setName(depotNameInput);

                System.out.println("Depot " + i + " name is " + depotNameInput + "\n");
                interfaceMenu();
            }
            if (depotArr[i].getName().equals(depotNameInput)) {
                System.out.println("Depot with name " + depotNameInput + " already exists");
                interfaceMenu();
            }
        }
        System.out.println("Depot slot is full. Unable to add more than 4 depots \n");
        interfaceMenu();
    }

    private void deleteDepotArr() {
        Scanner keyboard = new Scanner(System.in);
        String deleteInput;

        System.out.println("Enter name of depot to be removed: ");
        deleteInput = keyboard.nextLine();

        for (int i = 0; i < depotArr.length; i++) {
            if (depotArr[i].getName() != null) {
                if (depotArr[i].getName().equals(deleteInput)) {
                    depotArr[i] = null;
                    System.out.println("Depot " + deleteInput + " removed.\n");
                    interfaceMenu();
                }
            }
        }
        System.out.println("Unable to find the depot entered.");
        interfaceMenu();
    }

    private void addProductToDepotArr() {
        Scanner keyboard = new Scanner(System.in);
        String depotNameInput, productName, output;
        double price, weight;
        int quantity;

        System.out.println("Specify product name: ");
        productName = keyboard.nextLine();

//      check for existing product in depot array
        for (int i = 0; i < depotArr.length; i++) {
            if (depotArr[i].getName() != null) {
//              depot found an existing product with the same name
                if (!depotArr[i].searchExistingProductArr(productName).equals("not found")) {
                    System.out.println(depotArr[i].searchExistingProductArr(productName) + " adding additional items.\n");
                    System.out.println("Please enter quantity of product to be added: ");
                    quantity = keyboard.nextInt();
                    while (quantity <= 0) {
                        System.out.println("Quantity cannot be less than equal to zero. Please re-enter product quantity:");
                        quantity = keyboard.nextInt();
                    }
                    depotArr[i].updateProductQuantity(productName, quantity);
                    System.out.println("Product " + productName + " updated. \n");
                    interfaceMenu();
                }
            }
        }

//      insert new product on depot
        System.out.println("Which depot this product will be inserted? :");
        depotNameInput = keyboard.nextLine();

        for (int i = 0; i < depotArr.length; i++) {
            if (depotArr[i].getName() != null) {
                if (depotArr[i].getName().equals(depotNameInput)) {
                    System.out.println("Specify price: ");
                    price = keyboard.nextDouble();
                    while (price <= 0) {
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
                    while (quantity <= 0) {
                        System.out.println("Quantity cannot be less than equal to zero. Please re-enter product quantity:");
                        quantity = keyboard.nextInt();
                    }
                    output = depotArr[i].addProductArr(productName, price, weight, quantity);
                    System.out.println(output);
                    interfaceMenu();
                }
            }
        }
        System.out.println("Unable to find requested depot. Returning to main menu. \n");
        interfaceMenu();
    }

    private void removeProductFromDepotArr() {
        Scanner keyboard = new Scanner(System.in);
        String productName, depotNameInput, output;
        int quantityRemoved;

        System.out.println("Specify product name: ");
        productName = keyboard.nextLine();

        int noProductFound = 0;
        for (int i = 0; i < depotArr.length; i++) {
            if (depotArr[i].getName() != null) {
                if (depotArr[i].searchExistingProductArr(productName).equals("not found")) {
                    noProductFound++;
                }
            }
        }
        if (noProductFound == depotArr.length) {
            System.out.println("Unable to find the product specified. Returning to main menu...");
            interfaceMenu();
        }

        System.out.println("Specify the depot name: ");
        depotNameInput = keyboard.nextLine();

        for (int y = 0; y < depotArr.length; y++) {
            if (depotArr[y].getName() != null) {
                if (depotArr[y].getName().equals(depotNameInput)) {
                    System.out.println("Specify quantity of product to be removed: ");
                    quantityRemoved = keyboard.nextInt();
                    while (quantityRemoved <= 0) {
                        System.out.println("Quantity cannot be less than or equal to zero. Please re-enter the quantity: ");
                        quantityRemoved = keyboard.nextInt();
                    }
                    output = depotArr[y].updateProductQuantity(productName, quantityRemoved);
                    System.out.println(output);
                    interfaceMenu();
                } else {
                    System.out.println("Unable to find the depot specified. Returning to main menu...");
                    interfaceMenu();
                }
            }
        }
    }

    private void listDepots() {
        if (depot1 == null && depot2 == null) {
            System.out.println("No depots exist");
            interfaceMenu();
        }
//      List the depot names and the quantity of products stored inside
        if (depot1.getName() != null)
            System.out.println("Depot " + depot1.getName() + " has " + depot1.getNumberOfProductsStored() + " products.\n");
        if (depot2.getName() != null)
            System.out.println("Depot " + depot2.getName() + " has " + depot2.getNumberOfProductsStored() + " products.\n");
        interfaceMenu();
    }

    private void listProductsInDepot() {
        Scanner keyboard = new Scanner(System.in);
        String depot1Name = depot1.getName();
        String depot2Name = depot2.getName();
        String depotNameInput;

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

    private void searchProductInDepot() {
        Scanner keyboard = new Scanner(System.in);
        String productNameInput;

        System.out.println("Specify the product name: ");
        productNameInput = keyboard.nextLine();

        if (depot1.searchExistingProduct(productNameInput).equals("not found") && depot2.searchExistingProduct(productNameInput).equals("not found")) {
            System.out.println("No product found in any depot.");
            interfaceMenu();
        } else if (!depot1.searchExistingProduct(productNameInput).equals("not found")) {
            System.out.println(depot1.searchExistingProduct(productNameInput));
            interfaceMenu();
        } else {
            System.out.println(depot2.searchExistingProduct(productNameInput));
            interfaceMenu();
        }
    }

    private void cumulativeValueInDepot() {
        Scanner keyboard = new Scanner(System.in);
        String depot1Name = depot1.getName();
        String depot2Name = depot2.getName();
        String depotNameInput;

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
            System.out.println("Depot " + depot1Name + " has cumulative product value $" + depot1.depotValue());
            interfaceMenu();
        } else {
            System.out.println("Depot " + depot2Name + " has cumulative product value $" + depot2.depotValue());
            interfaceMenu();
        }
    }
}
