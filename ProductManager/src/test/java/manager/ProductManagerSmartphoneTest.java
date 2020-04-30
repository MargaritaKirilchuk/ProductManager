package manager;

import org.junit.jupiter.api.Test;
import repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerSmartphoneTest {
    private Smartphone firstPhone = new Smartphone(1,"Galaxy", 50000,"Samsung");
    private Smartphone secondPhone = new Smartphone(2, "iPhone11",50000, "Apple");
    private Smartphone thirdPhone = new Smartphone(3, "RedmiNote", 50000, "Xiaomi");
    private Smartphone fourthPhone = new Smartphone(4, "iPhoneX",50000,"Apple");
    private Smartphone fifthPhone = new Smartphone(5, "GalaxyNote", 50000, "Samsung");

    @Test
    void searchByName(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);
        manager.add(fourthPhone);
        manager.add(fifthPhone);

        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = new Smartphone[] {firstPhone};

        assertArrayEquals (expected,actual);
    }

    @Test
    void searchByManufacturer(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);
        manager.add(fourthPhone);
        manager.add(fifthPhone);

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Smartphone[] {secondPhone, fourthPhone};

        assertArrayEquals (expected,actual);
    }

    @Test
    void searchSmartphoneNoExist(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);
        manager.add(fourthPhone);
        manager.add(fifthPhone);

        Product[] actual = manager.searchBy("Honor");
        Product[] expected = new Smartphone[] {};

        assertArrayEquals (expected,actual);

    }

}