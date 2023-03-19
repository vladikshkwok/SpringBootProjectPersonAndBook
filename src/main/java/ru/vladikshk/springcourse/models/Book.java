package ru.vladikshk.springcourse.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class  Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @NotEmpty(message = "Author name should not be empty")
    @Size(min = 2, max = 200, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Author name should not be empty")
    @Size(min = 2, max = 200, message = "Name should be between 2 and 30 characters")
    @Column(name = "author_name")
    private String authorName;

    @Min(value = 1000, message = "Year of production should be more than 1000")
    @Column(name="year_of_production")
    private int yearOfProduction;

    public Book() {
    }

    public Book(String name, String authorName, int yearOfProduction) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.yearOfProduction = yearOfProduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (yearOfProduction != book.yearOfProduction) return false;
        if (!name.equals(book.name)) return false;
        return authorName.equals(book.authorName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + authorName.hashCode();
        result = 31 * result + yearOfProduction;
        return result;
    }
}

