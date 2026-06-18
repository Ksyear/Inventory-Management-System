package shop;

import java.util.*;

public class ShopManager {
    Scanner scanner = new Scanner(System.in);
    List<Product> Products = new ArrayList<>();
    Map<String, Product> nameMap = new HashMap<>();
    Set<String> categorySet = new HashSet<>();
    Map<Integer, Product> priceMap = new HashMap<>();
    Map<Integer, Product> stockMap = new HashMap<>();
    Map<Boolean, Product> isSoldOutMap = new HashMap<>();

    String productId;
    String name;
    String category;
    int price;
    int stock;
    boolean soldOut;
    String newString;
    int newInt;
    boolean newBoolean;
    int sum;
    int count;
    double average;

    public void addProduct(String productId, String name, String category, int price, int stock, boolean soldOut){
        Product product = new Product(productId, name, category, price, stock, soldOut);
        Products.add(product);
        nameMap.put(product.name(), product);
        categorySet.add(product.category());
        priceMap.put(product.price(), product);
        stockMap.put(product.stock(), product);
        isSoldOutMap.put(product.soldOut(), product);
    }

    public void removeProduct(String name){
        Product product = nameMap.get(name);
        nameMap.remove(product.name(), product);
//        categorySet.remove(product.category());  근데 이거 하면 안에 중복되던 애들꺼도 지움
        priceMap.remove(product.price(), product);
        stockMap.remove(product.stock(), product);
        isSoldOutMap.put(product.soldOut(), product);
        Products.remove(product);
    }

    public void setName(){
        Product product = getName();
        productId = product.getId();
        name = product.getName();
        category = product.getCategory();
        price = product.getPrice();
        stock = product.getStock();
        soldOut = product.isSoldOut();
        System.out.print("수정할 값을 입력 하시오: ");
        newString = scanner.next();
        removeProduct(name);
        addProduct(productId, newString, category, price, stock, soldOut);
    }

    public void setCategory(){
        Product product = getName();
        productId = product.getId();
        name = product.getName();
        category = product.getCategory();
        price = product.getPrice();
        stock = product.getStock();
        soldOut = product.isSoldOut();
        System.out.print("수정할 값을 입력 하시오: ");
        newString = scanner.next();
        removeProduct(name);
        addProduct(productId, name, newString, price, stock, soldOut);
    }

    public void setPrice(){
        Product product = getName();
        productId = product.getId();
        name = product.getName();
        category = product.getCategory();
        price = product.getPrice();
        stock = product.getStock();
        soldOut = product.isSoldOut();
        System.out.print("수정할 값을 입력 하시오: ");
        newInt = scanner.nextInt();
        removeProduct(name);
        addProduct(productId, name, category, newInt, stock, soldOut);
    }

    public void setStock(){
        Product product = getName();
        productId = product.getId();
        name = product.getName();
        category = product.getCategory();
        price = product.getPrice();
        stock = product.getStock();
        soldOut = product.isSoldOut();
        System.out.print("수정할 값을 입력 하시오: ");
        newInt = scanner.nextInt();
        removeProduct(name);
        addProduct(productId, name, category, price, newInt, soldOut);
    }

    public void setSoldOut(){
        Product product = getName();
        productId = product.getId();
        name = product.getName();
        category = product.getCategory();
        price = product.getPrice();
        stock = product.getStock();
        soldOut = product.isSoldOut();
        System.out.print("수정할 값을 입력 하시오: ");
        newBoolean = scanner.nextBoolean();
        removeProduct(name);
        addProduct(productId, name, category, price, stock, newBoolean);
    }

    public void printAll(){
        for(Product product: Products){
            System.out.println(product);
        }
    }

    public Product getName(){
        System.out.println("상품명을 입력하시오: ");
        name = scanner.next();
        return nameMap.get(name);
    }

    public void getCategory(){
        System.out.println("카테고리를 입력하시오: ");
        category = scanner.next();
        for(Product product: Products){
            if(product.getCategory().equals(category)){
                System.out.println(product);
            }
        }
    }

    public Product getPrice(){
        System.out.println("가격을 입력하시오: ");
        price = scanner.nextInt();
        return priceMap.get(price);
    }

    public Product getStock(){
        System.out.println("재고을 입력하시오: ");
        stock = scanner.nextInt();
        return stockMap.get(stock);
    }

    public Product getSoldOut(){
        return isSoldOutMap.get(true);
    }

    public void category(){
        for (String category : categorySet) {
            for (Product product : Products) {
                if (Objects.equals(category, product.getCategory())) {
                    System.out.println(product);
                }
            }
        }
    }

    public void price(){
        Map<Integer, Product> sortPriceMap = new TreeMap<>(priceMap);
        for (Product product : sortPriceMap.values()) {
            System.out.println(product);
        }
    }

    public void stock() {
        System.out.println("재고를 입력하시오: ");
        stock = scanner.nextInt();
        for (Product product : Products) {
            if(product.getStock() <= stock){
                System.out.println(product);
            }
        }
    }

    public void averagePrice(){
        for (String category : categorySet) {
            for(Product product: Products) {
                if (product.getCategory().equals(category)) {
                    sum += product.getPrice();
                    count++;
                }
            }
            average = (double) sum / count;
            System.out.println(category + "의 평균 값: " + average);
            sum=0;
            count=0;
        }
    }

}
