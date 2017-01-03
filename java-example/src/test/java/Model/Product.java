package Model;

public class Product {
    private String name;
    private String originalPrice;
    private String salePrice;


    public String getName() {
        return name;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public Product withName(String name) {
        this.name = name;
        return this;
    }

    public Product withOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
        return this;
    }

    public Product withSalePrice(String salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", originalPrice='" + originalPrice + '\'' +
                ", salePrice='" + salePrice + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (originalPrice != null ? !originalPrice.equals(product.originalPrice) : product.originalPrice != null)
            return false;
        return salePrice != null ? salePrice.equals(product.salePrice) : product.salePrice == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (originalPrice != null ? originalPrice.hashCode() : 0);
        result = 31 * result + (salePrice != null ? salePrice.hashCode() : 0);
        return result;
    }
}
