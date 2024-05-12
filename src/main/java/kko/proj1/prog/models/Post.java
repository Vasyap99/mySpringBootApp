package kko.proj1.prog.models;

/*import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;*/


import jakarta.persistence.*;

@Entity
public class Post {
    public Post(){}
    public Post(String title,String anons,String full_text){
        this.title=title;
        this.full_text=full_text;
        this.anons=anons;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    String title,anons,full_text;

    int views;
}
