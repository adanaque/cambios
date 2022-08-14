package com.cine.cambios.clients;

 import com.cine.cambios.models.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PatchMapping;
 import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
@FeignClient(name = "man-socios")
public interface SociosFeignRest {
	@PatchMapping("/socios/estado/{dni}/{estado}")
	public ResponseEntity<Void> modificarEstado(@PathVariable String dni, @PathVariable String estado);
}
