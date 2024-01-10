package ru.zalj.meetyou.models;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "originalFileName")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage;
    @Lob
    @Column(name = "bytes")
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private UserProfile userProfile;

    public static Image instanceOf(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setPreviewImage(boolean previewImage) {
        isPreviewImage = previewImage;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public void setProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public Long getSize() {
        return size;
    }

    public boolean isPreviewImage() {
        return isPreviewImage;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public UserProfile getProduct() {
        return userProfile;
    }
}
