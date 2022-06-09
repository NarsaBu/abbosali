package ru.narsabu.abbosali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.narsabu.abbosali.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM message ORDER BY random() LIMIT 1")
    Message getRandomMessage();
}
