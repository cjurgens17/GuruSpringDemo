package guru.springframework.Spring5webapp.repos;

import guru.springframework.Spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {

}
