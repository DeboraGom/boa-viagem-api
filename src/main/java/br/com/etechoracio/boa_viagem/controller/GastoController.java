package br.com.etechoracio.boa_viagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Gastos> listarTodos(){
    	return repository.findAll();
    }
	
	
	@GetMapping("/{id}")
	public Gastos buscarPorId(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	
	}
}
