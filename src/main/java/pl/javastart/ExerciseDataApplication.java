package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.dao.DeviceDao;
import pl.javastart.model.Category;
import pl.javastart.model.Client;
import pl.javastart.model.Device;

@SpringBootApplication
public class ExerciseDataApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(ExerciseDataApplication.class, args);
        DeviceDao deviceDao = ctx.getBean(DeviceDao.class);

        Device device = new Device();
        device.setName("Wiertarka udarowa");
        device.setDescription("Wiertarka udarowa o dużej mocy");
        device.setPrice(80);
        device.setQuantity(5);

        Category category = new Category();
        category.setName("Elektronarzędzia");
        category.setDescription("Wiertarki, szlifierki, młoty udarowe");

        Client customer = new Client();
        customer.setFirstName("Jan");
        customer.setLastName("Kowalski");
        customer.setPesel("90908765123");
        customer.setIdentityNumber("ABC678123");

        device.setCategory(category);
        device.addClient(customer);

        deviceDao.save(device);
    }
}
