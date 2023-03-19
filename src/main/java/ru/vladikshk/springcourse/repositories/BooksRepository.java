package ru.vladikshk.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vladikshk.springcourse.models.Book;

public interface BooksRepository extends JpaRepository<Book, Integer> {
}
