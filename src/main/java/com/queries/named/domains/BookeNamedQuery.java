package com.queries.named.domains;
import javax.persistence.*;

import org.springframework.stereotype.Component;
@NamedNativeQueries({
	@NamedNativeQuery(name = "Book.findAllNative",
            query = "SELECT * FROM book b ORDER BY b.title DESC",
            resultClass = Book.class),
    @NamedNativeQuery(name = "Book.findByIsbnNative",
            query = "SELECT * FROM book b WHERE b.isbn = :isbn",
            resultClass = Book.class)
})
public abstract class BookeNamedQuery {

}
