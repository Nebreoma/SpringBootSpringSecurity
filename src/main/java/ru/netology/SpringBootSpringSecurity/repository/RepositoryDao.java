package ru.netology.SpringBootSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.SpringBootSpringSecurity.model.Person;
import ru.netology.SpringBootSpringSecurity.model.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryDao extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAge(int age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
