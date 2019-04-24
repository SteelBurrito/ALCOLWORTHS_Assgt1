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
        int option = 0;

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

//    private void newProduct(String depot, String n,double p, double w, int q){
//        String depot1Name = depot1.getName();
//        String depot2Name = depot2.getName();
//        if (depot.equals(depot1Name)){
//            depot1.addProduct(n,p,w,q);
//            System.out.println("Product " + n + " successfully added. \n");
//            interfaceMenu();
//        }
//        if (depot.equals(depot2Name)) {
//            depot2.addProduct(n,p,w,q);
//            System.out.println("Product " + n + " successfully added. \n");
//            interfaceMenu();
//        }
//    }

    private void addProductToDepot() {
        Scanner keyboard = new Scanner(System.in);
        String depot1Name = depot1.getName();
        String depot2Name = depot2.getName();
        String depotNameInput, productName;
        double price, weight;
        int quantity;

//      assign depotname variable something to avoid nullpointerexception later
        if (depot1Name == null)
            depot1Name = "empty";
        if (depot2Name == null)
            depot2Name = "empty";

        System.out.println("Specify product name: ");
        productName = keyboard.nextLine();

        if(productName.equals(depot1.searchExistingProduct())){
            System.out.println("Product " + productName + " exists in depot " + depot1Name + " with price $ " + depot1.getProduct1price() + " and weight" + depot1.getProduct1Weight() + ". Adding additional items. \n");
            System.out.println("Please enter quantity of product to be added: ");
            quantity = keyboard.nextInt();
            while (quantity <= 0){
                System.out.println("Quantity cannot be less than equal to zero. Please re-enter product quantity:");
                quantity = keyboard.nextInt();
            }
            depot1.updateProduct(productName,quantity);
            System.out.println("Product " + productName + " updated. \n");
            interfaceMenu();
        }
        else if (productName.equals(depot2.searchExistingProduct())) {
            System.out.println("Product " + productName + " exists in depot " + depot2Name + " with price $ " + depot2.getProduct1price() + " and weight " + depot2.getProduct1Weight() + ". Adding additional items \n");
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
                depot1.addProduct(productName, price, weight, quantity);
                System.out.println("Product " + productName + " successfully added. \n");
                interfaceMenu();
            }
            if (depotNameInput.equals(depot2Name)) {
                depot2.addProduct(productName, price, weight, quantity);
                System.out.println("Product " + productName + " successfully added. \n");
                interfaceMenu();
            }
        }
    }

    private void removeProductFromDepot(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Specify product name: ");
        String productName = keyboard.nextLine();
        System.out.println("Specify depot name: ");
        String depotName = keyboard.nextLine();
//        if (depotName.equals(depot1.getName())){
//            if(productName.equals())
//        }

    }
}
