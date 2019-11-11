package com.educandoweb.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.educandoweb.cursomc.domain.Categoria;
import com.educandoweb.cursomc.domain.Cidade;
import com.educandoweb.cursomc.domain.Cliente;
import com.educandoweb.cursomc.domain.Endereco;
import com.educandoweb.cursomc.domain.Estado;
import com.educandoweb.cursomc.domain.Produto;
import com.educandoweb.cursomc.domain.enums.TipoCliente;
import com.educandoweb.cursomc.repositories.CategoriaRepository;
import com.educandoweb.cursomc.repositories.CidadeRepository;
import com.educandoweb.cursomc.repositories.ClienteRepository;
import com.educandoweb.cursomc.repositories.EnderecoRepository;
import com.educandoweb.cursomc.repositories.EstadoRepository;
import com.educandoweb.cursomc.repositories.ProdutoRepository;


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private  EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Inserindo os dados iniciais de [Categoria].
		 */
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		/*
		 * Inserindo os dados iniciais de [Produto].
		 */
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		/*
		 * Inserindo a associacao de [Categoria] com [Produto].
		 */
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		/*
		 * Inserindo a associacao de [Produto] com [Categoria].
		 */
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		/*
		 * Gravando no banco os dados das classes.
		 */
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		/*
		 * Inserindo os dados de [Estados]
		 */
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		/*
		 * Inserindo os dados de [Cidade]
		 */
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		/*
		 * Inserindo a associacao de [Estado] com [Cidade].
		 */
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		/*
		 * Gravando no banco os dados das classes.
		 */
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		/*
		 * inserindo os dados de [Cliente]
		 */
		Cliente cli1 = new Cliente(null, "MAria Silva", "maria@gmail.com", "33344455545", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		/*
		 * Gravando no banco os dados das classes.
		 */
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}
}
