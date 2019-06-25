package io.thirdplanet.demo_springdata_criteria_api.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CompoundSelection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import io.thirdplanet.demo_springdata_criteria_api.domain.Author;
import io.thirdplanet.demo_springdata_criteria_api.domain.Book;
import io.thirdplanet.demo_springdata_criteria_api.dto.BookDto;

public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List findAll(String bookLabel, String authorFamilyName, String authorName) {
        /*
         * 1. Create a criteria builder using entitry manager 
         * 2. Create a criteria query result object using DTO class 
         * 3. Create roots for the associated entitry objects
         * 4. Create a list to hold your predicates
         * 5. Use your object graphs to create your predicate objects...
         * 
         */

        CriteriaBuilder cbuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = cbuilder.createQuery(BookDto.class);
        Root bookRoot = query.from(Book.class);
        Root authorRoot = query.from(Author.class);

        List filterPredicates = new ArrayList<>();
        Predicate predicateAuthor = cbuilder.equal(bookRoot.get("authorId"), authorRoot.get("id"));
        filterPredicates.add(predicateAuthor);
        if (bookLabel != null && !bookLabel.isEmpty()) {
            Predicate predicateBookLabel = cbuilder.like(bookRoot.get("label"), bookLabel);
            filterPredicates.add(predicateBookLabel);
        }else if (authorFamilyName != null && !authorFamilyName.isEmpty()){
            Predicate predicateAuthorFamilyName = cbuilder.like(authorRoot.get("familyName"), authorFamilyName);
            filterPredicates.add(predicateAuthor);
        }else if (authorName != null && !authorName.isEmpty()){
            Predicate predicateAuthorFamilyName = cbuilder.like(authorRoot.get("name"), authorName);
            filterPredicates.add(predicateAuthor);
        }
        
        query.select(cbuilder.construct(BookDto.class,
                                    bookRoot.get("label"), authorRoot.get("familyName"), authorRoot.get("name"), bookRoot.get("pageCount")))
                                    .where(cbuilder.and((Predicate[]) filterPredicates.toArray(new Predicate[0])));
                                    
        


        return entityManager.createQuery(query).getResultList();
    }


    
}