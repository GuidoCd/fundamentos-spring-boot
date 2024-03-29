package com.fundamentosplatzi.springboot.fundamentos.Entity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_post", nullable = false, unique = true)
    private Long Id;

    @Column(name = "description", length = 255)
    private String descripcion;

    @ManyToOne
    private User user;

    public Post(){

    }

    public Post(String descripcion, User user) {
        this.descripcion = descripcion;
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Id=" + Id +
                ", descripcion='" + descripcion + '\'' +
                ", user=" + user +
                '}';
    }
}
