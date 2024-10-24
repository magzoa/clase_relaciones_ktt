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

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;


//Soporta la arquitectura REST
//Para solicitudes en formato Json.
@RestController
@RequestMapping("api")
public class SuscritoController {
	
@Autowired
private SuscritoRepository suscritoRepository;
	

		// URL a solicitar
@GetMapping("/suscritos")
	//Objeto suscrito --> Json
public ResponseEntity<List<Suscrito>> getSuscritos(){
	
List<Suscrito> suscritos=suscritoRepository.findAll();
	
return new ResponseEntity
<List<Suscrito>>(suscritos, HttpStatus.OK);
	
}

//Método Post -normalmente usado para crear un el.
@PostMapping("/suscrito")
public ResponseEntity<Suscrito>
				//Json --> Java
guardarSuscrito(@RequestBody Suscrito suscrito){
	
	suscritoRepository.save(suscrito);
	
	return new ResponseEntity<Suscrito>
	(suscrito, HttpStatus.OK);
}

				//recibir el id para consultar
@GetMapping("/suscrito/{id}")
public ResponseEntity<Suscrito> 
			//Obtener el id del parametro
getOneSuscrito(@PathVariable Long id){
Optional<Suscrito> susRetorno=
suscritoRepository.findById(id);
//Si encuentra
if(susRetorno.isPresent()) {
return new ResponseEntity<Suscrito>
(susRetorno.get(), HttpStatus.OK);
}else { //Si no encuentra por el id
	
	return new ResponseEntity<>
	(HttpStatus.NO_CONTENT);
}

	
}
	

	




@DeleteMapping("/suscrito/{id}")
public ResponseEntity<Suscrito> 
			//Obtener el id del parametro
removeOneSuscrito(@PathVariable Long id){
Optional<Suscrito> susRetorno=
suscritoRepository.findById(id);
//Si encuentra
if(susRetorno.isPresent()) {
	
	suscritoRepository.deleteById(id);
	
return new ResponseEntity<>
(HttpStatus.OK);
}else { //Si no encuentra por el id
	
	return new ResponseEntity<>
	(HttpStatus.NO_CONTENT);
}

	
}
	
	
	
	

}
