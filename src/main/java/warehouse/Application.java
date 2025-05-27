package warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import warehouse.model.ProductData;
import warehouse.model.Warehouse;
import warehouse.repository.ProductRepository;
import warehouse.repository.WarehouseRepository;
import warehouse.repository.WarehouseRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private WarehouseRepository warehouseRepository;
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		warehouseRepository.deleteAll();

		Warehouse warehouse1 = new Warehouse("67e426623b15a06514fee5e6", "Lager Berlin", "Berlin");
		Warehouse warehouse2 = new Warehouse("67e426623b15a06514fee5e5", "Lager München", "München");

		warehouseRepository.save(warehouse1);
		warehouseRepository.save(warehouse2);

		productRepository.save(new ProductData("67e426623b15a06514fee5e5", "00-443175", "Bio Orangensaft Sonne", "Getränk", 2500));
		productRepository.save(new ProductData("67e426623b15a06514fee5e5", "00-871895", "Bio Apfelsaft Gold", "Getränk", 3420));
		productRepository.save(new ProductData("67e426623b15a06514fee5e6", "03-893173", "Staubsaugerbeutel", "Reinigung", 7390));
	}
}
