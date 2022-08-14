package com.cine.cambios.controllers;


import com.cine.cambios.models.Cambio;
import com.cine.cambios.models.service.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;


@RestController("cambios")
public class CambiosController {
	@Autowired
	private CambioService cambioService;
	
	@GetMapping("/")
	public List<Cambio> listar(){
		return cambioService.findAll();
	}
	
	@GetMapping("/estado/{dni}/{estado}")
	public Response cambiarEstado(@PathVariable String dni, @PathVariable String estado) {
		 ResponseEntity responseEntity= cambioService.cambiarEstado(dni,estado);
		 if(responseEntity.getStatusCode().is2xxSuccessful()){
			 Cambio cambio=new Cambio();
			 cambio.setEstado(estado);
			 cambio.setFechaCambio(new Date());
			 cambio.setDni(dni);
			 return Response.ok().entity(cambioService.save(cambio)).build();
		 }
		return Response.noContent().entity("Error el usuario no fue actualizado ").build();
	}

}
