package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// Anotación@: Provee información adicional
//a una clase, atributo o método


//Un elemento que atienda peticiones y envie respuestas
//necesitamos indicar @Controller

// Peticiones ---> request   lo que viene del cliente
// Respuestas ---> response  lo que sale del servidor
@Controller
public class HomeController {
	
	// pueden existir varios metodos 
	//para atender determinadas peticiones /...
	
	//Get --> se visualiza la escritura en el navegador.
	
	@GetMapping("/home")  //request
	public String home() {
		
System.out.println("Llegue hasta el controlador");
		
//static     /archivo/    index     .html
//defecto   ap.proper	controller   ap.proper	
		
		return "index"; //response
	}
	
	
	
	

}
