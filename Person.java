package ShoppingSpree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Person {
    private String name;
    private double money;
    private List <Product> products;

    public Person(String name, double money){
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw  new IllegalArgumentException("Money cannot be negative");

        }
        this.money = money;
    }

    private void setName(String name) {
        if (name == null || name.contains(" ")){
            throw  new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void buyProduct(Product  product){
        if (this.money >= product.getCost()){
            payProduct(product);
            this.products.add(product);
        }
        else {
            throw new IllegalArgumentException(String.format("%s can't afford %s",this.name,product.getName()));
        }

    }

    private void payProduct(Product product) {
            this.money -= product.getCost();


    }

    public void getPurchases() {
        System.out.print(this.getName()+" - ");
        StringBuilder result = new StringBuilder();
        if (this.products.isEmpty()){
            System.out.println("Nothing bought");

        }
        else {
            this.products.forEach(v ->{
                result.append(v.getName()).append(", ");
            });
            System.out.println(result.toString().substring(0,result.length()-2));
        }
    }
}
