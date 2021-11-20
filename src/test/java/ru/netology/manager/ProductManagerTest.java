package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();

    private Book goodBook8 = new Book(8, "Good Book8", 107, "Дмитрий Кравченко");
    private Book book26 = new Book(35, "Book26", 125, "Федор Иванов");
    private Book book53 = new Book(26, "Book53", 350, "Вася Пупкин");
    private Book book35 = new Book(17, "Book35", 260, "Сидор Сидоров");

    private Smartphone samsungN = new Smartphone(17, "Galaxy Note 20 ultra", 85000, "Samsung");
    private Smartphone sony = new Smartphone(26, "xs", 12000, "Sony");
    private Smartphone samsungS = new Smartphone(35, "Galaxy S7Edge", 15000, "Samsung");
    private Product product = new Product(8, "Xiaomi", 24000);

    @Test
    public void shouldSave1Book() {

        manager.add(goodBook8);

        Product[] expected = new Product[]{goodBook8};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearch() {
        String textForSearch = "Book26";

        manager.add(book26);
        manager.add(book53);

        manager.searchById(textForSearch);

        Product[] expected = new Product[]{book26,};
        Product[] actual = manager.searchById(textForSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchAuthor() {
        String textForSearch = "Сидоров";


        manager.add(book35);
        manager.add(book53);

        manager.searchById(textForSearch);

        Product[] expected = new Product[]{book35};
        Product[] actual = manager.searchById(textForSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchName() {
        String textForSearch = "xs";

        manager.add(samsungN);
        manager.add(sony);
        manager.add(samsungS);

        manager.searchById(textForSearch);

        Product[] expected = new Product[]{sony};
        Product[] actual = manager.searchById(textForSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchBrand() {
        String textForSearch = "Note 20";

        manager.add(samsungN);
        manager.add(sony);
        manager.add(samsungS);

        manager.searchById(textForSearch);

        Product[] expected = new Product[]{samsungN};
        Product[] actual = manager.searchById(textForSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchByAuthorInSmartphoneEndBooks() {
        String textForSearch = "Вася";

        manager.add(book53);
        manager.add(samsungN);
        manager.add(samsungS);

        manager.searchById(textForSearch);

        Product[] expected = new Product[]{book53};
        Product[] actual = manager.searchById(textForSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchByBrandIsNot() {
        String textForSearch = "Xiaomi";


        manager.add(samsungN);
        manager.add(sony);
        manager.add(product);

        manager.searchById(textForSearch);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchById(textForSearch);
        assertArrayEquals(expected, actual);


    }
}
