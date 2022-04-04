package br.com.etechoracio.boa_viagem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.etechoracio.boa_viagem.entity.Gastos;
import br.com.etechoracio.boa_viagem.repository.GastosRepository;


@RestController
@RequestMapping("/gastos")
public class GastoController {

	private GastosRepository repository;
    public List<Gastos> listarTodos(){
    	return repository.findAll();
    }
}
