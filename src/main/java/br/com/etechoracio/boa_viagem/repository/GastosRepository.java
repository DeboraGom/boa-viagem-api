package br.com.etechoracio.boa_viagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.boa_viagem.entity.Gastos;

public interface GastosRepository extends JpaRepository<Gastos, Long>{
	
}
