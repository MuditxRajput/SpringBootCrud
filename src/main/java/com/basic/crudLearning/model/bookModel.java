package com.basic.crudLearning.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class bookModel {
    @Id
    private String id;
    private String title;
    private String author;
    private String isbn;

    public bookModel(String title,String author,String isbn)
    {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
    }
    // getter and setter

    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return  author;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public void setTitle(String title)
    {
        this.title= title;
    }

    public void setAuthor(String author)
    {
        this.author=author;
    }
    public void setIsbn(String isbn)
    {
            this.isbn =isbn;
    }

}
