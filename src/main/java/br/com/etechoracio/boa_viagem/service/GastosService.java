package br.com.etechoracio.boa_viagem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etechoracio.boa_viagem.entity.Gastos;
import br.com.etechoracio.boa_viagem.repository.GastosRepository;
import br.com.etechoracio.boa_viagem.repository.ViagemRepository;
@Service
public class GastosService {
	@Autowired
	private GastosRepository repository;
	@Autowired
	private ViagemRepository viagemRepository;
	
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
		Optional<Gastos> existe = repository.findById(obj.getViagem().getId());
		
		if(!existe.isPresent()) {
			throw new RuntimeException("Viagem não encontrada");
		}
		
		if(existe.get().getViagem().getSaida().isPresent()){
			
		}
		
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
