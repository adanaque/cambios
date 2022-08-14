package com.cine.cambios.models.service;


import com.cine.cambios.clients.SociosFeignRest;
import com.cine.cambios.models.Cambio;
import com.cine.cambios.models.dao.CambioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CambioServiceFeignImpl implements CambioService {
	
	@Autowired
	private SociosFeignRest sociosFeignRest;



	@Autowired
	private CambioDao cambioDao;
	@Override
	public List<Cambio> findAll() {
		return (List<Cambio>) cambioDao.findAll();
	}

	@Override
	public Cambio findById(Long id) {
		return  cambioDao.findById(id).orElse(null);
	}

	@Override
	public ResponseEntity<Void> cambiarEstado(String codCliente, String estado) {
		return sociosFeignRest.modificarEstado(codCliente,estado);
	}

	@Override
	public Cambio save(Cambio cambio) {
		return cambioDao.save(cambio);
	}


}
