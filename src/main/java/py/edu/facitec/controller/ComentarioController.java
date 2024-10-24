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

import py.edu.facitec.model.Comentario;
import py.edu.facitec.repository.ComentarioRepository;


//Soporta la arquitectura REST
//Para solicitudes en formato Json.
@RestController
@RequestMapping("api")
public class ComentarioController {
	
@Autowired
private ComentarioRepository comentarioRepository;
	

		// URL a solicitar
@GetMapping("/comentarios")
	//Objeto comentario --> Json
public ResponseEntity<List<Comentario>> getComentarios(){
	
List<Comentario> comentarios=comentarioRepository.findAll();
	
return new ResponseEntity
<List<Comentario>>(comentarios, HttpStatus.OK);
	
}

//Método Post -normalmente usado para crear un el.
@PostMapping("/comentario")
public ResponseEntity<Comentario>
				//Json --> Java
guardarComentario(@RequestBody Comentario comentario){
	
	comentarioRepository.save(comentario);
	
	return new ResponseEntity<Comentario>
	(comentario, HttpStatus.OK);
}

				//recibir el id para consultar
@GetMapping("/comentario/{id}")
public ResponseEntity<Comentario> 
			//Obtener el id del parametro
getOneComentario(@PathVariable Long id){
Optional<Comentario> susRetorno=
comentarioRepository.findById(id);
//Si encuentra
if(susRetorno.isPresent()) {
return new ResponseEntity<Comentario>
(susRetorno.get(), HttpStatus.OK);
}else { //Si no encuentra por el id
	
	return new ResponseEntity<>
	(HttpStatus.NO_CONTENT);
}

	
}
	

	




@DeleteMapping("/comentario/{id}")
public ResponseEntity<Comentario> 
			//Obtener el id del parametro
removeOneComentario(@PathVariable Long id){
Optional<Comentario> susRetorno=
comentarioRepository.findById(id);
//Si encuentra
if(susRetorno.isPresent()) {
	
	comentarioRepository.deleteById(id);
	
return new ResponseEntity<>
(HttpStatus.OK);
}else { //Si no encuentra por el id
	
	return new ResponseEntity<>
	(HttpStatus.NO_CONTENT);
}

	
}
	
	
	
	

}
