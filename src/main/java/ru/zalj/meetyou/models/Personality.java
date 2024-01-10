package ru.zalj.meetyou.models;

import jakarta.persistence.*;

@Entity
@Table(name = "personalitys")
public class Personality {

    @Id
    private Long id;

    @Lob
    @Column(name = "bytes")
    private byte[] bytes;

    @Column(name = "name")
    private String name;

    public Personality() {

    }

    public Personality(Long id, byte[] bytes, String name) {
        this.id = id;
        this.bytes = bytes;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public String getName() {
        return name;
    }
}
