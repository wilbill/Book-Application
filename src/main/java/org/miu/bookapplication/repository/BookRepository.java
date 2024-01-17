package org.miu.bookapplication.repository;

import org.miu.bookapplication.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface BookRepository extends MongoRepository<Book, String> {
}
