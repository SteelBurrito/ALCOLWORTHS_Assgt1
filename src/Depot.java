public class Depot {
    private String name;
    private Product product1, product2, product3;

    public String getName(){
        return name;
    }

    public String getProduct1NameInDepot(){
        String product1Name = product1.getName();
        return product1Name;
    }

    public String getProduct2NameInDepot(){
        String product2Name = product2.getName();
        return product2Name;
    }

    public String getProduct3NameInDepot(){
        String product3Name = product3.getName();
        return product3Name;
    }

    public double getProduct1price(){
        double product1Price = product1.getPrice();
        return  product1Price;
    }

    public double getProduct2price(){
        double product2Price = product2.getPrice();
        return  product2Price;
    }

    public double getProduct3price(){
        double product3Price = product3.getPrice();
        return  product3Price;
    }

    public double getProduct1Weight(){
        double product1Weight = product1.getWeight();
        return product1Weight;
    }

    public double getProduct2Weight(){
        double product2Weight = product2.getWeight();
        return product2Weight;
    }

    public double getProduct3Weight(){
        double product3Weight = product3.getWeight();
        return product3Weight;
    }

    public int getProduct1Quantity(){
        int product1Quantity = product1.getQuantity();
        return product1Quantity;
    }

    public int getProduct2Quantity(){
        int product2Quantity = product2.getQuantity();
        return product2Quantity;
    }

    public int getProduct3Quantity(){
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


    public String searchExistingProduct(){
        String productName = "empty";
        if (product1 != null){
            productName = product1.getName();
            return productName;
        }
        if (product2 != null){
            productName = product2.getName();
            return productName;
        }
        if (product3 != null){
            productName = product3.getName();
            return productName;
        }
        return productName;
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

    //add other methods
    public void setName(String sName){
        name = sName;
    }
}
