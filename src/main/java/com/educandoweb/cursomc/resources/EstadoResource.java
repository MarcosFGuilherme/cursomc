package com.educandoweb.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cursomc.domain.Cidade;
import com.educandoweb.cursomc.domain.Estado;
import com.educandoweb.cursomc.dto.CidadeDTO;
import com.educandoweb.cursomc.dto.EstadoDTO;
import com.educandoweb.cursomc.services.CidadeService;
import com.educandoweb.cursomc.services.EstadoService;


@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = service.findAll();
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Estado> find(@PathVariable Integer id) {
//		Estado obj = service.find(id);
//		return ResponseEntity.ok().body(obj);
//	}
//	
//	@RequestMapping(value = "/page", method = RequestMethod.GET)
//	public ResponseEntity<Page<EstadoDTO>> findPage(
//			@RequestParam(value="page", defaultValue = "0") Integer page, 
//			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, 
//			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy, 
//			@RequestParam(value="direction", defaultValue = "ASC") String direction) {
//		Page<Estado> list = service.findPage(page, linesPerPage, orderBy, direction);
//		Page<EstadoDTO> listDto = list.map(obj -> new EstadoDTO(obj));
//		return ResponseEntity.ok().body(listDto);
//	}
//	
	@RequestMapping(value = "/{estadoId}/cidades", method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = cidadeService.findCidades(estadoId);
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
}
