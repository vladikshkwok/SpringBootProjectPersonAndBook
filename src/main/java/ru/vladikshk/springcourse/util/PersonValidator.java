package ru.vladikshk.springcourse.util;//package ru.vladikshk.springcourse.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//import ru.vladikshk.springcourse.dao.PersonDAO;
//import ru.vladikshk.springcourse.models.Person;
//
//@Component
//public class PersonValidator implements Validator {
//
//    private final PersonDAO personDAO;
//
//    @Autowired
//    public PersonValidator(PersonDAO personDAO) {
//        this.personDAO = personDAO;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return Person.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        Person person = (Person) o;
//
//        // Посмотреть есть ли человек с таким же email в БД
//        if (personDAO.show(person.getEmail()).isPresent())
//            errors.rejectValue("email", "", "This email is already taken");
//
//    }
//}
