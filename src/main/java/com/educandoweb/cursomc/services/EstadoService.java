package com.educandoweb.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.cursomc.domain.Estado;
import com.educandoweb.cursomc.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;

	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}
	
//	public Estado find(Integer id) {
//		Optional<Estado> obj = repo.findById(id);
//		return obj.orElseThrow(() -> new ObjectNotFoundException(
//				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
//	}
//	
//	public Page<Estado> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
//		return repo.findAll(pageRequest);
//	}
//
//	public Estado fromDTO(EstadoDTO objDTO) {
//		return new Estado(objDTO.getId(),objDTO.getNome());
//	}
	
}
