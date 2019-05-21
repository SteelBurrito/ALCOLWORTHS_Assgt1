// Name: Antonio Kevin Christophorus
// ID: 3201094

public class Product {
    private String name;
    private double price;
    private double weight;
    private int quantity;

    //add comments
    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public Double getWeight(){
        return weight;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setProduct(String n, double p, double w, int q){
        name = n;
        price = p;
        weight = w;
        quantity = q;
    }

    public void setQuantity (int Quantity) {
        if (quantity == 0)
            quantity = Quantity;
        quantity += Quantity;
    }

    public void decreaseQuantity(int q) {
        quantity -= q;
    }
}
