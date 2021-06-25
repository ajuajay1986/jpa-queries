package com.queries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

//import com.queries.custom.repositories.NoteRepository;
//import com.queries.derived.repositories.UserRepository;
import com.queries.named.domains.Book;
import com.queries.named.repositories.BookRepository;

@SpringBootApplication
public class JpaQueriesApplication {
	
	 @PersistenceContext
	   private EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(JpaQueriesApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner runner(BookRepository bookRepository) {
        return args -> {
            // Like pattern
//            String pattern = "%atta%@gmail%";
//            List<User> users = userRepository.findByEmailLike(pattern);

            // pagination
//            Pageable pageable = PageRequest.of(0, 10, Sort.by("name").descending());
//            Page<User> userPage = userRepository.findByActive(true, pageable);

            // notes sorting
//            List<Note> startupNotes = noteRepository.findByTitle("startup", Sort.by("title").ascending());
//            List<Note> techNotes = noteRepository.findByTitle("tech", Sort.by("priority").descending());
//            List<Note> lengthyNotes = noteRepository.findByTitle("tech", JpaSort.unsafe("LENGTH(title)"));

            // notes pagination
//            Pageable pageable = PageRequest.of(0, 10, Sort.by("title").descending());
//            Page<Note> notePage = noteRepository.findAllNotesWithPagination(pageable);

            // create books
            bookRepository.save(new Book("Java 101", "145804", 450));
            bookRepository.save(new Book("Spring Bot", "48524", 289));

            // execute named queries with `EntityManager`
//            Query q = em.createNamedQuery("Book.findByTitleJPQL");
//            q.setParameter(1, "Java 101");
//            // execute query
//            List<Book> books = q.getResultList();
//
            // execute native sql named query
            Query q = em.createNamedQuery("Book.findAllNamedFile");
            //q.setParameter("isbn", "145804");
            // execute query
            List<Book> books = q.getResultList();

            // list all books
            //List<Book> books = bookRepository.findAllXML();

            // fetch a single book
            //Book book = bookRepository.findByIsbnNamedFile("145804");

            // multiple parameters
            //List<Book> moreBooks = bookRepository.findByTitleAndPagesGreaterThanJPQL("Spring Bot", 150);
        };
    }

}
