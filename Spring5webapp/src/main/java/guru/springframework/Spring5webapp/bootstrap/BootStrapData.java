package guru.springframework.Spring5webapp.bootstrap;

import guru.springframework.Spring5webapp.model.Author;
import guru.springframework.Spring5webapp.model.Book;
import guru.springframework.Spring5webapp.model.Publisher;
import guru.springframework.Spring5webapp.repos.AuthorRepo;
import guru.springframework.Spring5webapp.repos.BookRepo;
import guru.springframework.Spring5webapp.repos.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher pub = new Publisher("CreateSpace","25 Hello Dr","SpaceJam","Washington","123456");
        publisherRepo.save(pub);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(pub);
        pub.getBooks().add(ddd);

        authorRepo.save(eric);
        bookRepo.save(ddd);
        publisherRepo.save(pub);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB","1233432");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(pub);
        pub.getBooks().add(noEJB);

        authorRepo.save(rod);
        bookRepo.save(noEJB);
        publisherRepo.save(pub);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepo.count());
        System.out.println("Publisher count: " + publisherRepo.count());
        System.out.println("Publishers Number of Books: " + pub.getBooks().size());
    }
}
