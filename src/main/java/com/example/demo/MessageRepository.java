package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MessageRepository extends CrudRepository<Message, Long> {
//    Iterable<Message> findByTitle(String title);
//    Message findByTitle(String title);
//    sets cannot have duplicates
// Lists can hold different types of objects
    ArrayList<Message> findByTitle(String title);
}