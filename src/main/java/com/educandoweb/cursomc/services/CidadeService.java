package com.educandoweb.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.cursomc.domain.Cidade;
import com.educandoweb.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	public List<Cidade> findCidades(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
	
//	public Cidade find(Integer id) {
//		Optional<Cidade> obj = repo.findById(id);
//		return obj.orElseThrow(() -> new ObjectNotFoundException(
//				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
//	}
//	
//	public Page<Cidade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
//		return repo.findAll(pageRequest);
//	}
	
	
}
