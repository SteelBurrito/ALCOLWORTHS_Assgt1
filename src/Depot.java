// Name: Antonio Kevin Christophorus
// ID: 3201094

public class Depot {
    private String name;
    private Product productArr[] = new Product[5];

    public String getName(){
        return name;
    }

    public void initializeProductArr() {
        for (int i = 0; i < productArr.length; i++) {
            productArr[i] = new Product();
        }
    }

    public String addProductArr(String n, double p, double w, int q) {
        for (int i = 0; i < productArr.length; i++) {
            if (productArr[i].getName() == null) {
                productArr[i].setProduct(n, p, w, q);
                return ("Product " + n + " successfully added \n");
            }
        }
        return ("Unable to add more product as depot already contained 5 products");
    }

    public String searchExistingProductArr(String n) {
        for (int i = 0; i < productArr.length; i++) {
            if (productArr[i].getName() != null) {
                if (productArr[i].getName().equals(n))
                    return ("Product " + productArr[i].getName() + " exists in depot " + name + ", slot " + i + " of " + productArr.length);
            }
        }
        return ("not found");
    }

    public void updateProductQuantity(String productNameInput, int q) {
        for (int i = 0; i < productArr.length; i++) {
            if (productArr[i].getName().equals(productNameInput)) {
                productArr[i].setQuantity(q);
            }
        }
    }

    public String removeProductQuantity(String productNameInput, int q) {
        for (int i = 0; i < productArr.length; i++) {
            if (productArr[i].getName().equals(productNameInput)) {
                productArr[i].decreaseQuantity(q);
                if (productArr[i].getQuantity() == 0)
                    productArr[i] = null;
                return (q + " item(s) of product " + productNameInput + " removed from depot " + name);
            }
        }
        return ("no product is removed");
    }

    public int getQuantityOfProductArr() {
        int quantity = 0;
        for (int i = 0; i < productArr.length; i++) {
            if (productArr[i].getName() != null) {
                quantity++;
            }
        }
        return quantity;
    }

    public String[] productDetail() {
        String[] productList = new String[5];
        for (int i = 0; i < productArr.length; i++) {
            if (productArr[i].getName() != null) {
                productList[i] = "Product " + productArr[i].getName() + " has price " + productArr[i].getPrice() +
                        ", weight " + productArr[i].getWeight() + "KG, and quantity " + productArr[i].getQuantity();
            }

        }
        return productList;
    }

    public double depotValueArr() {
        double totalValue = 0;
        for (int i = 0; i < productArr.length; i++) {
            if (productArr[i].getName() != null) {
                totalValue += (productArr[i].getPrice() * productArr[i].getQuantity());
            }
        }
        return totalValue;
    }

    public void setName(String sName){
        name = sName;
    }
}
