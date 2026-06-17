package shop;

public record Product(
        String productId,
        String name,
        String category,
        int price,
        int stock,
        boolean soldOut)
{
    public String getId()
    {
        return productId;
    }
    public String getName()
    {
        return name;
    }
    public String getCategory()
    {
        return category;
    }
    public int getPrice()
    {
        return price;
    }
    public int getStock()
    {
        return stock;
    }
    public boolean isSoldOut()
    {
        return soldOut;
    }
}
