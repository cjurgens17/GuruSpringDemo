package guru.springframework.Spring5webapp.repos;

import guru.springframework.Spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {

}
