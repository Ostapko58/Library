package com.onyshkiv.entity;

import java.util.Objects;

public class Author extends Entity{
    private int authorId;
    private String name;

    public Author() {}
    public Author(int authorId, String name) {
        this.authorId=authorId;
        this.name = name;
    }


    public Author(String name) {
        this.authorId=0;
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorId(int authorId){this.authorId=authorId;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return name.equals(author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                '}';
    }
}
