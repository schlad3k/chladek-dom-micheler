    package warehouse;

    import com.fasterxml.jackson.core.JsonProcessingException;
    import com.fasterxml.jackson.core.type.TypeReference;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import warehouse.model.ProductData;
    import warehouse.model.Warehouse;
    import warehouse.repository.ProductRepository;
    import warehouse.repository.WarehouseRepository;
    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/warehouse")
    public class WarehouseController {

        @Autowired
        private WarehouseRepository warehouseRepository;
        @Autowired
        private ProductRepository productRepository;

        @PostMapping("/add")
        public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
            return warehouseRepository.save(warehouse);
        }

        @GetMapping("/get")
        public @ResponseBody Iterable<Warehouse> getAllWarehouses() {
            System.out.println(warehouseRepository.findAll());
            return warehouseRepository.findAll();
        }

        @GetMapping(path="/{id}")
        public Warehouse getWarehouseById(@PathVariable String id) {
            System.out.println(warehouseRepository.findById(id).get());
            return warehouseRepository.findById(id).get();
        }


        @DeleteMapping(path="/delete/{id}")
        public void deleteWarehouse(@PathVariable String id) {
            warehouseRepository.deleteById(id);
        }

        @GetMapping("/products/{id}")
        public @ResponseBody ProductData getProductDataById(@PathVariable String id) {
            return productRepository.findById(id).get();
        }

        @GetMapping("/products")
        public List<ProductData> getAllProducts() throws JsonProcessingException {
            List<ProductData> products = productRepository.findAll();
            System.out.println("Gefundene Produkte: " + products);// Debug-Print
            return products;
        }

        @DeleteMapping("/products/delete/{id}")
        public void deleteProduct(@PathVariable String id) {
            warehouseRepository.findById(productRepository.findById(id).get().getProductID()).get().deleteProduct(productRepository.findById(id).get());
            productRepository.deleteById(id);
        }
        @PostMapping("/products/add")
        public ProductData createProduct(@RequestBody ProductData productData) {
            System.out.println(warehouseRepository.findById("67e426623b15a06514fee5e5").get().addProduct(productData));
            System.out.println(warehouseRepository.findById("67e426623b15a06514fee5e5").get());
            warehouseRepository.findById(productData.getWarehouseID()).get().addProduct(productData);
            return productRepository.save(productData);
        }

    }
