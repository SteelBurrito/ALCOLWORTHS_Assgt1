public class Depot {
    private String name;
    private Product product1, product2, product3;
    private Product productArr[] = new Product[5];

    public String getName(){
        return name;
    }

    private String getProduct1NameInDepot() {
        return product1.getName();
    }

    private String getProduct2NameInDepot() {
        return product2.getName();
    }

    private String getProduct3NameInDepot() {
        return product3.getName();
    }

    private double getProduct1price() {
        return product1.getPrice();
    }

    private double getProduct2price() {
        return product2.getPrice();
    }

    private double getProduct3price() {
        return product3.getPrice();
    }

    private double getProduct1Weight() {
        return product1.getWeight();
    }

    private double getProduct2Weight() {
        return product2.getWeight();
    }

    private double getProduct3Weight() {
        return product3.getWeight();
    }

    private int getProduct1Quantity() {
        return product1.getQuantity();
    }

    private int getProduct2Quantity() {
        return product2.getQuantity();
    }

    private int getProduct3Quantity() {
        return product3.getQuantity();
    }

    public void initializeProductArr() {
        for (int i = 0; i < productArr.length; i++) {
            productArr[i] = new Product();
        }
    }

    public String addProduct(String n, double p, double w, int q) {
//      Check if there are empty product objects and add a new product if there is one.
//      If all product objects has a product, return a string
        String output;
        if (product1 == null) {
            product1 = new Product();
            product1.setProduct(n,p,w,q);
            return output = "Product " + n + " successfully added";
        }
        else if (product2 == null) {
            product2 = new Product();
            product2.setProduct(n,p,w,q);
            return output = "Product " + n + " successfully added";
        } else if (product3 == null) {
            product3 = new Product();
            product3.setProduct(n,p,w,q);
            return output = "Product " + n + " successfully added";
        } else {
            return output = "Unable to add more product as depot already contained 3 products";
        }
    }

    public String addProductArr(String n, double p, double w, int q) {
        for (int i = 0; i < productArr.length; i++) {
            if (productArr[i].getName() == null) {
//                productArr[i] = new Product();
                productArr[i].setProduct(n, p, w, q);
                return ("Product " + n + " successfully added \n");
            }
        }
        return ("Unable to add more product as depot already contained 5 products");
    }


    public String searchExistingProduct(String n) {
        String p1, p2, p3;

//      assigning the product.getname() to a variable to avoid nullpointerexception
        if (product1 == null)
            p1 = "empty";
        else
            p1 = product1.getName();

        if (product2 == null)
            p2 = "empty";
        else
            p2 = product2.getName();

        if (product3 == null)
            p3 = "empty";
        else
            p3 = product3.getName();

        if (n.equals(p1)) {
            return ("Product " + p1 + " exists in depot " + name + " with price $" + getProduct1price() + ", weight " + getProduct1Weight() + " and quantity " + getProduct1Quantity());
        }
        if (n.equals(p2)) {
            return ("Product " + p2 + " exists in depot " + name + " with price $" + getProduct2price() + ", weight " + getProduct2Weight() + " and quantity " + getProduct3Quantity());
        }
        if (n.equals(p3)) {
            return ("Product " + p3 + " exists in depot " + name + " with price $" + getProduct2price() + ", weight " + getProduct2Weight() + " and quantity " + getProduct3Quantity());
        }
        return ("not found");
    }

    public String searchExistingProductArr(String n) {
        for (int i = 0; i < productArr.length; i++) {
            if (productArr[i].getName() != null) {
                if (productArr[i].getName().equals(n))
                    return ("Product " + productArr[i].getName() + " exists in depot " + name + ", slot " + i);
            }
        }
        return ("not found");
    }

    public void updateProduct(String productNameInput, int q){
       String productOne = getProduct1NameInDepot();
       String productTwo = getProduct2NameInDepot();
       String productThree = getProduct3NameInDepot();
       if (productNameInput.equals(productOne)){
            product1.setQuantity(q);
       }
       if (productNameInput.equals(productTwo)){
            product2.setQuantity(q);
       }
       if (productNameInput.equals(productThree)){
            product3.setQuantity(q);
       }
    }

    public void updateProductQuantity(String productNameInput, int q) {
        for (int i = 0; i < productArr.length; i++) {
            if (productArr[i].getName().equals(productNameInput)) {
                productArr[i].setQuantity(q);
            }
        }
    }

    public String deleteProduct(String n) {
//      checks if product exists and if it does removeAnItem() will decrement Product quantity.
//      once removeAnItem() is ran if Product quantity is zero the Product instance is deleted.
        String output = n;
        if (n.equals(product1.getName())) {
            product1.removeAnItem();
            if (product1.getQuantity() == 0)
                product1 = null;
            return output = "One item of Product " + n + " removed from depot " + name;
        }
        if (n.equals(product2.getName())) {
            product2.removeAnItem();
            if (product2.getQuantity() == 0)
                product2 = null;
            return output = "One item of Product " + n + " removed from depot " + name;
        }
        if (n.equals(product3.getName())) {
            product3.removeAnItem();
            if (product3.getQuantity() == 0)
                product3 = null;
            return output = "One item of Product " + n + " removed from depot " + name;
        }
        return output;
    }

    public int getNumberOfProductsStored() {
        int quantity = 0;
        if (product1 != null)
            quantity++;
        if (product2 != null)
            quantity++;
        if (product3 != null)
            quantity++;
        return quantity;
    }

    public String getProduct1() {
        if (product1 != null)
            return ("Product " + getProduct1NameInDepot() + " has price $" + getProduct1price() + " weight " + getProduct1Weight() + "kg, and quantity " + getProduct1Quantity() + "\n");
        return null;
    }

    public String getProduct2() {
        if (product2 != null)
            return ("Product " + getProduct2NameInDepot() + " has price $" + getProduct2price() + " weight " + getProduct2Weight() + "kg, and quantity " + getProduct2Quantity() + "\n");
        return null;
    }

    public String getProduct3() {
        if (product3 != null)
            return ("Product " + getProduct3NameInDepot() + " has price $" + getProduct3price() + " weight " + getProduct3Weight() + "kg, and quantity " + getProduct3Quantity() + "\n");
        return null;
    }

    public double depotValue() {
        double totalValue = 0;
        if (product1 != null)
            totalValue += (getProduct1price() * getProduct1Quantity());
        if (product2 != null)
            totalValue += (getProduct2price() * getProduct2Quantity());
        if (product3 != null)
            totalValue += (getProduct3price() * getProduct3Quantity());
        return totalValue;
    }

    //add other methods
    public void setName(String sName){
        name = sName;
    }
}
