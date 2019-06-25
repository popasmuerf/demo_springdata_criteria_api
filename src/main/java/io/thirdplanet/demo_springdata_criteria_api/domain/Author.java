package io.thirdplanet.demo_springdata_criteria_api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Author{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String familyName;
    private String name;
    private Integer bookId; 

    public void setId(Integer id){
        this.id = id ;
    }
    public Integer getId(){
        return id ;
    }

    public void setFamilyName(String familyName){
        this.familyName = familyName ;
    }

    public String getFamilyName(){
        return familyName ;
    }

    public void setName(String name){
        this.name = name ;
    }

    public String getName(){
        return name ;
    }



    public void setBookId(Integer bookId){
        this.bookId = bookId;
    }
    public Integer getBookId(){
        return bookId;
    }

}