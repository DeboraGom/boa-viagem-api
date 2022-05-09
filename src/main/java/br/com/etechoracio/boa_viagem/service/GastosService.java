package br.com.etechoracio.boa_viagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.etechoracio.boa_viagem.entity.Gastos;
import br.com.etechoracio.boa_viagem.repository.GastosRepository;

public class GastosService {
	@Autowired
	private GastosRepository repository;
	
	public List<Gastos> listarTodos() {
		return repository.findAll();
	}
	
	public Optional<Gastos> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public boolean excluir(Long id) {
		boolean existe = repository.existsById(id);

		if (existe)
			repository.deleteById(id);
		return existe;
	}
	
	public Gastos inserir(Gastos obj) {
		return repository.save(obj);
	}
	
	public Optional<Gastos> atualizar(Long id, Gastos gasto) {
		boolean existe = repository.existsById(id);
	
		if (!existe) { 
			return Optional.empty();
	    }
		return Optional.of(repository.save(gasto));
	}
}
