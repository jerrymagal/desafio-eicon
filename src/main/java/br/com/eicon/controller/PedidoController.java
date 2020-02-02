package br.com.eicon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eicon.filter.PedidoFilter;
import br.com.eicon.model.Pedido;
import br.com.eicon.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping(produces = "application/json")
	public Page<Pedido> pesquisar(PedidoFilter filter, Pageable pageable) {
		return service.filtrar(filter, pageable);
	}
}
