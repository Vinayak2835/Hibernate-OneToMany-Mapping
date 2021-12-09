package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Comment;
import com.example.model.Post;
import com.example.repository.PostRepository;

@SpringBootApplication
public class HibernateOneToManyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToManyApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
         
		Post post = new Post();
		post.setTitle("FaceBook");
		post.setDescription("Profile-pic des");
		
		Comment comment1 = new Comment();
		Comment comment2 = new Comment();
		Comment comment3 =  new Comment();
		comment1.setText("Super");
		comment2.setText("Nice pic");
		comment3.setText("fab");
		
		List<Comment> commentsList = new ArrayList();
		commentsList.add(comment1);
		commentsList.add(comment2);
		commentsList.add(comment3);
		
		post.setComments(commentsList);
		
		postRepository.save(post);
		
	}

}
