package com.bloggingapp.dto;
import java.time.LocalDateTime;

public class BlogPostDTO {
    private int postID;
    private String username, tag, title, description, email;
    private LocalDateTime timestamp;

    public void setPostID(int postID) {

        this.postID = postID;
    }

    public int getPostID() {

        return postID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTag(String tag) {

        this.tag = tag;
    }

    public String getTag() {

        return tag;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getTitle() {

        return title;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getDescription() {

        return description;
    }

    public void setTimestamp(LocalDateTime timestamp) {

        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {

        return timestamp;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "postId=" + postID +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }


    public static void main(String[] args) {
        BlogPostDTO postDTO = new BlogPostDTO();
        postDTO.setPostID(1);
        postDTO.setTag("tag");
        postDTO.setTitle("title");
        postDTO.setDescription("Description");
        postDTO.setTimestamp(LocalDateTime.now());

        System.out.println(postDTO);
    }


}
