package shop;

import java.util.*;

public class ShopManager {
    Scanner scanner = new Scanner(System.in);
    List<Product> Products = new ArrayList<>();
    Map<String, Product> nameMap = new HashMap<>();
    Map<String, Product> categoryMap = new HashMap<>();
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
        categoryMap.put(product.category(), product);
        priceMap.put(product.price(), product);
        stockMap.put(product.stock(), product);
        isSoldOutMap.put(product.soldOut(), product);
    }

    public void removeProduct(String name){
        Product product = nameMap.get(name);
        nameMap.remove(product.name(), product);
        categoryMap.remove(product.category(), product);
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
            System.out.println(product.toString());
        }
    }

    public Product getName(){
        System.out.println("상품명을 입력하시오: ");
        name = scanner.next();
        return nameMap.get(name);
    }

    public Product getCategory(){
        System.out.println("카테고리를 입력하시오: ");
        category = scanner.next();
        return categoryMap.get(category);
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

    // 카테고리 별 상품 정보  출력
    public void category(){
        for(Product product: categoryMap.values()){
            System.out.println(product.toString());
        }
    }

    public void price(){
        for(Product product: priceMap.values()){
            System.out.println(product.toString());
        }
    }

    public void stock() {
        System.out.println("재고를 입력하시오: ");
        stock = scanner.nextInt();
        for(int i = 0; i < stock; i++){
            if(stockMap.containsKey(stock)){
                System.out.println(stockMap.get(stock));
            }
        }
    }

    public void averagePrice(){
        for (String category : categoryMap.keySet()) {
            for(Product product: Products) {
                if (categoryMap.containsKey(category)) {
                    sum += categoryMap.get(category).getPrice();
                    count++;
                }
            }
            average = (double) sum /count;
            System.out.println(category + "의 평균 값: " + average);
            count=0;
        }
    }

}
