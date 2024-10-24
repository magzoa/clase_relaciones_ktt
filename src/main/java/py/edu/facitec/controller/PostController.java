package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Post;
import py.edu.facitec.repository.PostRepository;


//Soporta la arquitectura REST
//Para solicitudes en formato Json.
@RestController
@RequestMapping("api")
public class PostController {
	
@Autowired
private PostRepository postRepository;
	

		// URL a solicitar
@GetMapping("/posts")
	//Objeto post --> Json
public ResponseEntity<List<Post>> getPosts(){
	
List<Post> posts=postRepository.findAll();
	
return new ResponseEntity
<List<Post>>(posts, HttpStatus.OK);
	
}

//Método Post -normalmente usado para crear un el.
@PostMapping("/post")
public ResponseEntity<Post>
				//Json --> Java
guardarPost(@RequestBody Post post){
	
	postRepository.save(post);
	
	return new ResponseEntity<Post>
	(post, HttpStatus.OK);
}

				//recibir el id para consultar
@GetMapping("/post/{id}")
public ResponseEntity<Post> 
			//Obtener el id del parametro
getOnePost(@PathVariable Long id){
Optional<Post> susRetorno=
postRepository.findById(id);
//Si encuentra
if(susRetorno.isPresent()) {
return new ResponseEntity<Post>
(susRetorno.get(), HttpStatus.OK);
}else { //Si no encuentra por el id
	
	return new ResponseEntity<>
	(HttpStatus.NO_CONTENT);
}

	
}
	

	




@DeleteMapping("/post/{id}")
public ResponseEntity<Post> 
			//Obtener el id del parametro
removeOnePost(@PathVariable Long id){
Optional<Post> susRetorno=
postRepository.findById(id);
//Si encuentra
if(susRetorno.isPresent()) {
	
	postRepository.deleteById(id);
	
return new ResponseEntity<>
(HttpStatus.OK);
}else { //Si no encuentra por el id
	
	return new ResponseEntity<>
	(HttpStatus.NO_CONTENT);
}

	
}
	
	
	
	

}
