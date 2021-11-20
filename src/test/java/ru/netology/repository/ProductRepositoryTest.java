package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;


import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book goodBook = new Book();
    private Book goodBook8 = new Book(11, "Good Book8", 1107, "Дмитрий Кравченко");
    private Book goodBook17 = new Book(117, "Good Book17 ", 2060, "Вася Пупкин");

    @Test

    public void shouldSave1Book() {
        repository.save(goodBook);

        Product[] expected = new Product[]{goodBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave8Book() {
        repository.save(goodBook8);

        Product[] expected = new Product[]{goodBook8};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave2Books() {
        repository.save(goodBook8);
        repository.save(goodBook17);

        Product[] expected = new Product[]{goodBook8, goodBook17};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveId() {
        int idRemove = 11;

        repository.save(goodBook8);
        repository.save(goodBook17);

        repository.removeById(idRemove);

        Product[] expected = new Product[]{goodBook17};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}