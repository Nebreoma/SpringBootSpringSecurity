package ru.netology.SpringBootSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ru.netology.SpringBootSpringSecurity.model.Person;
import ru.netology.SpringBootSpringSecurity.repository.RepositoryDao;


@Service
public class ServiceDao {
    private final RepositoryDao repositoryDao;

    public ServiceDao(RepositoryDao repository) {
        this.repositoryDao = repository;
    }

    public List<Person> getPersons(String city) {
        return repositoryDao.findByCityOfLiving(city);
    }

    public List<Person> getAge(int age) {
        return repositoryDao.findByAgeLessThanOrderByAge(age);
    }

    public Optional<Person> getNameSurname(String name, String surname) {
        return repositoryDao.findByNameAndSurname(name, surname);
    }
}