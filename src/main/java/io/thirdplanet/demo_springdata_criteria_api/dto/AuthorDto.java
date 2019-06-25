package io.thirdplanet.demo_springdata_criteria_api.dto;



public class AuthorDto{
 
    private Integer id ;
    private String familyName;
    private String name;
    private Integer bookId; 


    public AuthorDto(Integer id,
                     String familyName,
                     String name,
                     Integer bookId){
                         this.id = id ;
                         this.familyName = familyName ;
                         this.name  = name ;
                         this.bookId = bookId ;
                     }

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