package io.thirdplanet.demo_springdata_criteria_api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String label;
    private Integer pageCount;

    public void setId(Integer id){
        this.id = id ;
    }
    public Integer getId(){
        return id ;
    }

    public void setLabel(String label){
        this.label = label ;
    }

    public String getLabel(){
        return label ;
    }

    public void setPageCount(Integer pageCount){
        this.pageCount = pageCount;
    }
    public Integer getPageCount(){
        return pageCount;
    }

}