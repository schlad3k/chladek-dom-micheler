package warehouse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "warehouses")
public class Warehouse {
    @Id
    private String id;
    private String name;
    private String location;
    private List<ProductData> products;

    public Warehouse(String id, String name, String location) {
        this.name = name;
        this.location = location;
        this.id = id;
        products = new ArrayList<ProductData>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(ProductData productData : products) {
            builder.append(productData.toString());
        }
        return "Warehouse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", products=" + builder.toString() +
                '}';
    }

    public boolean addProduct(ProductData product) {
        return products.add(product);
    }
    public boolean deleteProduct(ProductData product) {
        return products.remove(product);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<ProductData> getProducts() {
        return products;
    }

    public void setProducts(List<ProductData> products) {
        this.products = products;
    }
}
