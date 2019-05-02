public class Depot {
    private String name;
    private Product product1, product2, product3;

    public String getName(){
        return name;
    }

    private String getProduct1NameInDepot() {
        String product1Name = product1.getName();
        return product1Name;
    }

    private String getProduct2NameInDepot() {
        String product2Name = product2.getName();
        return product2Name;
    }

    private String getProduct3NameInDepot() {
        String product3Name = product3.getName();
        return product3Name;
    }

    public double getProduct1price(){
        double product1Price = product1.getPrice();
        return  product1Price;
    }

    private double getProduct2price() {
        double product2Price = product2.getPrice();
        return  product2Price;
    }

    private double getProduct3price() {
        double product3Price = product3.getPrice();
        return  product3Price;
    }

    public double getProduct1Weight(){
        double product1Weight = product1.getWeight();
        return product1Weight;
    }

    private double getProduct2Weight() {
        double product2Weight = product2.getWeight();
        return product2Weight;
    }

    private double getProduct3Weight() {
        double product3Weight = product3.getWeight();
        return product3Weight;
    }

    private int getProduct1Quantity() {
        int product1Quantity = product1.getQuantity();
        return product1Quantity;
    }

    private int getProduct2Quantity() {
        int product2Quantity = product2.getQuantity();
        return product2Quantity;
    }

    private int getProduct3Quantity() {
        int product3Quantity = product3.getQuantity();
        return product3Quantity;
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


    public String searchExistingProduct(String n) {
        if (n.equals(product1.getName())) {
            return ("Product " + product1.getName() + " exists in depot " + name + " with price $ " + product1.getPrice() + " and weight" + product1.getWeight() + ". Adding additional items. \n");
        }
        if (n.equals(product2.getName())) {
            return ("Product " + product2.getName() + " exists in depot " + name + " with price $ " + product2.getPrice() + " and weight" + product2.getWeight() + ". Adding additional items. \n");
        }
        if (n.equals(product3.getName())) {
            return ("Product " + product3.getName() + " exists in depot " + name + " with price $ " + product3.getPrice() + " and weight" + product3.getWeight() + ". Adding additional items. \n");
        }
        return null;
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

    //add other methods
    public void setName(String sName){
        name = sName;
    }
}
