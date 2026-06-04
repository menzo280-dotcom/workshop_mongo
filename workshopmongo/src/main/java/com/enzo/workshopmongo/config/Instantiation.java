package com.enzo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.enzo.workshopmongo.domain.Post;
import com.enzo.workshopmongo.domain.User;
import com.enzo.workshopmongo.dto.AuthorDTO;
import com.enzo.workshopmongo.repository.PostRepository;
import com.enzo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Silva", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User vic = new User(null, "Vic Vega", "mrblonde@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, vic));
		
		Post post1 = new Post(null, sdf.parse("21/03/2026"), "Good Idea", "I like that",  new AuthorDTO(vic));
		Post post2 = new Post(null, sdf.parse("21/03/2026"), "You ever listen to K-Billy's \"Super Sounds of the Seventies\" weekend?", "It's my personal favorite.", new AuthorDTO(vic));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
