package ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] peopleInput = scanner.nextLine().split(";");
        LinkedHashSet<Person> persons = new LinkedHashSet<>();
        List<Product> products = new ArrayList<>();
        try {
            for (int i = 0; i < peopleInput.length; i++) {

                    Person person = new Person(peopleInput[i].substring(0, peopleInput[i].indexOf("=")),
                            Double.parseDouble(peopleInput[i].substring(
                                    peopleInput[i].indexOf("=") + 1, peopleInput[i].length())));
                    persons.add(person);


            }

            String[] productInput = scanner.nextLine().split(";");
            for (int i = 0; i < peopleInput.length; i++) {

                    Product product = new Product(productInput[i].substring(0, productInput[i].indexOf("=")),
                            Double.parseDouble(productInput[i].substring(
                                    productInput[i].indexOf("=") + 1, productInput[i].length())));
                    products.add(product);



            }
            String text = scanner.nextLine();
            while (!text.equals("END")) {
                String[] line = text.split("\\s+");
                String personName = line[0];
                String productName = line[1];
                for (Person person : persons) {


                    if (person.getName().equals(personName)) {
                        for (Product product : products) {
                            if (product.getName().equals(productName)) {
                                try {
                                    person.buyProduct(product);
                                    System.out.println(personName + " bought " + productName);

                                } catch (IllegalArgumentException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            }
                        }
                    }


                }

                text = scanner.nextLine();
            }
            for (Person person : persons) {
                person.getPurchases();


            }
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }



    }
}

