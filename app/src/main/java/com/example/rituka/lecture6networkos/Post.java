package com.example.rituka.lecture6networkos;

/**
 * Created by rituka on 2/10/17.
 */

public class Post {
    Integer id;
    String title;

    public Post(Integer id, String title){
        this.id=id;
        this.title=title;
    }

    public Integer getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

}
