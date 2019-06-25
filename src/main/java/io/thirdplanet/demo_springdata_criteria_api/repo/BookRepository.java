package io.thirdplanet.demo_springdata_criteria_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.thirdplanet.demo_springdata_criteria_api.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}