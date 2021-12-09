package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Post {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;
    
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Post_id", referencedColumnName="id")
	List<Comment> comments = new ArrayList<Comment>();

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Long id, String title, String description, List<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", comments=" + comments + "]";
	}

}
