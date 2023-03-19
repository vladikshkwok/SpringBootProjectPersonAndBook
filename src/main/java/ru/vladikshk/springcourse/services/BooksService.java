package ru.vladikshk.springcourse.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vladikshk.springcourse.models.Book;
import ru.vladikshk.springcourse.models.Person;
import ru.vladikshk.springcourse.repositories.BooksRepository;
import ru.vladikshk.springcourse.repositories.PeopleRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepository booksRepository;
    private final PeopleRepository peopleRepository;

    public BooksService(BooksRepository booksRepository, PeopleRepository peopleRepository) {
        this.booksRepository = booksRepository;
        this.peopleRepository = peopleRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public Book findOne(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setId(id);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    @Transactional
    public void release(int id) {
        booksRepository.findById(id).ifPresent(value -> value.setPerson(null));
    }

    @Transactional
    public void assign(int id, Person person) {
        peopleRepository.findById(person.getId())
                .ifPresent(person1 -> booksRepository.findById(id).ifPresent(value -> value.setPerson(person1))
        );
    }
}
