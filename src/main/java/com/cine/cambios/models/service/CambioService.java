package com.cine.cambios.models.service;


import com.cine.cambios.models.Cambio;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CambioService {

	List<Cambio> findAll();
	Cambio findById(Long id);
	ResponseEntity<Void> cambiarEstado(String codCliente, String estado);

	Cambio save(Cambio cambio);
}
