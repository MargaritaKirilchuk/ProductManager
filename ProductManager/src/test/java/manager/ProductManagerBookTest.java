package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerBookTest {
    private Book firstBook = new Book (1,"Война и Мир", 1000, "Л.Н.Толстой");
    private Book secondBook = new Book(2, "Капитанская дочка", 1000, "А.С.Пушкин");
    private Book thirdBook = new Book(3, "Рассказы", 1000, "А.П.Чехов");
    private Book fourthBook = new Book(4, "Мастер и Маргарита", 1000, "М.А.Булгаков");
    private Book fifthBook = new Book(5, "Сборник стихов", 1000, "С.А.Есенин");


    @Test
    void searchByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(fifthBook);

        Product[] actual = manager.searchBy("Мастер и Маргарита");
        Product[] expected = new Book[] {fourthBook};

        assertArrayEquals (expected,actual);
    }

    @Test
    void searchByAuthor(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(fifthBook);

        Product[] actual = manager.searchBy("М.А.Булгаков");
        Product[] expected = new Book[] {fourthBook};

        assertArrayEquals (expected,actual);
    }

    @Test
    void searchBookNoExist(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(fifthBook);

        Product[] actual = manager.searchBy("Тихий Дон");
        Product[] expected = new Book[] {};

        assertArrayEquals (expected,actual);

    }
}