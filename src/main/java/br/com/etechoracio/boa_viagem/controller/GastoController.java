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

@RestController
@RequestMapping("/gastos")
public class GastoController {

	@Autowired
	private GastosRepository repository;

	@GetMapping
	public List<Gastos> listarTodos() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Gastos> buscarPorId(@PathVariable Long id) {
		Optional<Gastos> existe = repository.findById(id);
		
		if (existe.isPresent()) {
			return ResponseEntity.ok(existe.get());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable Long id) {
		boolean existe = repository.existsById(id);

		if (existe) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		} 
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping 
	public ResponseEntity<Gastos> inserir(@RequestBody Gastos obj) {
		repository.save(obj);
		return ResponseEntity.ok(obj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Gastos> atualizar(@PathVariable Long id, @RequestBody Gastos gasto) {
		boolean existe = repository.existsById(id);
		
		if (!existe) {
			return ResponseEntity.notFound().build();
		}
		repository.save(gasto);
		return ResponseEntity.ok(gasto);
	}
}
