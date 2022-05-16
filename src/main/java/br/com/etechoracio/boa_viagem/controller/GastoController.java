package br.com.etechoracio.boa_viagem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.etechoracio.boa_viagem.entity.Gastos;
import br.com.etechoracio.boa_viagem.repository.GastosRepository;
import br.com.etechoracio.boa_viagem.service.GastosService;

@RestController
@RequestMapping("/gastos")
public class GastoController {

	@Autowired
	private GastosService service;

	@GetMapping
	public List<Gastos> listarTodos() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Gastos> buscarPorId(@PathVariable Long id) {
		Optional<Gastos> existe = service.buscarPorId(id);
		
		if (existe.isPresent()) {
			return ResponseEntity.ok(existe.get());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable Long id) {
		boolean existe = service.excluir(id);

		if (existe) {
			return ResponseEntity.ok().build();
		} 
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping 
	public ResponseEntity<Gastos> inserir(@RequestBody Gastos obj) {
		service.inserir(obj);
		return ResponseEntity.ok(obj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Gastos> atualizar(@PathVariable Long id, @RequestBody Gastos gasto) {
		Optional<Gastos> existe = service.atualizar(id, gasto);
		
		if (!existe.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(gasto);
	}
}
