package be.heh.test_spring;

import java.util.List;

public interface IBookRepository {

    List<Book> findByReader(String reader);
    void save (Book b);

}
