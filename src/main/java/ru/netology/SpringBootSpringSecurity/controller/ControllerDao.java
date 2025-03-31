package ru.netology.SpringBootSpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.SpringBootSpringSecurity.model.Person;
import ru.netology.SpringBootSpringSecurity.service.ServiceDao;


import java.util.List;
import java.util.Optional;

@RestController
public class ControllerDao {

    private ServiceDao serviceDao;

    public ControllerDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return serviceDao.getPersons(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getAge(@RequestParam("age") int age) {
        return serviceDao.getAge(age);
    }

    @GetMapping("/persons/by-fullname")
    public Optional<Person> getNameSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return serviceDao.getNameSurname(name, surname);
    }
}