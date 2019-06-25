package io.thirdplanet.demo_springdata_criteria_api.dto;

public class BookDto {
    private String label ;
    private String authorFamilyName ;
    private String authorName;
    private Integer pageCount ;

    public BookDto(String label,
                   String authorFamilyName,
                   String authorName,
                   String pageCount){

    }

    public void setLabel(String label){
        this.label = label ;
    }
    public String getLabel(){
        return label ;
    }

    public void setAuthorFamilyName(String authorFamilyName){
        this.authorFamilyName = authorFamilyName ;
    }
    public String getAuthorFamilyName(){
        return authorFamilyName ;
    }

    public void setAuthorName(String authorName){
        this.authorName = authorName ;
    }
    public String getAuthorName(){
        return authorName ;
    }

    public void setPageCount(Integer pageCount){
        this.pageCount = pageCount ;
    }
    public Integer getPageCount(){
        return pageCount ;
    }




}