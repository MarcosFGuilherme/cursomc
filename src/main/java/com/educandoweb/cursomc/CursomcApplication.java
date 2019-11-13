package com.educandoweb.cursomc;

import java.text.SimpleDateFormat;
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
import com.educandoweb.cursomc.domain.ItemPedido;
import com.educandoweb.cursomc.domain.Pagamento;
import com.educandoweb.cursomc.domain.PagamentoComBoleto;
import com.educandoweb.cursomc.domain.PagamentoComCartao;
import com.educandoweb.cursomc.domain.Pedido;
import com.educandoweb.cursomc.domain.Produto;
import com.educandoweb.cursomc.domain.enums.EstadoPagamento;
import com.educandoweb.cursomc.domain.enums.TipoCliente;
import com.educandoweb.cursomc.repositories.CategoriaRepository;
import com.educandoweb.cursomc.repositories.CidadeRepository;
import com.educandoweb.cursomc.repositories.ClienteRepository;
import com.educandoweb.cursomc.repositories.EnderecoRepository;
import com.educandoweb.cursomc.repositories.EstadoRepository;
import com.educandoweb.cursomc.repositories.ItemPedidoRepository;
import com.educandoweb.cursomc.repositories.PagamentoRepository;
import com.educandoweb.cursomc.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
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
		Categoria cat3 = new Categoria(null, "Games");
		Categoria cat4 = new Categoria(null, "Cama, mesa e Banho");
		Categoria cat5 = new Categoria(null, "Infantil");
		Categoria cat6 = new Categoria(null, "Brinquedos");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		Categoria cat8 = new Categoria(null, "Decoracao");
		Categoria cat9 = new Categoria(null, "Banheiros");
		Categoria cat10 = new Categoria(null, "Lazer");
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
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3, cat4,cat5, cat6,cat7, cat8,cat9, cat10));
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
		Cidade c4 = new Cidade(null, "Piracicaba", est2);
		/*
		 * Inserindo a associacao de [Estado] com [Cidade].
		 */
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3,c4));
		/*
		 * Gravando no banco os dados das classes.
		 */
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		/*
		 * inserindo os dados de [Cliente]
		 */
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "33344455545", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		Cliente cli2 = new Cliente(null, "Tony Stark", "tony@gmail.com", "11144455999", TipoCliente.PESSOAJURIDICA);
		cli2.getTelefones().addAll(Arrays.asList("981226068","993435076"));
		Endereco e3 = new Endereco(null, "Rua Luiz Cosme", "38", "Casa", "Sta Cecilia", "13420163", cli2, c4);
		Endereco e4 = new Endereco(null, "Rua Sansao Alves dos Santos", "1385", "ap 144", "Brooklin", "04571090", cli2, c2);
		cli2.getEnderecos().addAll(Arrays.asList(e3,e4));
		
		/*
		 * Gravando no banco os dados das classes.
		 */
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3,e4));
		/*
		 * Inserindo dados de [Pedido]
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		/*
		 *  Inserindo os dados de [ItemPedido]
		 */
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00,	1, 2000.0);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00,	2, 80.0);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.0);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped1.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		/*
		 * Finalizado a primeira parte do projeto.
		 */
	}
}
