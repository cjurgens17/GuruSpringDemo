package guru.springframework.Spring5webapp.repos;

import guru.springframework.Spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {


}
